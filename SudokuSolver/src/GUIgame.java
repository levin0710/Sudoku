
import javax.swing.*;
import java.awt.*;

public class GUIgame{
    private Cell[][] cells;
    private static final int SIZE = 9, GAP = 2;
    private final JFrame jFrame;
    private Sudoku game = new Sudoku();

    public GUIgame (){
		jFrame = new JFrame("Sudoku");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        buildUi();
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void buildUi() {

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        jFrame.add(gridPanel, BorderLayout.CENTER);
        cells = new Cell[SIZE][SIZE];
        int[][] gameboard = game.getBoard();
        for(int row=0; row <cells.length; row++) {
            for(int col=0; col<cells[row].length; col++) {
                Cell cell = new Cell(gameboard[row][col]); //initialize with random number for demo
                cells[row][col] = cell;
                gridPanel.add(cell);
            }
        }

        jFrame.add(new JLabel("Help:           "),  BorderLayout.SOUTH);
    }
    
}

class Cell extends JLabel {

    private static int CELL_H =35, CELL_W = 35;

    Cell(int value) {
        super(String.valueOf(value));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        setPreferredSize(new Dimension(CELL_H , CELL_W));
        setOpaque(true);
    }
}
