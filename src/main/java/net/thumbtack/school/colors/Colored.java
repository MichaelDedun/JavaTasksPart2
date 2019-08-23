package net.thumbtack.school.colors;

public interface Colored {

    void setColor(String colorString) throws ColorException;

    void setColor(Color color) throws ColorException;

    Color getColor();
}
