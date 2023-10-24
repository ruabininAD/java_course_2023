package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;





import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
public class AppTest extends TestCase
{
    public AppTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        return new TestSuite(AppTest.class);
    }

    public void testMatrixMultiplication()
    {
        double[][] matrixData1 = {{33, 15, 4}, {52, 42, 2}};
        RealMatrix matrix1 = MatrixUtils.createRealMatrix(matrixData1);

        double[][] matrixData2 = {{1, 5}, {3, 2}, {4, 2}};
        RealMatrix matrix2 = MatrixUtils.createRealMatrix(matrixData2);

        RealMatrix product = matrix1.multiply(matrix2);

        double[][] expectedData = {{94, 203}, {186, 348}};
        RealMatrix expected = MatrixUtils.createRealMatrix(expectedData);

        double epsilon = 1e-9; // Define a small value for comparing floating point numbers

        assertTrue(expected.subtract(product).getNorm() < epsilon);
    }
}
