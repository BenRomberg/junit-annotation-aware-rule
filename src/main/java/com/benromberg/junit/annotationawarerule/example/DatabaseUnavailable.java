package com.benromberg.junit.annotationawarerule.example;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.benromberg.junit.annotationawarerule.AnnotationRule;

@AnnotationRule(DatabaseUnavailableRule.class)
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
public @interface DatabaseUnavailable {
}
