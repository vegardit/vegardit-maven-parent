package com.vegardit.maven.parent.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.DataInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * @author Sebastian Thomschke
 */
class RuntimeJavaVersionTest {

   public static int getJavaCompilerVersion(final Class<?> clazz) throws IOException {
      try (var is = clazz.getClassLoader().getResourceAsStream(clazz.getName().replace('.', '/') + ".class");
           var dis = new DataInputStream(is)) {
         if (dis.readInt() != 0xCA_FE_BA_BE)
            throw new IllegalArgumentException("Not a valid class file");
         dis.readUnsignedShort(); // skip minor
         return dis.readUnsignedShort() - 44;
      }
   }

   /**
    * This tests if the following config in the pom.xml is effective
    * <pre>{@code
    *   <properties>
    *     <jdk.version.unit-tests>21</jdk.version.unit-tests>
    *   </properties>
    * }</pre>
    */
   @Test
   void ensureRightJDKsAreUsed() throws Exception {
      System.out.println("Compile Java Version: " + getJavaCompilerVersion(Shape.class));
      System.out.println("Runtime Java Version: " + Runtime.version().feature());
      System.out.println("java.version: " + System.getProperty("java.version"));
      System.out.println("jdk.version: " + System.getProperty("jdk.version"));
      System.out.println("jdk.version.unit-tests: " + System.getProperty("jdk.version.unit-tests"));
      assertEquals(17, getJavaCompilerVersion(Shape.class));
      assertEquals(Runtime.version().feature(), Integer.getInteger("jdk.version.unit-tests"));
   }
}
