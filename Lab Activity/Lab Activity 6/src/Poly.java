public class Poly {
    public static void main(String[] args) {
        // Create Shape array
        Shape[] shapes = new Shape[4];

        // Create shapes, 2 rectangles & 3 circles
        Rectangle rec1 = new Rectangle(2, 4);
        Rectangle rec2 = new Rectangle(5, 6);
        Circle cir1 = new Circle(2);
        Circle cir2 = new Circle(5);
        Circle cir3 = new Circle(3.141);

        // Add shapes to array
        shapes[0] = rec1;
        shapes[1] = rec2;
        shapes[2] = cir1;
        shapes[3] = cir2;

        // A variable to store the total area for all the shapes
        double totalArea = 0;

        for (int i = 0; i < 5; i++){
            totalArea += shapes[i].calculateArea();
            System.out.println("Shape: " + shapes[i].getClass().getName() + "\t Area: " + shapes[i].calculateArea());
        }
        System.out.println("Total area: " + totalArea);
    }
}

abstract class Shape {
    abstract double calculateArea();
}

class Circle extends Shape {
    private double radius;

    public Circle(double r){
        this.radius = r;
    }

    @Override
    double calculateArea() {
        return radius * radius * Math.PI;
    }
}

class Rectangle extends Shape {

    private double width, height;

    public Rectangle(double w, double h){
        this.width = w;
        this.height = h;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}