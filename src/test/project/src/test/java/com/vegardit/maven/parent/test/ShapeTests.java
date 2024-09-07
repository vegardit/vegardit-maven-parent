package com.vegardit.maven.parent.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vegardit.maven.parent.test.Shape.Circle;
import com.vegardit.maven.parent.test.Shape.Rectangle;

/**
 * @author Sebastian Thomschke
 */
class ShapeTests {
   private Shape circle;
   private Shape rectangle;

   @BeforeEach
   void setup() {
      circle = new Circle(5.0);
      rectangle = new Rectangle(10.0, 20.0);
   }

   @Test
   void testDescribeCircle() {
      final String description = Shape.describeShape(circle);
      assertEquals("Circle with radius: 5.0", description);
   }

   @Test
   void testDescribeRectangle() {
      final String description = Shape.describeShape(rectangle);
      assertEquals("Rectangle with length: 10.0 and width: 20.0", description);
   }
}
