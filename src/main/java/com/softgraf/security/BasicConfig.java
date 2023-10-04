package com.softgraf.security;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

/*
 * Temos 3 tipos de autenticação no Jakarta Security API
 * - Autenticação Básica
 * - formulário pronto
 * - formulário personalizado
 * 
 */

@BasicAuthenticationMechanismDefinition
@DeclareRoles({"admin", "user"})
@FacesConfig
@ApplicationScoped
public class BasicConfig {

}

