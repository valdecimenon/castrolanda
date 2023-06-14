package reflection.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// essa anotação poderá ser usada somente em classes
@Target(ElementType.TYPE)
// será acessível pela aplicação e pela JVM em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
public @interface Entidade {
	
	// método público, com retorno padrão (não é obrigatório)
	String nome() default "";

}
