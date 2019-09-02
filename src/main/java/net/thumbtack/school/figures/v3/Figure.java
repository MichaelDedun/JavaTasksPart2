package net.thumbtack.school.figures.v3;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;

import java.util.Objects;

public abstract class Figure implements Colored, HasArea {

    private Color color;

    public Figure(Color color) throws ColorException {
        setColor(color);
    }

    public Figure(String color) throws ColorException {
        this(Color.colorFromString(color));
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void moveRel(int dx, int dy);


    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public abstract boolean isInside(Point2D point2D);

    public abstract boolean isInside(int x, int y);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return color == figure.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
