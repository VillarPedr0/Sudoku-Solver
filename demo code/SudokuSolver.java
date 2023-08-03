public class SudokuSolver {

    private static final int N = 9;
    private static final int lugarvacio = 0;

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 8, 0, 5, 0, 0, 0, 0},
            {1, 0, 0, 9, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 0, 7, 0},
            {0, 0, 4, 0, 0, 0, 8, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {2, 0, 0, 1, 6, 0, 0, 0, 7},
            {0, 0, 2, 3, 9, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 5, 0, 0, 9},
            {3, 0, 0, 0, 0, 7, 0, 0, 0}
        };

        if (solucionarSudoku(grid)) {
            printGrid(grid);
        } else {
            System.out.println("No hay solución");
        }
    }

    private static boolean solucionarSudoku(int[][] grid) {
        int[] emptyCell = buscarVacio(grid);
        int fila = emptyCell[0];
        int col = emptyCell[1];

        if (fila == -1) {
            return true; // Sudoku resuelto
        }

        for (int num = 1; num <= 9; num++) {
            if (esFactible(grid, fila, col, num)) {
                grid[fila][col] = num;

                if (solucionarSudoku(grid)) {
                    return true;
                }

                grid[fila][col] = lugarvacio; // Deshacer el cambio si no lleva a una solución
            }
        }

        return false; // No se encontró una solución en este camino
    }

    private static int[] buscarVacio(int[][] grid) {
        int[] result = {-1, -1};

        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                if (grid[fila][col] == lugarvacio) {
                    result[0] = fila;
                    result[1] = col;
                    return result;
                }
            }
        }

        return result; // No hay celdas vacías
    }

    private static boolean usadoenFila(int[][] grid, int fila, int num) {
        for (int col = 0; col < N; col++) {
            if (grid[fila][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usadoenCol(int[][] grid, int col, int num) {
        for (int fila = 0; fila < N; fila++) {
            if (grid[fila][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usadoen3x3(int[][] grid, int fila3x3, int col3x3, int num) {
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                if (grid[fila + fila3x3][col + col3x3] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean esFactible(int[][] grid, int fila, int col, int num) {
        return !usadoenFila(grid, fila, num) &&
               !usadoenCol(grid, col, num) &&
               !usadoen3x3(grid, fila - fila % 3, col - col % 3, num) &&
               grid[fila][col] == lugarvacio;
    }

    private static void printGrid(int[][] grid) {
        for (int fila = 0; fila < N; fila++) {
            for (int col = 0; col < N; col++) {
                System.out.print(grid[fila][col] + " ");
            }
            System.out.println();
        }
    }
}

