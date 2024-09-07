package com.vegardit.maven.parent.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Sebastian Thomschke
 */
class RuntimeJavaVersionTest {

   /**
    * This tests if the following config in the pom.xml is effective
    * <pre>{@code
    *   <properties>
    *     <java.version.unit-tests>21</java.version.unit-tests>
    *   </properties>
    * }</pre>
    */
   @Test
   void ensureJava21IsUsed() {
      final String javaVersion = System.getProperty("java.version");
      System.out.println("java.version = " + javaVersion);
      assertTrue(javaVersion.startsWith("21."), "Java 21 is expected for unit tests.");
   }
}
