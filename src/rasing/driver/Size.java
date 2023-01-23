package rasing.driver;

public enum Size {
    XS(10,25),
    S(26,50),
    M(51,80),
    L(81,120),
    XL(121,150);

    private int min;
    private int max;

    Size(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    public static Size getValue(int value){
        for (Size e: Size.values()){
            if (value>= e.getMin()&& value<=e.getMax()){
                System.out.println(e);
                return e;
            }
        }
        return null;
    }
}
