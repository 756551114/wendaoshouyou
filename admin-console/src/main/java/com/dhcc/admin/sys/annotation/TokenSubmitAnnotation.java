package com.dhcc.admin.sys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenSubmitAnnotation {
    boolean needSaveToken() default false;

    boolean needRemoveToken() default false;

    String tokenName() default "token";
}
