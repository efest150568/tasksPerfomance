import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

public class task1 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new FileInputStream(args[0]));
        List<Double> numbers = new ArrayList<>();
        while (sc.hasNextLine()) {
            String replaced = sc.nextLine();
            numbers.add(Double.parseDouble(replaced.replace("/n", "")));
        }
        sc.close();//Заношу данные из файла в лист

        double[] num = new double[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            num[i] = numbers.get(i);
        }

        double sum = 0;
        for(int i = 0; i < num.length; i++){
            sum = sum + num[i];
        }
        //double average = sum/num.length; //Считаю среднее значение


        DecimalFormatSymbols local = new DecimalFormatSymbols(Locale.US);
        DecimalFormat f = new DecimalFormat("#0.00", local); // 2 знака после запятой

        Percentile percentile = new Percentile();
        Arrays.sort(num);

        System.out.println(f.format(percentile.withEstimationType(Percentile.EstimationType.R_7).evaluate(num, 90)));
        System.out.println(f.format(percentile.withEstimationType(Percentile.EstimationType.R_7).evaluate(num, 50)));
        System.out.println(f.format(num[num.length-1]));
        System.out.println(f.format(num[0]));
        System.out.println(f.format(getMiddle(sum, num.length)));
    }
    public static double getMiddle(double sum, int quantity){
        return sum/quantity;//Считаю среднее значение
    }
}