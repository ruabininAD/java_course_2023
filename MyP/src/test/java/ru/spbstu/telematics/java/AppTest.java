package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

/*
public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    public void testApp()
    {
        assertTrue( true );
    }
*/



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
        double[][] matrixData1 = {{1, 2, 3}, {4, 5, 6}};
        RealMatrix matrix1 = MatrixUtils.createRealMatrix(matrixData1);

        double[][] matrixData2 = {{7, 8}, {9, 10}, {11, 12}};
        RealMatrix matrix2 = MatrixUtils.createRealMatrix(matrixData2);

        RealMatrix product = matrix1.multiply(matrix2);

        double[][] expectedData = {{58, 64}, {139, 154}};
        RealMatrix expected = MatrixUtils.createRealMatrix(expectedData);

        double epsilon = 1e-9; // Define a small value for comparing floating point numbers

        assertTrue(expected.subtract(product).getNorm() < epsilon);
    }
}
