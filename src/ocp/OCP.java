package ocp;

interface Shape {
    double calculateArea();

}

class Rectangle implements Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height =height;
    }
    
    @Override
    public double calculateArea(){
        return width * height;
    }
}


class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

public class OCP {
    public static void main(String[] args)  {
        Shape shape = new Rectangle(4, 3);
        System.out.println("Area = '" + shape.calculateArea() +"'");
    }
    
}