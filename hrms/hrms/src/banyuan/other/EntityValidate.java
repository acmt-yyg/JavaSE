package banyuan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author YangYonggang on 2020/10/29 2:11 下午
 * @Description:do
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityValidate {

		boolean isBlank() default true;

		String regex();

		String mag();
}
