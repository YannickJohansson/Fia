package com.Fia.main;

import java.util.LinkedList;

import static com.Fia.main.Game.illegal;
import static com.Fia.main.Game.sizeStandard;


public class GamePiece {
    //region paths
    int[][] redPath = {
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

    int[][] greenPath = {
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
    int[][] yellowPath = {
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
    int priorityAI;
    boolean canKnockout;
    LinkedList<GamePiece> gp;
    public GamePiece(String team, int nr, int progress, boolean ready, LinkedList<GamePiece> gp){
        this.team = team;
        switch(this.team) {
            case "red":
                path = redPath;
                break;
            case "yellow":
                path = yellowPath;
                break;
            case "green":
                path = greenPath;
                break;
            case "blue":
                path = bluePath;
                break;
        }
        this.path = path;
        this.nr = nr;
        this.xp = this.path[this.progress][0] + 1;
        this.yp = this.path[this.progress][1] + 2;
        this.progress = progress;
        this.ready = ready;
        this.priorityAI = 0;
        this.canKnockout = false;
        this.gp = gp;
        gp.add(this);
    }
    public boolean checkMove(int xp, int yp,int roll) {
        if((roll != 1 && roll != 6) && (this.progress == 0)) {
            return false;
        }
        if(this.progress + roll > this.path.length) {
            return false;
        }
        for(GamePiece p: gp) {
            if(p.xp == (this.xp+roll) &&p.yp == (this.yp+roll)) {
                if(p.team.equals(this.team) && p != this){
                    return false;
                } else {
                    this.priorityAI = 1;
                    this.canKnockout = true;
                }
            }
        }
        return true;
    }

    public void move(int xp, int yp, int roll) {
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
    public void checkAI(int roll) {

    }
}
