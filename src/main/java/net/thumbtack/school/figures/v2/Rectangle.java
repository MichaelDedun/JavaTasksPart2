package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Rectangle extends Figure {
    private Point2D leftTop;
    private Point2D rightBottom;

    public Rectangle(Point2D leftTop, Point2D rightBottom, int color) {
        super(color);
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }


    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    public Rectangle(int length, int width, int color) {
        this(new Point2D(0, -width), new Point2D(length, 0), color);
    }

    public Rectangle(int color) {
        this(new Point2D(0, -1), new Point2D(1, 0), color);
    }

    public Point2D getTopLeft() {
        return leftTop;
    }

    public Point2D getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point2D TopLeft) {
        this.leftTop = TopLeft;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.rightBottom = bottomRight;
    }

    public int getLength() {
        return rightBottom.getX() - leftTop.getX();
    }

    public int getWidth() {
        return rightBottom.getY() - leftTop.getY();
    }

    public void moveRel(int dx, int dy) {
        leftTop.moveRel(dx, dy);
        rightBottom.moveRel(dx, dy);
    }

    public void enlarge(int nx, int ny) {
        setBottomRight(new Point2D(leftTop.getX() + getLength() * nx, leftTop.getY() + getWidth() * ny));
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * getLength() + 2 * getWidth();
    }

    public boolean isInside(int x, int y) {
        return x <= rightBottom.getX() && x >= leftTop.getX() && y <= rightBottom.getY() && y >= leftTop.getY();
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return Math.max(leftTop.getX(), rectangle.leftTop.getX()) <= Math.min(rightBottom.getX(), rectangle.rightBottom.getX()) &&
                Math.max(leftTop.getY(), rectangle.leftTop.getY()) <= Math.min(rightBottom.getY(), rectangle.rightBottom.getY());
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.getTopLeft()) && isInside(rectangle.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) &&
                Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), leftTop, rightBottom);
    }
}
