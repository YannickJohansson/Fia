package com.Fia.main;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Game extends JFrame {
    public static int sizeStandard = 32;
    public static int choice;
    public static String text = "Din mamma";

    public static boolean illegal;
    public static String phase = "start";
    public static String turn = "red";
    public static String winner;
    public static boolean canMove;
    public static int roll;

    public static int players = 1;
    static int[][] redPath = {
            //RED
            { 0, 6 }, { 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 6 },
            { 6, 5 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },
            //GREEN
            { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 6 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 }, { 14, 7 },
            //YELLOW
            { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 }, { 9, 8 }, { 8, 8 },
            { 8, 9 }, { 8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 }, { 8, 14 }, { 7, 14 },
            //BLUE
            { 6, 14 }, { 6, 13 }, { 6, 12 }, { 6, 11 }, { 6, 10 }, { 6, 9 }, { 6, 8 },
            { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 }, { 0, 7 },
            //END
            { 1, 7 }, { 2, 7 }, { 3, 7 }, { 4, 7 }, { 5, 7 }, { 6, 7 }, { 7, 7 }
    };
    /*private JLabel statusbar;

    public Game() {

        initUI();
    }

    private void initUI() {

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);

        add(new Board(statusbar));

        setResizable(false);
        pack();

        setTitle("Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
    public static LinkedList<GamePiece> gp = new LinkedList<>();

    public static GamePiece selectedPiece=null;
    public static void main(String[] args) {
        String[][] field = new String[15][15];


        /*field[0][1] = "red";
        field[1][0] = "blue";

        field[0][0] = field[2][3] = field[3][2] = field[3][3] = "redBase";
        field[11][2] = field[11][3] = field[12][2] = field[12][3] = "yellowBase";
        field[11][11] = field[11][12] = field[12][11] = field[12][12] = "greenBase";
        field[2][11] = field[2][12] = field[3][11] = field[3][12] = "blueBase";*/

        field[0][6] = field[1][7] = field[2][7] = field[3][7]= field[4][7] = field[5][7] = field[6][7] = "red";
        field[8][0] = field[7][1] = field[7][2]= field[7][3] = field[7][4] = field[7][5] = field[7][6] = "yellow";
        field[14][8] = field[13][7] = field[12][7] = field[11][7]= field[10][7] = field[9][7] = field[8][7] = "green";
        field[6][14] = field[7][13] = field[7][12] = field[7][11]= field[7][10] = field[7][9] = field[7][8] = "blue";
        field[7][7] = "black";

        GamePiece red1 = new GamePiece("red", 1,0,false, gp);
        /*GamePiece red2 = new GamePiece("red", 2, 0, false, gp);
        GamePiece red3 = new GamePiece("red", 3, 0, false, gp);
        GamePiece red4 = new GamePiece("red", 4, 0, false, gp);*/
        GamePiece yellow1 = new GamePiece("yellow", 1, 0, false, gp);
        /*GamePiece yellow2 = new GamePiece("yellow", 2, 0, false, gp);
        GamePiece yellow3 = new GamePiece("yellow", 3, 0, false, gp);
        GamePiece yellow4 = new GamePiece("yellow", 4, 0, false, gp);*/
        GamePiece green1 = new GamePiece("green", 1, 0, false, gp);
        /*GamePiece green2 = new GamePiece("green", 2, 0, false, gp);
        GamePiece green3 = new GamePiece("green", 3, 0, false, gp);
        GamePiece green4 = new GamePiece("green", 4, 0, false, gp);*/
        GamePiece blue1 = new GamePiece("blue", 1, 0, false, gp);
        /*GamePiece blue2 = new GamePiece("blue", 2, 0, false, gp);
        GamePiece blue3 = new GamePiece("blue", 3, 0, false, gp);
        GamePiece blue4 = new GamePiece("blue", 4, 0, false,gp);*/
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 544,608);
        frame.setResizable(false);
        JPanel ludo = new JPanel() {
            @Override
            public void paint(Graphics g) {
                if (players == 0) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                    g.drawString("Welcome to Ludo.", 150, sizeStandard + 100);
                    g.drawString("To choose amount of human players, ", 75, 200);
                    g.drawString("press [1], [2], [3] or [4] on your keyboard.", 75, 250);
                    for (int i = 1; i < 4; i ++) {

                    }
                } else {
                    g.setColor(Color.white);
                    g.fillRect(400,10, 50, 50);
                    g.setColor(Color.black);
                    switch(roll) {
                        case 1:
                            g.fillOval(420,30,10,10);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            g.fillOval(405,15,10,10);
                            g.fillOval(435,15,10,10);
                            g.fillOval(405,45,10,10);
                            g.fillOval(435,45,10,10);
                            break;
                        case 5:
                            g.fillOval(405,15,10,10);
                            //g.fillOval(420,15,10,10);
                            g.fillOval(435,15,10,10);
                            //g.fillOval(405,30,10,10);
                            g.fillOval(420,30,10,10);
                            //g.fillOval(435,30,10,10);
                            g.fillOval(405,45,10,10);
                            //g.fillOval(420,45,10,10);
                            g.fillOval(435,45,10,10);
                            break;
                        default:
                            g.fillOval(405,15,10,10);
                            //g.fillOval(420,15,10,10);
                            g.fillOval(435,15,10,10);
                            //g.fillOval(405,30,10,10);
                            g.fillOval(420,30,10,10);
                            //g.fillOval(435,30,10,10);
                            g.fillOval(405,45,10,10);
                            //g.fillOval(420,45,10,10);
                            g.fillOval(435,45,10,10);
                            break;
                    }

                    for(int i = 0; i < 15; i++) {
                        for(int j = 0; j < 15; j++) {
                            if(field[i][j] == "redBase") {
                                g.setColor(Color.red);
                            }
                            else if(field[i][j] == "greenBase") {
                                g.setColor(Color.green);
                            }
                            else if(field[i][j] == "blueBase") {
                                g.setColor(Color.blue);
                            }
                            else if(field[i][j] == "yellowBase") {
                                g.setColor(Color.yellow);
                            }
                            else if(field[i][j] == "red") {
                                g.setColor(Color.red);
                            }
                            else if(field[i][j] == "green") {
                                g.setColor(Color.green);
                            }
                            else if(field[i][j] == "blue") {
                                g.setColor(Color.blue);
                            }
                            else if(field[i][j] == "yellow") {
                                g.setColor(Color.yellow);
                            }
                            else if(field[i][j] == "black") {
                                g.setColor(Color.black);
                            }
                            else {
                                g.setColor(Color.white);
                            }
                            //String test = Integer.toString(i) + "." + Integer.toString(j);

                            //g.drawString(test,i*32+32, j*32+32);
                            g.fillOval(i * 32+sizeStandard, j * 32+sizeStandard * 2,32,32);
                        }
                    }
                    g.setColor(Color.black);
                    for(GamePiece p: gp) {
                        if(p.team == "red") {
                            g.setColor(Color.red);
                        }
                        else if(p.team == "yellow") {
                            g.setColor(Color.yellow);
                        }
                        else if(p.team == "green") {
                            g.setColor(Color.green);
                        }
                        else if(p.team == "blue") {
                            g.setColor(Color.blue);
                        }
                        g.fillRect(p.xp * 32,p.yp * 32, 32, 32);
                    }
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                    g.drawString(text, sizeStandard, sizeStandard + 16);
                }
                //g.fillRect(0, 0,sizeStandard * 10,sizeStandard * 2);

            }
        };

        frame.add(ludo);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(phase == "start") {
                    /*switch(button) {
                        case 49:
                            players = 1;
                            break;
                        case 50:
                            players = 2;
                            break;
                        case 51:
                            players = 3;
                            break;
                        case 52:
                            players = 4;
                            break;
                        default:
                            return;
                    }
                    phase = "dice";
                    frame.repaint();*/
                }
                if(phase == "dice") {
                    /*if(button == 82) {
                        roll = (int)Math.floor(Math.random()*(6-1+1)+1);
                        System.out.println("You rolled a " + roll);
                        checkIfPlayerCanMove();
                    } else { System.out.println("lol"); }*/
                }
                if(phase == "move") {
                    selectedPiece = null;
                    for(GamePiece p: gp) {
                        if(p.team == turn && p.xp <= e.getX()/32 && e.getX()/32 <= p.xp && p.yp <= e.getY()/32 - 1 && e.getY()/32 - 1 <= p.yp) {
                            selectedPiece = p;
                        }
                    }
                    System.out.println(selectedPiece.progress);
                    if(selectedPiece.ready){
                        selectedPiece.move(selectedPiece.xp, selectedPiece.yp,roll);
                        System.out.println(selectedPiece.progress);
                        setTurn();
                    }
                    else if(!selectedPiece.ready) {
                        System.out.println("Move is invalid, pick another piece.");
                    }
                    else {
                        return;
                    }
                    frame.repaint();
                }

                System.out.println(red1.xp + " " + red1.yp);
                System.out.println(e.getX()/32 + " " + e.getY()/32);


                frame.repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                /*int button = e.getKeyCode();
                System.out.println(e.getKeyCode());
                if(phase == "start") {
                    switch(button) {
                        case 49:
                            players = 1;
                            break;
                        case 50:
                            players = 2;
                            break;
                        case 51:
                            players = 3;
                            break;
                        case 52:
                            players = 4;
                            break;
                        default:
                            return;
                    }
                    phase = "dice";
                    frame.repaint();
                }
                if(phase == "dice") {
                    if(button == 82) {
                        roll = (int)Math.floor(Math.random()*(6-1+1)+1);
                        System.out.println("You rolled a " + roll);
                        checkIfPlayerCanMove();
                    } else { System.out.println("lol"); }
                }
                if(phase == "move") {
                    selectedPiece = null;
                    for(GamePiece p: gp) {
                        switch(button) {
                            case 49:
                                if(p.team == turn && p.nr == 1) {
                                    selectedPiece = p;
                                }
                                break;
                            case 50:
                                if(p.team == turn && p.nr == 2) {
                                    selectedPiece = p;
                                }
                                break;
                            case 51:
                                if(p.team == turn && p.nr == 3) {
                                    selectedPiece = p;
                                }
                                break;
                            case 52:
                                if(p.team == turn && p.nr == 4) {
                                    selectedPiece = p;
                                }
                                break;
                            default:
                                return;
                        }
                    }
                    System.out.println(selectedPiece.progress);
                    if(selectedPiece.ready){
                        selectedPiece.move(selectedPiece.xp, selectedPiece.yp,roll);
                        System.out.println(selectedPiece.progress);
                        setTurn();
                    }
                    else if(!selectedPiece.ready) {
                        System.out.println("Move is invalid, pick another piece.");
                    }
                    else {
                        return;
                    }
                    frame.repaint();
                }*/
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        while(true) {

        }
    }
    public static GamePiece getPiece(int x, int y) {
        int xp = x/32;
        int yp = y/32;
        for(GamePiece p: gp) {
            if(p.xp==xp&&p.yp==yp) {
                return p;
            }
        }
        return null;
    }
    public static void Fia() {
        while(true) {
            phase = "dice";

        }

    }
    public static void setTurn() {
        for(GamePiece p: gp) {
            p.ready = false;
        }
        switch(turn) {
            case "red":
                turn = "yellow";
                break;
            case "yellow":
                turn = "green";
                break;
            case "green":
                turn = "blue";
                break;
            case "blue":
                turn = "red";
                break;
        }
        System.out.println("Turn: " + turn);
        System.out.println("Press [R] to roll the dice");
        phase = "dice";
    }
    public static boolean checkIfPlayerCanMove() {
        canMove = false;
        for(GamePiece p: gp) {
            if(p.team == turn) {
                if(p.checkMove(p.xp, p.yp, roll)) {
                    p.ready = true;
                    canMove = true;
                    System.out.println("Can move");
                }
                else {
                    System.out.println(p.checkMove(p.xp, p.yp, roll));
                }
            }
        }
        if(canMove) {
            System.out.println("Pick a piece to move");
            phase = "move";
        } else {
            System.out.println("No valid moves to make");
            setTurn();
        }
        return true;
    }
    public static void moveAI() {
        for(GamePiece p: gp) {
            if(p.ready) {
                if((p.progress == 0) && (p.canKnockout)) {
                    selectedPiece = p;
                } else if(p.canKnockout){
                    selectedPiece = p;
                } else if(p.progress == 0){
                    selectedPiece = p;
                } else if(p.progress + roll > p.path.length){
                    selectedPiece = p;
                }
            }
        }
        selectedPiece.move(selectedPiece.xp, selectedPiece.yp,roll);
    }
    public static void dice() {

        if((turn == "yellow"&&players < 3) || (turn == "green"&&players < 2) || (turn == "blue"&&players < 4)) {
            System.out.print(turn + " turn: " + " player is rolling the dice...");
            text = turn + " turn: AI is rolling the dice";
            roll = (int)Math.floor(Math.random()*(6-1+1)+1);
            System.out.println("They rolled a " + roll + ". Choosing move..." );
            if(checkIfPlayerCanMove()) {
                if(checkIfPlayerCanMove()) {
                    moveAI();
                } else {
                    System.out.println("No valid moves to make");
                    setTurn();
                }
            }
        } else {
            text = turn + " turn: Press [R] to roll the dice";
            phase = "dice";
            if(checkIfPlayerCanMove()) {
                System.out.println("Pick a piece to move using the corresponding number on your keyboard");
                phase = "move";
            } else {
                System.out.println("No valid moves to make");
                setTurn();
            }
        }
    }

    public static void winPhase() {

    }
}
