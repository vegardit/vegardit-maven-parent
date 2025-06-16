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
    *     <java.version.unit-tests>21</java.version.unit-tests>
    *   </properties>
    * }</pre>
    */
   @Test
   void ensureRightJDKsAreUsed() throws Exception {
      System.out.println("Compile Java Version: " + getJavaCompilerVersion(Shape.class));
      System.out.println("Runtime Java Version: " + Runtime.version().feature());
      System.out.println("java.version: " + System.getProperty("java.version"));
      System.out.println("java.version.unit-tests: " + System.getProperty("java.version.unit-tests"));
      assertEquals(17, getJavaCompilerVersion(Shape.class));
      assertEquals(Runtime.version().feature(), Integer.getInteger("java.version.unit-tests"));
   }
}
