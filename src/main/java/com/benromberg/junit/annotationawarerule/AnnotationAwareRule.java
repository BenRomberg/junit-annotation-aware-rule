package com.benromberg.junit.annotationawarerule;

import static java.util.stream.Collectors.toList;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class AnnotationAwareRule implements TestRule {
   public Statement apply(Statement base, Description description) {
      Stream<Annotation> allAnnotations = Stream.concat(Arrays.stream(description.getTestClass().getAnnotations()), description.getAnnotations().stream());
      List<TestRule> annotationRules = allAnnotations.flatMap(annotation -> {
         AnnotationRule annotationRule = annotation.annotationType().getAnnotation(AnnotationRule.class);
         if (annotationRule == null) {
            return Stream.empty();
         }
         return Stream.of(createTestRule(annotationRule));
      }).collect(toList());
      return new RunRules(base, annotationRules, description);
   }

   private TestRule createTestRule(AnnotationRule annotationRule) {
      try {
         return annotationRule.value().newInstance();
      }
      catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}
