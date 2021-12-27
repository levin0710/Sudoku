/*
Levin Sanchez
Sudoku Solver and Generator
This program generates and solves a random 9*9 Sudoku board.
*/

public class SudokuTester {
    public static void main(String[] args){

        Sudoku test = new Sudoku(); // generates a random and valid Sudoku
        System.out.println();
        test.printSudoku(); // Prints the Sudoku Board to the console log.
        System.out.println();
        System.out.println("This Sudoku board is valid: " + test.solve()); // Determines if
        // the Sudoku board is valid and then solves it.
        System.out.println();
        test.printSudoku(); // prints the solved Sudoku board.
        System.out.println();
        
    }
}
