package ca.unbc.cpsc.caffeine.gui;


import ca.unbc.cpsc.caffeine.bead.Bead;
import ca.unbc.cpsc.caffeine.board.Board;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import ca.unbc.cpsc.caffeine.scorefour.Line;
import ca.unbc.cpsc.caffeine.Player.Player;
import ca.unbc.cpsc.caffeine.peg.Peg;
import ca.unbc.cpsc.caffeine.soundClips.SoundClipTest;

import java.util.Random;

public class PaintComponent extends JComponent implements MouseListener {

    private final int myAx = 0;
    private final int myAy = 70;
    private final int myBx = 85;
    private final int myBy = 170;
    private final int myCx = 170;
    private final int myCy = 270;
    private final int myDx = 250;
    private final int myDy = 370;

    Player p1;
    Player p2;

    Line line = new Line();
    boolean noClick = true;
    boolean click = false;
    boolean compMove = false;
    boolean twoComp;

    Bead[] myBeads = new Bead[64];

    private int turn = 0;

    private int beadX;
    private int beadY;

    String lastMove;

    Board board = new Board();

    Random ran = new Random();
    int j = ran.nextInt(15);
    int k = 16;

    private boolean gameWon = false;

    public PaintComponent(Player player1, Player player2) {
        addMouseListener(this);
        p1 = player1;
        p2 = player2;
    }

    public PaintComponent(int x, int y) {
        beadX = x;
        beadY = y;
    }

    public Peg[] myPegs = {new Peg(myAx, myAy, "A1"),
            new Peg(myAx + 207, myAy - 43, "A2"),
            new Peg(myAx + 413, myAy - 86, "A3"),
            new Peg(myAx + 620, myAy - 130, "A4"),
            new Peg(myBx, myBy, "B1"),
            new Peg(myBx + 207, myAy + 57, "B2"),
            new Peg(myBx + 413, myAy + 14, "B3"),
            new Peg(myBx + 637, myAy - 39, "B4"),
            new Peg(myCx, myCy, "C1"),
            new Peg(myCx + 207, myAy + 157, "C2"),
            new Peg(myCx + 413, myAy + 114, "C3"),
            new Peg(myCx + 653, myAy + 61, "C4"),
            new Peg(myDx, myDy, "D1"),
            new Peg(myDx + 225, myAy + 245, "D2"),
            new Peg(myDx + 450, myAy + 190, "D3"),
            new Peg(myDx + 675, myDy - 162, "D4")};

