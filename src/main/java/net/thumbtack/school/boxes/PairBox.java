package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class PairBox<T extends Figure, R extends Figure> implements HasArea {

    private T ConetentFirst;
    private R ContentSecond;

    public PairBox(T conetentFirst, R contentSecond) {
        ConetentFirst = conetentFirst;
        ContentSecond = contentSecond;
    }

    public T getConetentFirst() {
        return ConetentFirst;
    }

    public void setConetentFirst(T conetentFirst) {
        ConetentFirst = conetentFirst;
    }

    public R getContentSecond() {
        return ContentSecond;
    }

    public void setContentSecond(R contentSecond) {
        ContentSecond = contentSecond;
    }

    public boolean isAreaEqual(PairBox pairBox) {
        return getArea() == pairBox.getArea();
    }

    public static boolean isAreaEqual(PairBox pairBox1, PairBox pairBox2) {
        return pairBox1.getArea() == pairBox2.getArea();
    }

    @Override
    public double getArea() {
        return getConetentFirst().getArea() + getContentSecond().getArea();
    }

    public static void main(String[] args) {

    }


}
