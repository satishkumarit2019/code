package designpattern;

// Main class to test the adapter pattern
public class AdapterPatternDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Shape rectangleShape = new RectangleAdapter(rectangle);
        rectangleShape.draw();

        Square square = new Square();
        Shape squareShape = new SquareAdapter(square);
        squareShape.draw();

    }

}


class RectangleAdapter implements Shape{
    Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.drawRectangle();
    }
}


class SquareAdapter implements Shape{
    Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void draw() {
        square.drawRectangle();
    }
}

interface Shape {
    public void draw();
}

class Rectangle {

    public void drawRectangle(){
        System.out.println("Drawing rectangle");
    }

}

class Square {

    public void drawRectangle(){
        System.out.println("Drawing Square");
    }

}