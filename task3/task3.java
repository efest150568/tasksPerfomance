import java.io.*;
import java.util.*;

public class task3 {
    public static void main(String[] args) throws IOException {

        Scanner sc1 = new Scanner(new FileInputStream(args[0] +"cash1.txt"));
        List<Double> numbers1 = new ArrayList<>();
        while (sc1.hasNextLine()) {
            String replaced = sc1.nextLine();
            numbers1.add(Double.parseDouble(replaced.replace("/n", "")));
        }
        double[] cash1 = new double[numbers1.size()];
        for (int i = 0; i < cash1.length; i++) {
            cash1[i] = numbers1.get(i);
        }
        sc1.close();

        Scanner sc2 = new Scanner(new FileInputStream(args[0] +"cash2.txt"));
        List<Double> numbers2 = new ArrayList<>();
        while (sc2.hasNextLine()) {
            String replaced = sc2.nextLine();
            numbers2.add(Double.parseDouble(replaced.replace("/n", "")));
        }
        double[] cash2 = new double[numbers2.size()];
        for (int i = 0; i < cash2.length; i++) {
            cash2[i] = numbers2.get(i);
        }
        sc2.close();

        Scanner sc3 = new Scanner(new FileInputStream(args[0] +"cash3.txt"));
        List<Double> numbers3 = new ArrayList<>();
        while (sc3.hasNextLine()) {
            String replaced = sc3.nextLine();
            numbers3.add(Double.parseDouble(replaced.replace("/n", "")));
        }
        double[] cash3 = new double[numbers3.size()];
        for (int i = 0; i < cash3.length; i++) {
            cash3[i] = numbers3.get(i);
        }
        sc2.close();

        Scanner sc4 = new Scanner(new FileInputStream(args[0] +"cash4.txt"));
        List<Double> numbers4 = new ArrayList<>();
        while (sc4.hasNextLine()) {
            String replaced = sc4.nextLine();
            numbers4.add(Double.parseDouble(replaced.replace("/n", "")));
        }
        double[] cash4 = new double[numbers4.size()];
        for (int i = 0; i < cash4.length; i++) {
            cash4[i] = numbers4.get(i);
        }
        sc2.close();

        Scanner sc5 = new Scanner(new FileInputStream(args[0] +"cash5.txt"));
        List<Double> numbers5 = new ArrayList<>();
        while (sc5.hasNextLine()) {
            String replaced = sc5.nextLine();
            numbers5.add(Double.parseDouble(replaced.replace("/n", "")));
        }
        double[] cash5 = new double[numbers5.size()];
        for (int i = 0; i < cash5.length; i++) {
            cash5[i] = numbers5.get(i);
        }
        sc2.close();

        double max = 0.0;
        int maxIndex = 0;
        double[] sum = new double[cash1.length];
        for (int i = 0; i < cash1.length; i++) {
            sum[i] = cash1[i] + cash2[i] + cash3[i] + cash4[i] + cash5[i];
            if (sum[i] > max) {
                max = sum[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }
}