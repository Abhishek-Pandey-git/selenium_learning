import java.util.Scanner;

public class MatrixOperations {
    
    public void addMatrix(int[][] a, int[][] b, int row, int col) {
        int[][] result = new int[row][col];
        System.out.println("Addition Result:");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                result[i][j] = a[i][j] + b[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void subtractMatrix(int[][] a, int[][] b, int row, int col) {
        int[][] result = new int[row][col];
        System.out.println("Subtraction Result:");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                result[i][j] = a[i][j] - b[i][j];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void multiplyMatrix(int[][] a, int[][] b, int r1, int c1, int c2) {
        int[][] result = new int[r1][c2];
        System.out.println("Multiplication Result:");
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) {
                result[i][j] = 0;
                for(int k = 0; k < c1; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void transposeMatrix(int[][] matrix, int row, int col) {
        int[][] result = new int[col][row];
        System.out.println("Transpose:");
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                result[i][j] = matrix[j][i];
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean isSquare(int row, int col) {
        return row == col;
    }
    
    public boolean isDiagonal(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isIdentity(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j && matrix[i][j] != 1) {
                    return false;
                }
                if(i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MatrixOperations mo = new MatrixOperations();
        
        System.out.print("Enter rows for matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns for matrix A: ");
        int c1 = sc.nextInt();
        
        int[][] a = new int[r1][c1];
        System.out.println("Enter elements of matrix A:");
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        
        System.out.print("Enter rows for matrix B: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns for matrix B: ");
        int c2 = sc.nextInt();
        
        int[][] b = new int[r2][c2];
        System.out.println("Enter elements of matrix B:");
        for(int i = 0; i < r2; i++) {
            for(int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        
        if(r1 == r2 && c1 == c2) {
            mo.addMatrix(a, b, r1, c1);
            mo.subtractMatrix(a, b, r1, c1);
        }
        
        if(c1 == r2) {
            mo.multiplyMatrix(a, b, r1, c1, c2);
        }
        
        mo.transposeMatrix(a, r1, c1);
        
        System.out.println("Matrix A is square: " + mo.isSquare(r1, c1));
        
        if(mo.isSquare(r1, c1)) {
            System.out.println("Matrix A is diagonal: " + mo.isDiagonal(a, r1));
            System.out.println("Matrix A is identity: " + mo.isIdentity(a, r1));
        }
        
        sc.close();
    }
}
