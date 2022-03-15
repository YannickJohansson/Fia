package com.Fia.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TileView extends JLabel {

    TileView(Color color) {
        setPreferredSize(new Dimension(100,100));
        setOpaque(true);
        setBackground(color);
    }
}
public class Board extends JPanel {

    public Ellipse tile;

    public static final int LENGTH = 11;

    Color[] colors =
            {
                //region Colors
                    //region Row1
                    Color.RED,
                    Color.RED,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.WHITE,
                    Color.BLUE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLUE,
                    Color.BLUE,
                    //endregion

                    //region Row2
                    Color.RED,
                    Color.RED,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.BLUE,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLUE,
                    Color.BLUE,
                    //endregion

                    //region Row3
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.BLUE,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    //endregion

                    //region Row4
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.BLUE,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    //endregion

                    //region Row5
                    Color.RED,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.BLUE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    //endregion

                    //region Row6
                    Color.WHITE,
                    Color.RED,
                    Color.RED,
                    Color.RED,
                    Color.RED,
                    Color.BLACK,
                    Color.GREEN,
                    Color.GREEN,
                    Color.GREEN,
                    Color.GREEN,
                    Color.WHITE,
                    //endregion

                    //region Row7
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.YELLOW,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.WHITE,
                    Color.GREEN,
                    //endregion

                    //region Row8
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.YELLOW,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    //endregion

                    //region Row9
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.YELLOW,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    Color.BLACK,
                    //endregion

                    //region Row10
                    Color.YELLOW,
                    Color.YELLOW,
                    Color.BLACK,
                    Color.BLACK,
                    Color.WHITE,
                    Color.YELLOW,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.GREEN,
                    Color.GREEN,
                    //endregion

                    //region Row11
                    Color.YELLOW,
                    Color.YELLOW,
                    Color.BLACK,
                    Color.BLACK,
                    Color.YELLOW,
                    Color.WHITE,
                    Color.WHITE,
                    Color.BLACK,
                    Color.BLACK,
                    Color.GREEN,
                    Color.GREEN,
                    //endregion
                //endregion
            };


    public Board() {
        setLayout(new GridLayout(LENGTH, LENGTH));
        int x = 0;

        public void DrawBoard (Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            for (int i = 0; i < LENGTH; i++)
            {
                for (int j = 0; j < LENGTH; j++)
                {
                    if(i ==)
                    ellipse = new Ellipse2D.Double(5, 10, 100, 150);
                    g2.draw(ellipse);
                    add(new TileView(colors[x]));
                    x += 1;
                }

            }
        }


    }
}
