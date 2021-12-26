public class Sudoku {

    private static final int SUDOKU_SIZE = 9;
    private int[][] board = new int[9][9];
    
    public Sudoku() {
        int count = 0;
        int[][] ex = new int[9][9];
        int[][] empty = new int[9][9];
        while(true){
            while(count != 16)
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
            }
        }

    }
    
    public Sudoku(int[][] myBoard) {
        board = myBoard;
    }

    public int[][] getBoard(){
        return board;
    }


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
    
    public boolean isInRow (int number, int row){
        for(int i = 0; i < SUDOKU_SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    public  boolean isInColumn (int number, int column){
        for(int i = 0; i < SUDOKU_SIZE; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }

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
    public boolean isValidNumber(int number, int row, int column){
        return !isInRow(number, row) && !isInColumn(number, column) && !isInBox(number, row, column);
    }
    
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
