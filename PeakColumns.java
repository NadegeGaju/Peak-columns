import java.util.Scanner;

public class PeakColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows and columns: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter elements of matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        findPeakColumns(matrix);
    }

    private static void findPeakColumns(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isRowMax = true;
                boolean isColMin = true;

                //loop to verify if the element is the maximum one in that row 
                for (int k = 0; k < cols; k++) {
                    if (matrix[i][k] > matrix[i][j]) {
                        isRowMax = false;
                        break;
                    }
                }

                //loop to verify if the element is the minimum in the column
                for (int k = 0; k < rows; k++) {
                    if (matrix[k][j] < matrix[i][j]) {
                        isColMin = false;
                        break;
                    }
                }

                if (isRowMax && isColMin) {
                    System.out.println("(" + i + "," + j + ") = " + matrix[i][j]);
                }
            }
        }
    }
}