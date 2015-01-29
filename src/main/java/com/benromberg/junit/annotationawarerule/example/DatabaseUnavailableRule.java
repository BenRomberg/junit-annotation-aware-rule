package com.benromberg.junit.annotationawarerule.example;

import org.junit.rules.ExternalResource;

public class DatabaseUnavailableRule extends ExternalResource {
   @Override
   protected void before() throws Throwable {
      // code to prevent database from being available
   }

   @Override
   protected void after() {
      // code to restore proper database availability
   }
}
