package lsp;


interface Shape {
    int getArea();
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }
    @Override
    public int getArea() {
        return side * side;
    }

}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public int getArea() {
        return width * height;
    }
}
public class mainlspGood {
    public static void main(String[] args) {
        Shape square =  new Square(3);
        Shape rectangle = new Rectangle(3, 4);
        System.out.println("Square Area: "+square.getArea());
        System.out.println ("Rectangle Area: "+rectangle.getArea());

    }
    
}
