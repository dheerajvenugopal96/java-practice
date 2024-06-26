package dsa.src.general;

import dsa.src.general.Phones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumAnnotation {

    Phones phone() default Phones.NONE;
}