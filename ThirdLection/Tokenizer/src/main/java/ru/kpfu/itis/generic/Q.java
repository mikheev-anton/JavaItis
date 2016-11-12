package ru.kpfu.itis.generic;

public class Q <X,Y,Z> {
    private Object x;
    private Object y;
    private Object z;

    public Q(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int allCalc(){
        int totalSum = 0;
        totalSum += getSumByType(x);
        totalSum += getSumByType(y);
        totalSum += getSumByType(z);
        return totalSum;
    }

    private int getSumByType(Object obj) {
        int sum = 0;
        if (obj instanceof D) {
            D z = (D)obj;
            sum = z.calc();
        }
        else if (obj instanceof B){
            B z = (B)obj;
            sum = z.calc2();
        }
        return sum;
    }
}
