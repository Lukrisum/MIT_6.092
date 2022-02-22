package lec_0;

public class GravityCalculator {
    public static void main(String[] argument){
        double t,y,vi,xi,a;
        vi=17.0;
        xi=0.0;
        a=7;
        t=3;
        y = .5*a*t*t+vi*t+xi;
        System.out.println(y);
    }
}

