package com.Fia.main;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Game extends JFrame {

    public Game() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(250, 200);

        setTitle("com.Fia.main.Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
    }
}
