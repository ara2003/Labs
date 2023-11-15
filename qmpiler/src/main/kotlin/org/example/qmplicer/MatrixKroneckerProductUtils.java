package org.example.qmplicer;

import org.apache.commons.math.linear.Array2DRowRealMatrix;
import org.apache.commons.math.linear.RealMatrix;

import java.util.List;

public class MatrixKroneckerProductUtils {

    /**
     * Calculate the Kronecker product of a list of matrices.  Applies the
     * Kronecker product following the list order (i.e. from left to right).
     *
     * @param matrixList list of matrices
     * @return Kronecker product of matrices
     */
    public static RealMatrix getKroneckerProduct(List<RealMatrix> matrixList)
    {
        if (matrixList == null || matrixList.size() <= 0)
            throw new IllegalArgumentException("no input matrices");
        if (matrixList.size() == 1)
            return matrixList.get(0); // nothing to do, only one matrix

        // calculate the dimensions of the Kronecker product matrix
        int totalRows = 1;
        int totalCols = 1;
        for(RealMatrix matrix: matrixList)
        {
            totalRows *= matrix.getRowDimension();
            totalCols *= matrix.getColumnDimension();
        }

        // create a matrix to hold the data
        double[][] productData = new double[totalRows][totalCols];
        // initialize to 1 (allows us to multiple the contents of each matrix
        // onto the result sequentially
        for(int prodRow = 0; prodRow < totalRows; prodRow++)
        {
            for(int prodCol = 0; prodCol < totalCols; prodCol++)
            {
                productData[prodRow][prodCol] = 1;
            }
        }

        // multiply the contents of each matrix onto the result
        int maxRow = totalRows;
        int maxCol = totalCols;
        for(RealMatrix matrix: matrixList)
        {
            maxRow /= matrix.getRowDimension();
            maxCol /= matrix.getColumnDimension();
            int matrixRow = 0;
            int matrixCol = 0;
            // multiply onto the result
            for(int prodRow = 0, sectionRow = 0; prodRow < totalRows; prodRow++, sectionRow++)
            {
                matrixCol = 0;
                double value = matrix.getEntry(matrixRow, matrixCol);
                for(int prodCol = 0, sectionCol = 0; prodCol < totalCols; prodCol++, sectionCol++)
                {
                    productData[prodRow][prodCol] *= value;
                    if (sectionCol >= maxCol - 1)
                    {
                        matrixCol++;
                        if (matrixCol >= matrix.getColumnDimension()) matrixCol = 0;
                        sectionCol = -1;
                        value = matrix.getEntry(matrixRow, matrixCol);
                    }
                }
                if (sectionRow >= maxRow-1)
                {
                    matrixRow++;
                    if (matrixRow >= matrix.getRowDimension()) matrixRow = 0;
                    sectionRow = -1;
                }
            }
        }

        // return a new matrix containing the Kronecker product
        return new Array2DRowRealMatrix(productData);
    }

    /**
     * Calculate the Kronecker product of two matrices
     *
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @return Kronecker product of matrix 1 and matrix 2
     */
    public static RealMatrix getKroneckerProduct(RealMatrix matrix1, RealMatrix matrix2)
    {
        if (matrix1 == null ||matrix2 == null)
            throw new IllegalArgumentException("null input matrix");

        int m1Rows = matrix1.getRowDimension();
        int m1Cols = matrix1.getColumnDimension();
        int m2Rows = matrix2.getRowDimension();
        int m2Cols = matrix2.getColumnDimension();

        double[][] productData = new double[m1Rows*m2Rows][m1Cols * m2Cols];
        RealMatrix productMatrix = new Array2DRowRealMatrix(productData);
        for(int col = 0; col < m1Cols; col++)
        {
            for(int row = 0; row < m1Rows; row++)
            {
                productMatrix.setSubMatrix((matrix2.scalarMultiply(matrix1.getEntry(row, col))).getData(),
                        row * m2Rows, col * m2Cols);
            }
        }

        return productMatrix;
    }

}
