package lec_2;

public class Assignment_3 {
    public static int find_out(double[] group) {
        int fastest_index = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] <= group[fastest_index]) {
                fastest_index = i;
            }
        }
        return fastest_index;
    }

    public static void main(String[] arguments) {
        double[] time = new double[5];
        double man_0 = 20;
        double man_1 = 19.2;
        double man_2 = 19.6;
        double man_3 = 19.9;
        double man_4 = 20.1;
        time[0] = man_0;
        time[1] = man_1;
        time[2] = man_2;
        time[3] = man_3;
        time[4] = man_4;
        int index = find_out(time);
        System.out.println(time[index]);
    }
}
