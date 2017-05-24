package CGC.utils;

public class Vector2D {
    private double x;
    private double y;
    public double getX(){
        return x;
    }
    public double getY() {
        return y;
    }
    public Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector2D(double x1, double y1, double x2, double y2) {
        this.x = x2 - x1;
        this.y = y2 - y1;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double dotProduct(Vector2D other) {
        return getX() * other.getX() + getY() * other.getY();
    }

    public double vectorProduct(Vector2D other) {
        return getX() * other.getY() - other.getX() * getY();
    }

    public double angleBetween(Vector2D other) {
        return Math.acos(dotProduct(other) / (getLength() * other.getLength()));
    }

    public double getPolarAngle() {
        return Math.atan2(y, x);
    }

    public void scalarMultiply(double scalar) {
        this.x = this.x * scalar;
        this.y = this.y * scalar;
    }

    public void addVector(Vector2D other) {
        this.x += other.getX();
        this.y += other.getY();
    }
}
