package com.benromberg.junit.annotationawarerule;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.rules.TestRule;

@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface AnnotationRule {
   Class<? extends TestRule> value();
}
