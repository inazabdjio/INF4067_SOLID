package ocp;

public class AreaCalculatorBad {
    public double calculateArea(Object shape) {
        if (shape instanceof RectangleBad) {
            RectangleBad rectangle = (RectangleBad) shape;
            return rectangle.getWidth() * rectangle.getHeight();
        }else if (shape instanceof CircleBad) {
            CircleBad circle = (CircleBad) shape;
            return Math.PI * circle.getRadius() * circle.getRadius();
        }

        throw new IllegalArgumentException("Unknown shape");

    }
    


public static void main(String[] args) {
    AreaCalculatorBad calculator = new AreaCalculatorBad();
    //Creation des formes

    RectangleBad rect = new RectangleBad();
    CircleBad circle = new CircleBad();

    //Tester le calcul
    System.out.println("Aire du rectangle = " + calculator.calculateArea(rect));;
    System.out.println("Aire du cercle = " + calculator.calculateArea(circle));

}
}

class RectangleBad {
    public double getWidth() { return 4; }
    public double getHeight() { return 3; }
}

class CircleBad {
    public double getRadius() { return 2; }
}
