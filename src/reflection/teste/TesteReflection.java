package reflection.teste;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import reflection.entidades.Pessoa;

public class TesteReflection {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa(101, "João da Silva", "Rua Santana, 820");
		
		System.out.println("\n=== Modificadores");
		System.out.printf("public = %d", Modifier.PUBLIC);
		System.out.printf("\nprivate = %d", Modifier.PRIVATE);
		
		Class<?> classe = pessoa.getClass();
		System.out.printf("\n\nNome da classe: %s", classe.getSimpleName());
		
		listaCampos(classe);
		
		listaMetodos(classe);
		
		infoMetodo(classe, "setNome");
		
		infoMetodo(classe, "toString");
		
		listaParametros(classe.getMethods()[4]);  // pode alterar o índice
		
		executaMetodos(pessoa);
		
		listaAnotacoesDaClasse(classe);
		
		listaAnotacoesDosMetodos(classe);
	}

	private static void listaAnotacoesDosMetodos(Class<?> classe) {
		Method[] metodos = classe.getMethods();
		for (Method m : metodos) {
			Annotation[] anotacoes = m.getAnnotations();
			
			if (anotacoes.length > 0) {
				System.out.printf("\n=== Anotações do método %s\n", m.getName());
				for (Annotation a : anotacoes) {
					System.out.println(a);
				}
			}
		}
	}

	private static void listaAnotacoesDaClasse(Class<?> classe) {
		Annotation[] anotacoes = classe.getAnnotations();
		System.out.printf("\n\n=== Anotações da classe %s\n", classe.getSimpleName());
		for (Annotation a : anotacoes) {
			System.out.println(a);
		}
	}

	private static void executaMetodos(Pessoa pessoa) {
		Class<?> classe = pessoa.getClass();
		System.out.println("\n\n=== Executa todos os métodos get");
		
		for (Method m : classe.getMethods()) {
			String nome = m.getName();
			
			if (nome.substring(0, 3).equalsIgnoreCase("get")) {
				// torna acessível membros públicos e privados
				m.setAccessible(true);
				
				try {
					Object valor = m.invoke(pessoa);
					System.out.printf("%s() = %s\n", nome, valor);
					
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void listaParametros(Method m) {
		Parameter[] parametros = m.getParameters();
		System.out.printf("\n\n=== Parâmetros do método %s()", m.getName());
		for (Parameter p : parametros) {
			System.out.printf("\nNOME: %s  TIPO: %s\n",
								p.getName(), p.getType().getSimpleName());
		}
		
	}

	private static void infoMetodo(Class<?> classe, String nomeMetodo) {
		Method[] metodos = classe.getMethods();
		for (Method m : metodos) {
			if (m.getName().equalsIgnoreCase(nomeMetodo)) {
				System.out.printf("\n=== Tipo de retorno do método %s() = %s\n",
									nomeMetodo, m.getReturnType().getSimpleName());
				System.out.printf("=== Quantidade de parâmetros do método %s = %d\n",
									nomeMetodo, m.getParameterCount());
			}
		}
		
	}

	private static void listaMetodos(Class<?> classe) {
		Method[] metodos = classe.getMethods();
		System.out.printf("\n=== Métodos da classe %s\n", classe.getSimpleName());
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
	}

	private static void listaCampos(Class<?> classe) {
		Field[] campos = classe.getDeclaredFields();
		System.out.printf("\n\n==== Campos da classe %s\n", classe.getSimpleName());
		
		for (Field f : campos) {
			System.out.printf("CAMPO: %-20s  TIPO: %-20s   MODIFICADOR: %d\n",
								f.getName(), f.getType().getSimpleName(), f.getModifiers());
		}
	}

}
