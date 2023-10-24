package ru.spbstu.telematics.java;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class App {
   public static void main(String[] args) {
        // Определение первой матрицы
        double[][] matrixData1 = {{1, 2, 3}, {4, 5, 6}};
        RealMatrix matrix1 = MatrixUtils.createRealMatrix(matrixData1);

        // Определение второй матрицы
        double[][] matrixData2 = {{7, 8}, {9, 10}, {11, 12}};
        RealMatrix matrix2 = MatrixUtils.createRealMatrix(matrixData2);

        // Умножение матриц
        RealMatrix product = matrix1.multiply(matrix2);

        // Вывод результата
        System.out.println("Результат умножения матриц:");
        double[][] result = product.getData();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}





//public class App //{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
//}
