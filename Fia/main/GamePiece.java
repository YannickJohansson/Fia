package com.Fia.main;

import java.util.LinkedList;

public class GamePiece {
    //region paths
    int[][] redPath = {
            { 0, 0 },
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

    int[][] yellowPath = {
            { 0, 0 },
            //GREEN
            { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 6 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 }, { 14, 7 },
            //YELLOW
            { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 }, { 9, 8 }, { 8, 8 },
            { 8, 9 }, { 8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 }, { 8, 14 }, { 7, 14 },
            //BLUE
            { 6, 14 }, { 6, 13 }, { 6, 12 }, { 6, 11 }, { 6, 10 }, { 6, 9 }, { 6, 8 },
            { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 }, { 0, 7 },
            //RED
            { 0, 6 }, { 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 6 },
            { 6, 5 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },
            //END
            { 7, 1 }, { 7, 2 }, { 7, 3 }, { 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 7 }
    };
    int[][] greenPath = {
            { 0, 0 },
            //YELLOW
            { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 }, { 9, 8 }, { 8, 8 },
            { 8, 9 }, { 8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 }, { 8, 14 }, { 7, 14 },
            //BLUE
            { 6, 14 }, { 6, 13 }, { 6, 12 }, { 6, 11 }, { 6, 10 }, { 6, 9 }, { 6, 8 },
            { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 }, { 0, 7 },
            //RED
            { 0, 6 }, { 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 6 },
            { 6, 5 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },
            //GREEN
            { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 6 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 }, { 14, 7 },
            //END
            { 13, 7 }, { 12, 7 }, { 11, 7 }, { 10, 7 }, { 9, 7 }, { 8, 7 }, { 7, 7 }
    };
    int[][] bluePath = {
            { 0, 0 },
            //BLUE
            { 6, 14 }, { 6, 13 }, { 6, 12 }, { 6, 11 }, { 6, 10 }, { 6, 9 }, { 6, 8 },
            { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 }, { 0, 7 },
            //RED
            { 0, 6 }, { 1, 6 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 6 },
            { 6, 5 }, { 6, 4 }, { 6, 3 }, { 6, 2 }, { 6, 1 }, { 6, 0 }, { 7, 0 },
            //GREEN
            { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 6 },
            { 9, 6 }, { 10, 6 }, { 11, 6 }, { 12, 6 }, { 13, 6 }, { 14, 6 }, { 14, 7 },
            //YELLOW
            { 14, 8 }, { 13, 8 }, { 12, 8 }, { 11, 8 }, { 10, 8 }, { 9, 8 }, { 8, 8 },
            { 8, 9 }, { 8, 10 }, { 8, 11 }, { 8, 12 }, { 8, 13 }, { 8, 14 }, { 7, 14 },
            //END
            { 7, 13 }, { 7, 12 }, { 7, 11 }, { 7, 10 }, { 7, 9 }, { 7, 8 }, { 7, 7 }
    };
    //endregion

    int xp;
    int yp;
    int progress;
    int[][] path;
    boolean ready;
    int nr;
    String team;
    boolean inBase;
    int priorityAi;
    boolean canKnockout;
    LinkedList<GamePiece> gp;
    public GamePiece(String team, int baseX, int baseY, int nr, int progress, boolean ready, LinkedList<GamePiece> gp){
        this.team = team;
        switch(this.team) {
            case "Red":
                path = redPath;
                break;
            case "Yellow":
                path = yellowPath;
                break;
            case "Green":
                path = greenPath;
                break;
            case "Blue":
                path = bluePath;
                break;
        }
        this.path[0][0] = baseX;
        this.path[0][1] = baseY;
        this.nr = nr;
        this.xp = this.path[this.progress][0] + 1;
        this.yp = this.path[this.progress][1] + 2;
        this.progress = progress;
        this.ready = ready;
        this.priorityAi = 0;
        this.canKnockout = false;
        this.gp = gp;
        gp.add(this);
    }
    public int getPriorityAi() {
        return priorityAi;
    }
    public void checkMove(int roll, String turn) {
        if((roll != 1 && roll != 6 && this.progress == 0) || (this.progress + roll > this.path.length+1)) {
            priorityAi = 0;
        }
        else {
            this.priorityAi += 1;
            if(this.progress == 0) {
                this.priorityAi += 1;
            }
            if(this.progress == 1 && this.progress == 6) {
                this.priorityAi += 1;
            }
            for(GamePiece p: gp) {
                //System.out.println(p.xp);
                //System.out.println(p);
                if(p != this && p.xp == this.path[this.progress+roll][0] + 1 && p.yp == this.path[this.progress+roll][1] + 2) {
                    System.out.println(this.path[this.progress+roll][0] + 1);
                    if(p.team == this.team){
                        this.priorityAi = 0;
                        System.out.println("Success");
                    } else {
                        this.priorityAi += 2;
                        System.out.println("Failure");

                    }
                }
            }
        }
    }

    public void move(int roll) {
        this.progress += roll;
        this.xp = this.path[this.progress][0] + 1;
        this.yp = this.path[this.progress][1] + 2;
        for(GamePiece p: gp) {
            if(p != this && p.xp==this.xp && p.yp==this.yp) {
                p.knockout();
            }
        }
    }
    public void knockout() {
        this.progress = 0;
        this.xp = this.path[this.progress][0];
        this.yp = this.path[this.progress][1];
    }
}