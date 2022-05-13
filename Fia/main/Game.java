package com.Fia.main;//package com.Fia.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class Game extends JFrame {
    public static int sizeStandard = 32;
    public static int diceX;
    public static int diceY;
    public static int pause = 0;
    public static String text;

    public static boolean illegal;
    public static String phase = "start";
    public static String input;
    public static int wait;
    public static String turn = "Blue";
    public static boolean Ai;
    public static boolean winner;
    public static boolean canMove;
    public static String difficulty;
    public static int roll;
    public static int random;
    public static int players = 0;
    public static int opponents = 0;

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

        field[1][6] = field[2][6] = field[3][6] = field[4][6] = field[5][6] = field[6][6] =
        field[6][5] = field[6][4] = field[6][3] = field[6][2] = field[6][1] = field[6][0] = field[7][0]
        = field[8][1] = field[8][2] = field[8][3] = field[8][4] = field[8][5] = field[8][6] =
        field[9][6] = field[10][6] = field[11][6] = field[12][6] = field[13][6] = field[14][6] = field[14][7]
        = field[13][8] = field[12][8] = field[11][8] = field[10][8] = field[9][8] = field[8][8] =
        field[8][9] = field[8][10] = field[8][11] = field[8][12] = field[8][13] = field[8][14] = field[7][14]
        = field[6][13] = field[6][12] = field[6][11] = field[6][10] = field[6][9] = field[6][8] =
        field[5][8] = field[4][8] = field[3][8] = field[2][8] = field[1][8] = field[0][8] = field[0][7]
        = "white";

        field[0][6] = field[1][7] = field[2][7] = field[3][7]= field[4][7] = field[5][7] = field[6][7] = "red";
        field[8][0] = field[7][1] = field[7][2]= field[7][3] = field[7][4] = field[7][5] = field[7][6] = "yellow";
        field[14][8] = field[13][7] = field[12][7] = field[11][7]= field[10][7] = field[9][7] = field[8][7] = "green";
        field[6][14] = field[7][13] = field[7][12] = field[7][11]= field[7][10] = field[7][9] = field[7][8] = "blue";
        field[7][7] = "black";

        GamePiece red1 = new GamePiece("Red",0,0, 1,0,false, gp);
        GamePiece red2 = new GamePiece("Red",2,0, 2,0,false, gp);
        GamePiece red3 = new GamePiece("Red",0,2, 3,0,false, gp);
        GamePiece red4 = new GamePiece("Red",2,2, 4,0,false, gp);
        GamePiece yellow1 = new GamePiece("Yellow",12,0, 1, 0, false, gp);
        GamePiece yellow2 = new GamePiece("Yellow",14,0, 2, 0, false, gp);
        GamePiece yellow3 = new GamePiece("Yellow",12,2, 3, 0, false, gp);
        GamePiece yellow4 = new GamePiece("Yellow",14,2, 4, 0, false, gp);
        GamePiece green1 = new GamePiece("Green",12,12, 1, 0, false, gp);
        GamePiece green2 = new GamePiece("Green",14,12, 2, 0, false, gp);
        GamePiece green3 = new GamePiece("Green",12,14, 3, 0, false, gp);
        GamePiece green4 = new GamePiece("Green",14,14, 4, 0, false, gp);
        GamePiece blue1 = new GamePiece("Blue",0,12, 1, 0, false, gp);
        GamePiece blue2 = new GamePiece("Blue",2,12, 2, 0, false, gp);
        GamePiece blue3 = new GamePiece("Blue",0,14, 3, 0, false, gp);
        GamePiece blue4 = new GamePiece("Blue",2,14, 4, 0, false, gp);
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 544,608);
        frame.setResizable(false);
        JPanel ludo = new JPanel() {
            @Override
            public void paint(Graphics g) {
                if(phase == "start") {
                    if(players == 0) {
                        //System.out.println("checkpoint2");
                        g.drawString("Welcome to Ludo.", 150, sizeStandard + 100);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                        g.drawString("Choose amount of human players", 25, 200);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                        g.drawRect(25,250,100,100);
                        g.drawString("1", 50, 335);
                        g.drawRect(150,250,100,100);
                        g.drawString("2", 175, 335);
                        g.drawRect(275,250,100,100);
                        g.drawString("3", 300, 335);
                        g.drawRect(400,250,100,100);
                        g.drawString("4", 425, 335);
                    }
                    else if(opponents > 0) {
                        //System.out.println("checkpoint3");
                        g.drawString("Welcome to Ludo.", 150, sizeStandard + 100);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                        g.drawString("Choose the difficulty of your opponents", 25, 200);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
                        g.drawRect(100,200,344,50);
                        g.drawString("Easy", 100, 240);
                        g.drawRect(100,255,344,50);
                        g.drawString("Medium", 100, 295);
                        g.drawRect(100,310,344,50);
                        g.drawString("Hard", 100, 350);
                        g.drawRect(100,365,344,50);
                        g.drawString("Impossible", 100, 405);
                    }
                    else {
                        //System.out.println("checkpoint4");
                        g.drawString("Welcome to Ludo.", 150, sizeStandard + 100);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                        g.drawString("Choose amount of AI opponents", 25, 200);
                        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
                        switch(players) {
                            case 1:
                                g.drawRect(400,250,100,100);
                                g.drawString("3", 425, 335);
                            case 2:
                                g.drawRect(275,250,100,100);
                                g.drawString("2", 300, 335);
                            case 3:
                                g.drawRect(150,250,100,100);
                                g.drawString("1", 175, 335);
                                if(players > 1) {
                                    g.drawRect(25,250,100,100);
                                    g.drawString("0", 50, 335);
                                }
                                break;
                            case 4:
                                //phase="";
                                break;
                        }
                        frame.repaint();
                    }
                }
                else if(phase == "win") {
                    switch(turn) {
                        case "Red":
                            diceX = 168;
                            diceY = 200;
                            g.setColor(Color.red);
                            break;
                        case "Yellow":
                            diceX = 328;
                            diceY = 200;
                            g.setColor(Color.yellow);
                            break;
                        case "Green":
                            diceX = 328;
                            diceY = 360;
                            g.setColor(Color.green);
                            break;
                        case "Blue":
                            diceX = 168;
                            diceY = 360;
                            g.setColor(Color.blue);
                            break;
                        default:
                            diceX = 168;
                            diceY = 200;
                            g.setColor(Color.white);
                            break;
                    }
                    g.drawString(turn + " has won. Click anywhere to start another game.", sizeStandard, sizeStandard + 16);
                }
                else {
                    //System.out.println("Painting...");
                    switch(turn) {
                        case "Red":
                            diceX = 168;
                            diceY = 200;
                            g.setColor(Color.red);
                            break;
                        case "Yellow":
                            diceX = 328;
                            diceY = 200;
                            g.setColor(Color.yellow);
                            break;
                        case "Green":
                            diceX = 328;
                            diceY = 360;
                            g.setColor(Color.green);
                            break;
                        case "Blue":
                            diceX = 168;
                            diceY = 360;
                            g.setColor(Color.blue);
                            break;
                        default:
                            diceX = 168;
                            diceY = 200;
                            g.setColor(Color.white);
                            break;
                    }
                    g.fillRect(diceX, diceY, 50, 50);
                    g.setColor(Color.black);
                    switch(roll) {
                        case 1:
                            g.fillOval(diceX+20,diceY+20,10,10);
                            break;
                        case 2:
                            g.fillOval(diceX+5,diceY+5,10,10);
                            g.fillOval(diceX+35,diceY+35,10,10);
                            break;
                        case 3:
                            g.fillOval(diceX+5,diceY+5,10,10);
                            g.fillOval(diceX+20,diceY+20,10,10);
                            g.fillOval(diceX+35,diceY+35,10,10);
                            break;
                        case 4:
                            g.fillOval(diceX+5,diceY+5,10,10);
                            g.fillOval(diceX+5,diceY+35,10,10);
                            g.fillOval(diceX+35,diceY+5,10,10);
                            g.fillOval(diceX+35,diceY+35,10,10);
                            break;
                        case 5:
                            g.fillOval(diceX+5,diceY+5,10,10);
                            g.fillOval(diceX+5,diceY+35,10,10);
                            g.fillOval(diceX+20,diceY+20,10,10);
                            g.fillOval(diceX+35,diceY+5,10,10);
                            g.fillOval(diceX+35,diceY+35,10,10);
                            break;
                        default:
                            g.fillOval(diceX+5,diceY+5,10,10);
                            g.fillOval(diceX+5,diceY+20,10,10);
                            g.fillOval(diceX+5,diceY+35,10,10);
                            g.fillOval(diceX+35,diceY+5,10,10);
                            g.fillOval(diceX+35,diceY+20,10,10);
                            g.fillOval(diceX+35,diceY+35,10,10);
                            break;
                    }

                    for(int i = 0; i < 15; i++) {
                        for(int j = 0; j < 15; j++) {
                            if(field[i][j] == "red") {
                                g.setColor(Color.red);
                                g.fillOval(i * 32 + sizeStandard, j * 32 + sizeStandard * 2,32,32);
                            }
                            else if(field[i][j] == "green") {
                                g.setColor(Color.green);
                                g.fillOval(i * 32 + sizeStandard, j * 32 + sizeStandard * 2,32,32);
                            }
                            else if(field[i][j] == "blue") {
                                g.setColor(Color.blue);
                                g.fillOval(i * 32 + sizeStandard, j * 32 + sizeStandard * 2,32,32);
                            }
                            else if(field[i][j] == "yellow") {
                                g.setColor(Color.yellow);
                                g.fillOval(i * 32 + sizeStandard, j * 32 + sizeStandard * 2,32,32);
                            }
                            else if(field[i][j] == "black") {
                                g.setColor(Color.black);
                                g.fillOval(i * 32 + sizeStandard, j * 32 + sizeStandard * 2,32,32);
                            }
                            else if (field[i][j] == "white"){
                                g.setColor(Color.white);
                                g.fillOval(i * 32 + sizeStandard, j * 32 + sizeStandard * 2,32,32);
                            }
                        }
                    }
                    g.setColor(Color.black);
                    for(GamePiece p: gp) {
                        if(p.team == "Red") {
                            g.setColor(Color.red);
                        }
                        else if(p.team == "Yellow") {
                            g.setColor(Color.yellow);
                        }
                        else if(p.team == "Green") {
                            g.setColor(Color.green);
                        }
                        else if(p.team == "Blue") {
                            g.setColor(Color.blue);
                        }
                        g.fillRect(p.xp * 32,p.yp * 32, 32, 32);
                    }
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                    g.setColor(Color.black);
                    g.drawString(text, sizeStandard, sizeStandard + 16);
                    //System.out.println("Repainted");
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
                //System.out.println(players);
                //System.out.println(e.getX() + " " + e.getY());
                if(phase == "start") {
                    System.out.println(e.getY());
                    if(players == 0) {
                        if(e.getX() > 5 && e.getX() < 105 && e.getY() > 280 && e.getY() < 380) {
                            players += 1;
                        }
                        else if(e.getX() > 155 && e.getX() < 255 && e.getY() > 280 && e.getY() < 380) {
                            players += 2;
                        }
                        else if(e.getX() > 280 && e.getX() < 380 && e.getY() > 280 && e.getY() < 380) {
                            players += 3;
                        }
                        else if(e.getX() > 405 && e.getX() < 505 && e.getY() > 280 && e.getY() < 380) {
                            players += 4;
                        }
                    }
                    else if(opponents > 0) {
                        if(e.getX() > 105 && e.getX() < 450 && e.getY() > 230 && e.getY() < 280) {
                            difficulty = "Easy";
                            phase = "turn";
                        }
                        else if(e.getX() > 105 && e.getX() < 450 && e.getY() > 285 && e.getY() < 335) {
                            difficulty = "Medium";
                            phase = "turn";
                        }
                        else if(e.getX() > 105 && e.getX() < 450 && e.getY() > 340 && e.getY() < 390) {
                            difficulty = "Hard";
                            phase = "turn";
                        }
                        else if(e.getX() > 105 && e.getX() < 450 && e.getY() > 395 && e.getY() < 445) {
                            difficulty = "Impossible";
                            phase = "turn";
                        }
                        System.out.println(difficulty);
                    }
                    else {
                        if(e.getX() > 25-20 && e.getX() < 125-20 && e.getY() > 280 && e.getY() < 380) {
                            phase="turn";
                        }
                        else if(e.getX() > 175-20 && e.getX() < 275-20 && e.getY() > 280 && e.getY() < 380) {
                            opponents += 1;
                        }
                        else if(e.getX() > 300-20 && e.getX() < 400-20 && e.getY() > 280 && e.getY() < 380) {
                            opponents += 2;
                        }
                        else if(e.getX() > 425-20 && e.getX() < 525-20 && e.getY() > 280 && e.getY() < 380) {
                            opponents += 3;
                        }
                    }
                    frame.repaint();
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
                if(input == "dice") {
                    if(e.getX() > diceX && e.getX() < diceX + 100 && e.getY() > diceY && e.getY() < diceY + 100) {
                        System.out.println("rolled");
                        input = "";
                        roll = (int)Math.floor(Math.random()*(6)+1);
                        phase = "check";
                        //dice(frame);
                        /*frame.repaint();
                        System.out.println("dicePressed");
                        roll = (int)Math.floor(Math.random()*(6)+1);
                        System.out.println(roll);

                        if(checkIfPlayerCanMove()) {
                            text = "Pick a piece to move";
                            phase = "move";
                            frame.repaint();
                        } else {
                            text = "No valid moves to make";
                            frame.repaint();
                            phase = "";
                            pause(2);
                            System.out.println("New Turn");
                            setTurn(frame);
                        }*/
                        //roll = (int)Math.floor(Math.random()*(6)+1);
                    }
                    /*if(button == 82) {
                        roll = (int)Math.floor(Math.random()*(6-1+1)+1);
                        System.out.println("You rolled a " + roll);
                        checkIfPlayerCanMove();
                    } else { System.out.println("lol"); }*/
                }
                if(input == "move") {
                    for(GamePiece p: gp) {
                        p.checkMove(roll,turn);
                        if(p.team == turn && p.xp <= e.getX()/32 && e.getX()/32 <= p.xp && p.yp <= e.getY()/32 - 1 && e.getY()/32 - 1 <= p.yp) {
                            if(p.priorityAi > 0){
                                selectedPiece = p;
                                selectedPiece.move(roll);
                                input="";
                                phase="turn";
                            } else {
                                text = "Illegal move, pick another piece";
                                System.out.println(text);
                            }
                        }
                    }
                }
                if(phase == "win") {
                    for(GamePiece p: gp) {
                        gp.remove(p);
                    }
                    GamePiece red1 = new GamePiece("Red",0,0, 1,0,false, gp);
                    GamePiece red2 = new GamePiece("Red",2,0, 2,0,false, gp);
                    GamePiece red3 = new GamePiece("Red",0,2, 3,0,false, gp);
                    GamePiece red4 = new GamePiece("Red",2,2, 4,0,false, gp);
                    GamePiece yellow1 = new GamePiece("Yellow",12,0, 1, 0, false, gp);
                    GamePiece yellow2 = new GamePiece("Yellow",14,0, 2, 0, false, gp);
                    GamePiece yellow3 = new GamePiece("Yellow",12,2, 3, 0, false, gp);
                    GamePiece yellow4 = new GamePiece("Yellow",14,2, 4, 0, false, gp);
                    GamePiece green1 = new GamePiece("Green",12,12, 1, 0, false, gp);
                    GamePiece green2 = new GamePiece("Green",14,12, 2, 0, false, gp);
                    GamePiece green3 = new GamePiece("Green",12,14, 3, 0, false, gp);
                    GamePiece green4 = new GamePiece("Green",14,14, 4, 0, false, gp);
                    GamePiece blue1 = new GamePiece("Blue",0,12, 1, 0, false, gp);
                    GamePiece blue2 = new GamePiece("Blue",2,12, 2, 0, false, gp);
                    GamePiece blue3 = new GamePiece("Blue",0,14, 3, 0, false, gp);
                    GamePiece blue4 = new GamePiece("Blue",2,14, 4, 0, false, gp);

                    phase = "start";
                }

                //System.out.println(red1.xp + " " + red1.yp);
                //System.out.println(e.getX()/32 + " " + e.getY()/32);
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
        while(true) {
            frame.repaint();
            //pause(1);
            switch(phase) {
                case "turn":
                    //System.out.println(phase);
                    setTurn(frame);
                    frame.repaint();
                    break;
                case "dice":
                    //System.out.println(phase);
                    if(Ai) {
                        pause(2);
                        frame.repaint();
                        roll = (int)Math.floor(Math.random()*(6)+1);
                        if(difficulty == "Impossible") {roll = 6; frame.repaint();}
                        phase = "check";
                        frame.repaint();
                        pause(1);
                    }
                    else {
                        input = "dice";
                        /*while(input == "dice") {
                            wait++;
                            System.out.println(wait);
                        }*/
                    }
                    //System.out.println(phase);
                    frame.repaint();
                    break;
                case "roll":
                    if(input != "dice") {
                        phase = "check";
                        frame.repaint();
                    }
                    frame.repaint();
                    break;
                case "check":
                    if(checkIfPlayerCanMove()) {
                        if(Ai) {
                            text = "AI choosing move...";
                            frame.repaint();
                            pause(1);
                        }
                        else {
                            text = "Pick a piece to move";
                            input = "move";
                        }
                        phase = "move";
                    } else {
                        text = "No valid moves to make";
                        phase = "turn";
                        frame.repaint();
                        pause(1);
                    }
                    frame.repaint();

                    break;
                case "move":
                    //System.out.println(phase);
                    if(Ai) {
                        moveAi(frame);
                        frame.repaint();
                        pause(1);
                        phase = "turn";
                    }
                    else {
                        if(input != "move") {
                            phase = "turn";
                        }

                        //System.out.println("moved");
                        frame.repaint();
                    }
                    frame.repaint();
                    break;
                case "win":
                    winner = true;
                    for(GamePiece p: gp) {
                        if(p.progress == 63) {
                            gp.remove(p);
                        }
                        frame.repaint();
                        if(p.team==turn) {
                            winner = false;
                            phase = "turn";
                        }
                    }
                    break;
            }
            frame.repaint();
        }
        /*frame.repaint();
        pause(1);
        if((turn == "Green" && players < 2) || (turn == "Yellow" && players < 3) || (turn == "Blue" && players < 4)) {
            moveAI(frame);
        }
        else {
            movePlayer(frame);
        }
        pause(1);*/

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
    public static void setTurn(JFrame frame) {
        if(roll == 6) {
            text = "Bonus turn for rolling a 6";
            pause(1);
        }
        else {
            switch(turn) {
                case "Red":
                    turn = "Yellow";
                    if(players + opponents > 2) {break;}
                case "Yellow":
                    turn = "Green";
                    break;
                case "Green":
                    turn = "Blue";
                    if(players+opponents > 3) {break;}
                case "Blue":
                    turn = "Red";
                    break;
            }
        }
        if((turn == "Green" && players < 2) || (turn == "Yellow" && players < 3) || (turn == "Blue" && players < 4)) {
            Ai = true;
        } else {Ai = false;}
        selectedPiece = null;
        for(GamePiece p: gp) {
            p.ready = false;
            p.priorityAi = 0;
        }
        if(Ai) {
            text = turn + " turn: AI is rolling the dice";
        } else {
            text = turn + " turn: Click the dice to roll it";
        }
        phase = "dice";
        /*if((turn == "Green" && players < 2) || (turn == "Yellow" && players < 3) || (turn == "Blue" && players < 4)) {
            moveAI(frame);
        }
        else {
            text = turn + " turn: Click the dice to roll it";
            frame.repaint();
            input = "dice";

            phase = "dice";
            //movePlayer(frame);
        }
        //System.out.println("Turn: " + turn);
        //System.out.println("Press [R] to roll the dice");*/
    }
    public static boolean checkIfPlayerCanMove() {
        for(GamePiece p: gp) {
            if(p.team == turn) {
                p.checkMove(roll, turn);
            }
        }
        for(GamePiece p: gp) {
            if(p.priorityAi > 0) {
                return true;
            }
        }
        return false;
    }
    public static void movePlayer(JFrame frame) {


        while(phase == "dice") {
            pause++;
        }
        //System.out.println("Valankia");
        if(checkIfPlayerCanMove()) {
            text = "Pick a piece to move";
            phase = "move";
        } else {
            text = "No valid moves to make";
            phase = "";
            pause(2);
        }

    }
    public static void rollAi() {
        roll = (int)Math.floor(Math.random()*(6)+1);
        if(difficulty == "Impossible") {roll = 6;}
        if(checkIfPlayerCanMove()) {
            text = "They rolled a " + roll + ". Choosing move...";
            switch(difficulty) {
                case "Easy":
                    for(GamePiece p: gp) {
                        if(p.priorityAi == 0) {
                            p.priorityAi = 10;
                        }
                    }
                    selectedPiece = gp.stream()
                            .min(Comparator.comparingInt(GamePiece::getPriorityAi))
                            .get();
                    break;
                case "Medium":
                    while(true) {
                        for(GamePiece p: gp) {
                            random = (int)Math.floor(Math.random()*(6)+1);
                            if(p.nr == random && p.priorityAi > 0) {
                                selectedPiece = p;
                                System.out.println("XD");
                                break;
                            }
                        }
                        System.out.println("lol");
                    }
                case "Hard":
                case "Impossible":
                    selectedPiece = gp.stream()
                            .max(Comparator.comparingInt(GamePiece::getPriorityAi))
                            .get();
                    break;
            }
            selectedPiece.move(roll);
        } else {
            text = "They rolled a " + roll + ". No valid moves to make";
        }
    }
    public static void moveAi(JFrame frame) {
        switch(difficulty) {
            case "Easy":
                for(GamePiece p: gp) {
                    if(p.priorityAi == 0) {
                        p.priorityAi = 10;
                    }
                }
                selectedPiece = gp.stream()
                        .min(Comparator.comparingInt(GamePiece::getPriorityAi))
                        .get();
                break;
            case "Medium":
                while(true) {
                    random = (int)Math.floor(Math.random()*(4)+1);
                    for(GamePiece p: gp) {
                        if(p.nr == random && p.priorityAi > 0) {
                            selectedPiece = p;
                            break;
                        }
                    }
                }
            case "Hard":
            case "Impossible":
                selectedPiece = gp.stream()
                        .max(Comparator.comparingInt(GamePiece::getPriorityAi))
                        .get();
                break;
        }
        selectedPiece.move(roll);
        frame.repaint();
        /*roll = (int)Math.floor(Math.random()*(6)+1);
        if(difficulty == "Impossible") {roll = 6; frame.repaint();}
        if(checkIfPlayerCanMove()) {
            text = "They rolled a " + roll + ". Choosing move...";
            frame.repaint();
            pause(1);
            switch(difficulty) {
                case "Easy":
                    for(GamePiece p: gp) {
                        if(p.priorityAI == 0) {
                            p.priorityAI = 10;
                        }
                    }
                    selectedPiece = gp.stream()
                            .min(Comparator.comparingInt(GamePiece::getPriorityAI))
                            .get();
                    break;
                case "Medium":
                    while(true) {
                        for(GamePiece p: gp) {
                            random = (int)Math.floor(Math.random()*(6)+1);
                            if(p.nr == random && p.priorityAI > 0) {
                                selectedPiece = p;
                                break;
                            }
                        }
                    }
                case "Hard":
                case "Impossible":
                    selectedPiece = gp.stream()
                            .max(Comparator.comparingInt(GamePiece::getPriorityAI))
                            .get();
                    break;
            }
            selectedPiece.move(roll);
            frame.repaint();
        } else {
            text = "They rolled a " + roll + ". No valid moves to make";
            frame.repaint();
            pause(1);
        }

        /*for(GamePiece p: gp) {

            System.out.println("SelectedPiece: ");
            System.out.println(selectedPiece.team);
            if(p.checkMove(roll)) {
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
        selectedPiece = gp.stream()
                .max(Comparator.comparingInt(GamePiece::getPriorityAI))
                .get();*/
    }
    public static void dice(JFrame frame) {
        frame.repaint();
        //System.out.println("dicePressed");
        while(phase == "dice") {
            roll = (int)Math.floor(Math.random()*(6)+1);
            //System.out.println(roll);
            pause(3);

            if(checkIfPlayerCanMove()) {
                text = "Pick a piece to move";

                phase = "move";
                //System.out.println("move");
                frame.repaint();
                pause(2);
            } else {
                text = "No valid moves to make";
                //System.out.println("No valid moves to make");
                frame.repaint();
                //phase = "";
                pause(2);
                setTurn(frame);
            }
        }


        /*if((turn == "yellow"&&players < 3) || (turn == "green"&&players < 2) || (turn == "blue"&&players < 4)) {
            System.out.print(turn + " turn: " + " player is rolling the dice...");
            text = turn + " turn: AI is rolling the dice";
            roll = (int)Math.floor(Math.random()*(6)+1);
            System.out.println("They rolled a " + roll + ". Choosing move..." );
            if(checkIfPlayerCanMove()) {
                if(checkIfPlayerCanMove()) {
                    moveAI(frame);
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
        }*/
    }

    public static void winPhase() {

    }
    public static void pause(int time) {
        try {
            Thread.sleep(1000*time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
