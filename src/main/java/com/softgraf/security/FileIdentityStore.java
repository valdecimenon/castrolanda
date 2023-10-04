package com.softgraf.security;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped  // CDI contexto de aplicação
public class FileIdentityStore implements IdentityStore {

	private Properties props;
	
	@PostConstruct
	public void init() {
		props = new Properties();
		
		try {
			props.load(getClass().getResourceAsStream("/com/softgraf/security/usuarios.properties"));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private boolean isUsuarioValido(String nomeUsuario, String senha) {
		String senhaProp = props.getProperty("senha_" + nomeUsuario);
		return senha.equals(senhaProp);
	}
	
	private Set<String> grupos(String nomeUsuario){
		String grupos = props.getProperty("roles_" + nomeUsuario);  // "admin,user"
		
		if (grupos == null)
			return null;
		
		return Stream.of(grupos.split(",")).collect(Collectors.toSet()); 
	} 

	
	// credential vem com os dados digitados na tela de login
	@Override
	public CredentialValidationResult validate(Credential credential) {
		UsernamePasswordCredential usuario = (UsernamePasswordCredential) credential;
		
		String nomeUsuario = usuario.getCaller();
		String senha = usuario.getPasswordAsString();
		
		if (!isUsuarioValido(nomeUsuario, senha)) {
			return CredentialValidationResult.INVALID_RESULT;
		}
		
		Set<String> grupos = grupos(nomeUsuario);
		return new CredentialValidationResult(nomeUsuario, grupos);
	}
	
	
}
