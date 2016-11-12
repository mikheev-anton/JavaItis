package ru.kpfu.itis.generic;

public class Q <X extends B,Y extends B,Z extends D> {
    private X x;
    private Y y;
    private Z z;

    public Q(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int allCalc(){
        int totalSum = 0;
        totalSum += x.calc2();
        totalSum += y.calc2();
        totalSum += z.calc();
        return totalSum;
    }
}
