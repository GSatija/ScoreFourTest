package ca.unbc.cpsc.caffeine.gui;

import ca.unbc.cpsc.caffeine.Player.Player;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ca.unbc.cpsc.caffeine.scorefour.Game;

public class GuiHandler {

    Player player1;
    Player player2;
    Color bg = new Color(176, 196, 222);
    Color side = new Color(240, 248, 255);
    Color bottom = new Color(220, 220, 220);
    PaintComponent board = new PaintComponent(player1, player2);
    boolean nextTurn = false;
    boolean computer;
    boolean twoComputer;

    public void createWindow(Player p1, Player p2) {

        player1 = p1;
        player2 = p2;
        Game game = new Game();

        JFrame jf = new JFrame("Team Caffeine - Score Four");
        jf.setSize(1280, 900);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/images/logo.png");
        jf.setIconImage(logo.getImage());

        JLabel label = new JLabel("It is Currently " + player1.getName() + "'s turn.");

        JTextArea textBox = new JTextArea(200, 50);
        textBox.setText("\n\n\n\n\n\n\n\n\nPlace a bead then submit your move.");
        textBox.setBounds(1080, 20, 200, 50);
        textBox.setWrapStyleWord(true);
        textBox.setEditable(false);

        JLabel whiteBead = new JLabel(new ImageIcon("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/images/beadWhite.png"));
        JLabel blackBead = new JLabel(new ImageIcon("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/images/beadBlack.png"));

        whiteBead.setAlignmentX(Component.CENTER_ALIGNMENT);
        blackBead.setAlignmentX(Component.CENTER_ALIGNMENT);

        blackBead.setVisible(false);

        board = new PaintComponent(player1, player2);

        JPanel area = new JPanel(new BorderLayout());
        area.setSize(1200, 820);
        area.setBackground(bg);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
        sideBar.setPreferredSize(new Dimension(200, 900));
        sideBar.setBackground(side);
        board.twoAI(twoComputer);

        JButton submit = new JButton("Submit Move");
        submit.setPreferredSize(new Dimension(0, 100));
        submit.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {

                                         if (!board.gameWon()) {

                                             //timer for 5 seconds
                                             if (twoComputer) {

                                                 board.getDog();
                                                 if (nextTurn == true) {
                                                     label.setText("It is Currently " + player1.getName() + "'s turn.");
                                                     textBox.setText("Last Turn:\n\n" + player2.getName() + " placed a bead on peg " + board.getLastMove() + "\n\n\n\n\n\n\nPlace a bead then submit your move.");
                                                     blackBead.setVisible(false);
                                                     whiteBead.setVisible(true);
                                                     nextTurn = false;
                                                 } else {
                                                     label.setText("It is Currently " + player2.getName() + "'s turn.");
                                                     textBox.setText("Last Turn:\n\n" + player1.getName() + " placed a bead on peg " + board.getLastMove() + "\n\n\n\n\n\n\nPlace a bead then submit your move.");
                                                     blackBead.setVisible(true);
                                                     whiteBead.setVisible(false);
                                                     nextTurn = true;
                                                 }
                                             } else if (computer) {
                                                 if(nextTurn==false) {
                                                     board.getDog();
                                                 }
                                                 if (board.beadPlaced()) {
                                                     if (nextTurn == true) {

                                                         textBox.setText("Last Turn:\n\n" + player1.getName() + " placed a bead on peg " + board.getLastMove() + "\n\n\n\n\n\n\nPlace a bead then submit your move.");
                                                         blackBead.setVisible(false);
                                                         whiteBead.setVisible(true);
                                                         nextTurn = false;
                                                     } else {

                                                         label.setText("It is Currently " + player1.getName() + "'s turn.");
                                                         textBox.setText("Last Turn:\n\n" + player2.getName() + " placed a bead on peg " + board.getLastMove() + "\n\n\n\n\n\n\nPlace a bead then submit your move.");

                                                         nextTurn = true;
                                                     }
                                                     board.resetClick();
                                                 }

                                             } else if (!computer && !twoComputer) {
                                                 if (board.beadPlaced()) {
                                                     if (nextTurn == true) {
                                                         label.setText("It is Currently " + player1.getName() + "'s turn.");
                                                         textBox.setText("Last Turn:\n\n" + player2.getName() + " placed a bead on peg " + board.getLastMove() + "\n\n\n\n\n\n\nPlace a bead then submit your move.");
                                                         blackBead.setVisible(false);
                                                         whiteBead.setVisible(true);
                                                         nextTurn = false;
                                                     } else {
                                                         label.setText("It is Currently " + player2.getName() + "'s turn.");
                                                         textBox.setText("Last Turn:\n\n" + player1.getName() + " placed a bead on peg " + board.getLastMove() + "\n\n\n\n\n\n\nPlace a bead then submit your move.");
                                                         blackBead.setVisible(true);
                                                         whiteBead.setVisible(false);
                                                         nextTurn = true;
                                                     }
                                                     board.resetClick();
                                                 }
                                             }
                                         }
                                     }

                                 }
        );
        JButton restart = new JButton("Restart");

        restart.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        int i = 0;
                        while (i < 16) {
                            board.myPegs[i].clearPeg();
                            i++;
                        }
                        textBox.setText("\n\n\n\n\n\n\n\n\nPlace a bead then submit your move.");
                        label.setText("It is Currently " + player1.getName() + "'s turn.");
                        blackBead.setVisible(false);
                        whiteBead.setVisible(true);
                        nextTurn = false;
                        board.restart();
                        board.resetClick();
                        board.repaint();
                    }
                }
        );

        JButton newGame = new JButton("New Game");

        newGame.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        jf.dispose();
                        game.startGame();
                    }
                }
        );

        JButton quit = new JButton("Quit");

        quit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        System.exit(0);
                    }
                }
        );

        submit.setAlignmentX(Component.CENTER_ALIGNMENT);

        restart.setAlignmentX(Component.CENTER_ALIGNMENT);

        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        quit.setAlignmentX(Component.CENTER_ALIGNMENT);

        sideBar.add(Box.createRigidArea(new Dimension(0, 20)));
        sideBar.add(whiteBead);

        sideBar.add(blackBead);

        sideBar.add(Box.createRigidArea(new Dimension(0, 20)));
        sideBar.add(textBox);

        sideBar.add(Box.createRigidArea(new Dimension(0, 10)));
        sideBar.add(submit);

        sideBar.add(Box.createRigidArea(new Dimension(0, 400)));
        sideBar.add(restart);

        sideBar.add(Box.createRigidArea(new Dimension(0, 10)));
        sideBar.add(newGame);

        sideBar.add(Box.createRigidArea(new Dimension(0, 10)));
        sideBar.add(quit);

        JPanel p3 = new JPanel();

        p3.setBackground(bottom);

        p3.add(label);

        area.add(board, BorderLayout.CENTER);

        jf.add(area);

        jf.add(p3, BorderLayout.PAGE_END);

        jf.add(sideBar, BorderLayout.EAST);

        jf.setVisible(true);

        System.out.println(player1.getName());
        System.out.println(player2.getName());
        System.out.println(player1.getColour());
        System.out.println(player2.getColour());
    }

    public void hasComputer(boolean comp, boolean t) {
        computer = comp;
        twoComputer = t;
    }
}

