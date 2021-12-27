public class Sudoku {

    private static final int SUDOKU_SIZE = 9;
    private int[][] board = new int[9][9];
    
    /**
     Creates a 9x9 2D array with 20 numbers which are randomly 
     spread through the 2D Array.
     Precondition: none
     Postcondition: 9x9 Sudoku Board is randomly created
     
     */ 
       
    public Sudoku() {
        int count = 0;
        int[][] ex = new int[9][9];
        int[][] empty = new int[9][9];
        while(true){
            while(count != 20)
            {
                int row= (int)(Math.random() * (9)+ 0);
                int column= (int)(Math.random() * (9)+ 0);
                int number = (int)(Math.random() * (9)+ 1);
                if(board[row][column] == 0 && isValidNumber(number, row, column))
                {
                    board[row][column]= number;
                    ex[row][column]= number;
                    count++;
                }
            }
            if(solve()){
                board = ex;
                break;
            } else {
                board = empty;
                ex = empty;
                count=0;
            }
        }

    }
    /**
     Creates a 2D array Sudoku board
     Precondition: The board inputed must me a valid 9x9 Sudoku board
     Postcondition: Sudoku Board is generated
     
     @param int[][];
     */ 
    public Sudoku(int[][] myBoard) {
        board = myBoard;
    }
    
    /*
    Returns the sudoku board
    Precondition: Sudoku object must be initialiazed.
    Postcondition: board is returned.

    @return int[][]
    */
    public int[][] getBoard(){
        return board;
    }

/*
    Print a sudoku board
    Precondition: Sudoku object must be initialiazed.
    Postcondition: a sudoku board is printed.

    @return  none
    */
    public void printSudoku(){
        for(int i = 0; i < SUDOKU_SIZE;i++){
            if(i%3 == 0 && i != 0){
                System.out.println("-----+-----+-----");
            } else if(i != 0) {
                System.out.println("-----------------");
            }
            for(int j = 0; j < SUDOKU_SIZE;j++){
                if(j != 0){
                    System.out.print("|"); 
                }
                System.out.print(board[i][j]);
            }
        System.out.println();
        }
    }
 /*
    Determines if a number is in a certain row
    Precondition: Sudoku object must be initialiazed.
    Postcondition: A boolean is returned
    @param: int, int
    @return: boolean
    */   
    public boolean isInRow (int number, int row){
        for(int i = 0; i < SUDOKU_SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }
    /* Determines if a number is in a certain column
    Precondition: Sudoku object must be initialiazed.
    Postcondition: A boolean is returned
    @param: int, int
    @return: boolean
    */   
    public  boolean isInColumn (int number, int column){
        for(int i = 0; i < SUDOKU_SIZE; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }
/*
    Determines if a number is in a certain 3x3 box
    Precondition: Sudoku object must be initialiazed.
    Postcondition: A boolean is returned
    @param: int, int, int
    @return: boolean
    */   
    public boolean isInBox (int number, int row, int column){
        int boxCornerRow = row - row % 3;
        int boxCornerColumn = column - column % 3;

        for(int i = boxCornerRow; i < boxCornerRow + 3; i++){
            for(int j = boxCornerColumn; j < boxCornerColumn + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Determines if a number is valid for a given for position in the Sudoku board
    Precondition: Sudoku object must be initialiazed.
    Postcondition: A boolean is returned
    @param: int, int
    @return: boolean
    */   
    public boolean isValidNumber(int number, int row, int column){
        return !isInRow(number, row) && !isInColumn(number, column) && !isInBox(number, row, column);
    }
    /*
    Determines if it is possible to solve a Sudoko board and solves the Sudoku board
    Precondition: Sudoku object must be initialiazed.
    Postcondition:  A boolean is returned and the Sudoku board is solved

    @return boolean
    */
    public boolean solve() {
        for (int row = 0; row < SUDOKU_SIZE; row++) {
            for (int column = 0; column < SUDOKU_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int i = 1; i <= SUDOKU_SIZE; i++) {
                        if (isValidNumber(i, row, column)){
                            board[row][column] = i;
                            if(solve()){
                                return true;
                            } else{
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