    @Override
    public void paintComponent(Graphics g) {

        try {
            Graphics2D g2 = (Graphics2D) g;

            board.draw(g2);
            for (Peg myPeg : myPegs) {
                myPeg.draw(g2);
            }
        } catch (IOException ex) {
            Logger.getLogger(PaintComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        beadX = e.getX();
        beadY = e.getY();
        if (twoComp == false) {
            findPeg(e.getX(), e.getY());
        }
        System.out.println(twoComp);
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

    public void resetClick() {
        noClick = true;
        compMove = false;
    }

    public boolean beadPlaced() {
        return !noClick;
    }

    public boolean aiPlacedBead() {
        return compMove;
    }

    public boolean gameWon() {
        return gameWon;
    }

    public String getLastMove() {
        return lastMove;
    }

    public void restart() {
        turn = 0;
        gameWon = false;
        compMove = false;
    }

    public void getDog() {
        if (gameWon == false && j < 16 && myPegs[j].getHeight() < 4) {
            aiMove();
        } else {
            j++;
            aiMove();
        }
    }

    public void findPeg(int x, int y) {
        if (!click) {
            beadX = x;
            beadY = y;
            click = true;
        }
        repaint();
        if (noClick == true && gameWon == false) {
            if (((beadX < 85) && (beadX > 50)) && ((beadY < 470) && (beadY > 195))) {
                k = 0;
            } else if ((beadX < 290) && (beadX > 255) && ((beadY > 155) && (beadY < 425))) {
                k = 1;
            } else if ((beadX < 495) && (beadX > 460) && ((beadY > 110) && (beadY < 385))) {
                k = 2;
            } else if ((beadX < 705) && (beadX > 670) && ((beadY > 70) && (beadY < 340))) {
                k = 3;
            } else if ((beadX < 170) && (beadX > 135) && ((beadY > 300) && (beadY < 570))) {
                k = 4;
            } else if ((beadX > 340) && (beadX < 375) && ((beadY > 255) && (beadY < 525))) {
                k = 5;
            } else if ((beadX > 545) && (beadX < 580) && ((beadY > 210) && (beadY < 435))) {
                k = 6;
            } else if ((beadX > 770) && (beadX < 805) && ((beadY > 160) && (beadY < 380))) {
                k = 7;
            } else if ((beadX > 220) && (beadX < 255) && ((beadY > 400) && (beadY < 670))) {
                k = 8;
            } else if ((beadX > 425) && (beadX < 460) && ((beadY > 355) && (beadY < 625))) {
                k = 9;
            } else if ((beadX > 635) && (beadX < 670) && ((beadY > 310) && (beadY < 580))) {
                k = 10;
            } else if ((beadX > 875) && (beadX < 910) && ((beadY > 260) && (beadY < 530))) {
                k = 11;
            } else if ((beadX > 300) && (beadX < 335) && ((beadY > 500) && (beadY < 770))) {
                k = 12;
            } else if ((beadX > 525) && (beadX < 560) && ((beadY > 445) && (beadY < 715))) {
                k = 13;
            } else if ((beadX > 750) && (beadX < 785) && ((beadY > 390) && (beadY < 660))) {
                k = 14;
            } else if ((beadX > 975) && (beadX < 1010) && ((beadY > 335) && (beadY < 605))) {
                k = 15;
            }

            if (k < 16) {
                if (myPegs[k].getHeight() < 4) {
                    myBeads[turn] = new Bead(40 + myPegs[k].getLocation()[0], (405 + myPegs[k].getLocation()[1] - (myPegs[k].getHeight() + 1) * 65), turn);
                    myPegs[k].addBead(myBeads[turn]);
                    turn++;
                    noClick = false;
                    repaint();
                    boolean value = line.check(myPegs[k], k, myPegs);
                    if (value == true) {
                        System.err.println("yippee");
                        try {
                            SoundClipTest sound=new SoundClipTest();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        JOptionPane.showMessageDialog(null, myBeads[turn - 1].getColour() + " wins!");
                        gameWon = true;
                        System.out.println(gameWon);
                    }
                    lastMove = myPegs[k].getName();
                    k = 16;

                } else {
                    System.out.println("peg full");
                }
            }
        }

    }

    public void aiMove() {
        compMove = true;
        myBeads[turn] = new Bead(42 + myPegs[j].getLocation()[0], (407 + myPegs[j].getLocation()[1] - (myPegs[j].getHeight() + 1) * 65), turn);
        myPegs[j].addBead(myBeads[turn]);
        turn++;
        noClick = false;
        repaint();
        boolean value = line.check(myPegs[j], j, myPegs);


        j = ran.nextInt(15);
        lastMove = myPegs[j].getName();
        if (value == true) {

            try {
                SoundClipTest sound=new SoundClipTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.err.println(" yippee");
            JOptionPane.showMessageDialog(null, myBeads[turn - 1].getColour() + " wins!");
            gameWon = true;
            System.out.println(gameWon);
        }
    }

    public void twoAI(boolean tc) {
        twoComp = tc;
    }
}

//    public void newGame() {
//        int i = 0;
//        while (i < 16) {
//            myPegs[i].clearPeg();
//            i++;
//        }
//        restart();
//        resetClick();
//        repaint();
//        j = ran.nextInt(15);
//    }
