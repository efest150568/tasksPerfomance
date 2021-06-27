import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class task2 {



    public static void main(String[] args) throws IOException {
        BufferedReader sqr = new BufferedReader(new FileReader(args[0]));
        List<String> lines2 = new ArrayList<>();
        while (sqr.ready()) {
            String replaced = sqr.readLine();
            lines2.add(replaced.replace("/n", ""));
        }
        sqr.close();
        int matrixWidthSqr = lines2.get(0).split(" ").length; // кол-во значений в строке
        int matrixHeightSqr = lines2.size();// кол-во строк

        float [] x = new float[lines2.size()];
        float [] y = new float[lines2.size()];

        for (int i = 0; i < matrixHeightSqr; i++) {
            for (int j = 0; j < matrixWidthSqr-1; j++) {
                String[] line = lines2.get(i).split(" ");
                x[i] = Float.parseFloat(line[j]);// присвоение значений x четырехугольнику
            }
        }
        for (int i = 0; i < matrixHeightSqr; i++) {
            for (int j = 1; j < matrixWidthSqr; j++) {
                String[] line = lines2.get(i).split(" ");
                y[i] = Float.parseFloat(line[j]);// присвоение значений y четырехугольнику
            }
        }

        BufferedReader points = new BufferedReader(new FileReader(args[1]));
        List<String> lines = new ArrayList<>();
        while (points.ready()) {
            String replaced = points.readLine();
            lines.add(replaced.replace("/n", ""));
        }
        points.close();

        int matrixWidthPoint = lines.get(0).split(" ").length;
        int matrixHeightPoint = lines.size();

        float [] pointX = new float[lines.size()];
        float [] pointY = new float[lines.size()];

        for (int i = 0; i < matrixHeightPoint; i++) {
            for (int j = 0; j < matrixWidthPoint-1; j++) {
                String[] line = lines.get(i).split(" ");
                pointX[i] = Float.parseFloat(line[j]); // присвоение значений x точкам
            }
        }

        for (int i = 0; i < matrixHeightPoint; i++) {
            for (int j = 1; j < matrixWidthPoint; j++) {
                String[] line = lines.get(i).split(" ");
                pointY[i] = Float.parseFloat(line[j]);// присвоение значений y точкам
            }
        }
        for(int i = 0; i < lines.size();i++) {
            float d1 = (((x[1] - x[0]) * (pointY[i] - y[0])) - ((pointX[i] - x[0]) * (y[1] - y[0])));
            float d2 = (((x[2] - x[1]) * (pointY[i] - y[1])) - ((pointX[i] - x[1]) * (y[2] - y[1])));
            float d3 = (((x[3] - x[2]) * (pointY[i] - y[2])) - ((pointX[i] - x[2]) * (y[3] - y[2])));
            float d4 = (((x[0] - x[3]) * (pointY[i] - y[3])) - ((pointX[i] - x[3]) * (y[0] - y[3])));
            if (pointX[i] == x[0] && pointY[i] == y[0]) {
                System.out.println("0");
            } else if (pointX[i] == x[1] && pointY[i] == y[1]) {
                System.out.println("0");
            } else if (pointX[i] == x[2] && pointY[i] == y[2]) {
                System.out.println("0");
            } else if (pointX[i] == x[3] && pointY[i] == y[3]) { //Проверка точки на принадлежность вершине
                System.out.println("0");
            } else if (d1 == 0) {
                System.out.println("1");
            } else if (d2 == 0) {
                System.out.println("1");
            } else if (d3 == 0) {
                System.out.println("1");
            } else if (d4 == 0) {
                System.out.println("1");//Проверка точки на принадлежность одной из сторон
            } else if (d1 < 0 && d2 < 0 && d3 < 0 && d4 < 0) {
                System.out.println("2");//Проверка точки на принадлежность внутренней части.
                // Четырехгольник повернут по часовой. Следовательно, если все значения детерминта отрицалеьные,
                // то точка находится внутри четырехугольника.
            } else {
                System.out.println("3");
            }
        }
    }

}
