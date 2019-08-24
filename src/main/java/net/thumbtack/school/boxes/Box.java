package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class Box <T extends Figure>  implements HasArea {
     private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public double getArea() {
        return content.getArea();
    }

    public boolean isAreaEqual(Box box) {
        return content.getArea() == box.getContent().getArea();
    }

    public static boolean isAreaEqual(Box box1, Box box2) {
        return box1.getContent().getArea() == box2.getContent().getArea();
    }
}
