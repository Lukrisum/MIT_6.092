package lec_1;

public class FooCorporation {
    public static double pay(double base_pay,double work_time) {
        double Minimum_wage = 8.00;
        int Maximum_work = 60;
        if(work_time>Maximum_work
                || work_time < 0
                || base_pay < Minimum_wage
        ){
            return -1;
        }
        else{
            if(work_time <= 40){
                Minimum_wage = Minimum_wage * 1.5;
            }
            else{
                return -1;
            }
        }
        double pay = Minimum_wage * work_time + base_pay;
        return pay;
    }
    public static void main(String[] args) {
        System.out.println((int)pay(10,30));
    }
}
