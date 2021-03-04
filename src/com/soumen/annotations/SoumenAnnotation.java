package com.soumen.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Soumen Karmakar
 * @Date 04/03/2021
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SoumenAnnotation {

    String createdBy() default "Soumen";

    String lastModified() default "0-0-0";

    String[] tags() default "";

    Priority priority() default Priority.MEDIUM;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }


}
