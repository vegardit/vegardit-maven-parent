package com.vegardit.maven.parent.test;

import java.util.Objects;

/**
 * @author Sebastian Thomschke
 */
public abstract sealed class Shape {

   public static final class Circle extends Shape {
      private final double radius;

      public Circle(final double radius) {
         this.radius = radius;
      }

      @Override
      public boolean equals(final Object o) {
         if (this == o)
            return true;
         if (o == null || getClass() != o.getClass())
            return false;
         final Circle circle = (Circle) o;
         return Double.compare(circle.radius, radius) == 0;
      }

      @Override
      public int hashCode() {
         return Objects.hash(radius);
      }

      public double radius() {
         return radius;
      }
   }

   public static final class Rectangle extends Shape {
      private final double length;
      private final double width;

      public Rectangle(final double length, final double width) {
         this.length = length;
         this.width = width;
      }

      @Override
      public boolean equals(final Object o) {
         if (this == o)
            return true;
         if (o == null || getClass() != o.getClass())
            return false;
         final Rectangle rectangle = (Rectangle) o;
         return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.width, width) == 0;
      }

      @Override
      public int hashCode() {
         return Objects.hash(length, width);
      }

      public double length() {
         return length;
      }

      public double width() {
         return width;
      }
   }

   public static String describeShape(final Shape shape) {
      if (shape instanceof final Circle c)
         return "Circle with radius: " + c.radius();
      else if (shape instanceof final Rectangle r)
         return "Rectangle with length: " + r.length() + " and width: " + r.width();
      return "Unknown shape";
   }
}
