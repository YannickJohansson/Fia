package com.Fia.main;

/*import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {



    private final int WHITE = 0;
    private final int RED = 1;
    private final int GREEN = 2;
    private final int YELLOW = 3;
    private final int BLUE = 4;



    private final int CELL_SIZE = 15;
    private final int N_COLS = 15;
    private final int N_ROWS = 15;

    private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 1;
    private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE + 1;

    private int[][] field;
    private boolean inGame;
    private int allCells;
    private final JLabel statusbar;

    public Board(JLabel statusbar) {
        this.statusbar = statusbar;
        initBoard();
    }
    private void initBoard() {

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        //addMouseListener(new MinesAdapter());
        newGame();
    }
    private void newGame() {
        int cell;

        var random = new Random();
        inGame = true;

        allCells = N_ROWS * N_COLS;
        field = new int[a][b];

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3,3,0,0));

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
        frame.add(new JButton("6"));
        frame.add(new JButton("7"));
        frame.add(new JButton("8"));
        frame.add(new JButton("9"));

        frame.setVisible(true);

        for (int i = 0; i < allCells; i++) {


            field[i] = WHITE;
        }
    }
}*/
