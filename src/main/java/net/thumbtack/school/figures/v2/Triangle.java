package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Triangle extends Figure {

    private Point2D point1, point2, point3;

    public Triangle(Point2D point1, Point2D point2, Point2D point3, int color) {
        super(color);
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point2D getPoint1() {
        return point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public Point2D getPoint3() {
        return point3;
    }

    public void setPoint1(Point2D point) {
        this.point1 = point;
    }

    public void setPoint2(Point2D point) {
        this.point2 = point;
    }

    public void setPoint3(Point2D point) {
        this.point3 = point;
    }

    public double getSide(Point2D firstPoint, Point2D secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2) + (Math.pow(secondPoint.getY() - firstPoint.getY(), 2)));
    }

    public double getSide12() {
        return getSide(point1, point2);
    }

    public double getSide13() {
        return getSide(point1, point3);
    }

    public double getSide23() {
        return getSide(point2, point3);
    }

    public void moveRel(int dx, int dy) {
        getPoint1().moveRel(dx, dy);
        getPoint2().moveRel(dx, dy);
        getPoint3().moveRel(dx, dy);
    }

    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p - getSide12())*(p - getSide23())*(p - getSide13()));
    }

    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    public boolean isInside(int x, int y) {
        int a = (point1.getX() - x) * (point2.getY() - point1.getY()) - (point2.getX() - point1.getX()) * (point1.getY() - y);
        int b = (point2.getX() - x) * (point3.getY() - point2.getY()) - (point3.getX() - point2.getX()) * (point2.getY() - y);
        int c = (point3.getX() - x) * (point1.getY() - point3.getY()) - (point1.getX() - point3.getX()) * (point3.getY() - y);
        return a >= 0 && b >= 0 && c >= 0 || a <= 0 && b <= 0 && c <= 0;
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), point1, point2, point3);
    }
}
