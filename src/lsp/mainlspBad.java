package lsp;


class RectangleBad {
    protected int width;
    protected int height;

    public void setWidht(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class SquareBad extends RectangleBad {
    @Override
    public void setWidht(int width){
        super.setWidht((width));
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidht(height);
        super.setHeight(height);

    }
}
public class mainlspBad {
    public static void main(String[] args) {
        RectangleBad rectangleBad = new RectangleBad();
        rectangleBad.setHeight(5);
        rectangleBad.setHeight(4);
        System.out.println("Aire du Rectangle ="+rectangleBad.getArea());

        RectangleBad rectangle1 = new SquareBad();
        rectangle1.setWidht(5);
        rectangle1.setHeight(4);// attend une aire de 20, mais obtient 16 (4x4)
        System.out.println("Aire du carre ="+rectangle1.getArea());

    }
    
}
