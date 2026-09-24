package com.vegardit.maven.parent.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Verifies that the inherited Failsafe execution uses the integration-test JDK and JVM arguments.
 *
 * @author Sebastian Thomschke
 */
class RuntimeJavaVersionITest {

   @Test
   void ensureRightJDKIsUsed() {
      final String expectedVersion = System.getProperty("jdk.version.integration-tests");
      // Only Failsafe supplies this argument, so accidental execution by Surefire must fail.
      assertNotNull(expectedVersion, "Failsafe must pass the configured integration-test JDK version.");
      assertEquals(Integer.parseInt(expectedVersion), Runtime.version().feature());
   }
}
