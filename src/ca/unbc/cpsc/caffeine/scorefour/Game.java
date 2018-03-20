package ca.unbc.cpsc.caffeine.scorefour;

import ca.unbc.cpsc.caffeine.Player.Player;
import ca.unbc.cpsc.caffeine.gui.GuiHandler;
import javax.swing.JOptionPane;

public class Game {

    String name1 = "Player 1";
    String name2 = "Player 2";
    String colour = "white";
    String colour2 = "black";
    GuiHandler gui = new GuiHandler();
    Boolean colourBoolean = false;
    Boolean nameBoolean = false;
    Boolean hasComp = false;
    Boolean twoComp = false;

    public void startGame() {

        int choice = JOptionPane.showOptionDialog(null, "Choose your opponent", "Choose an option", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Human Player", "Jarvis", "2 AI"}, "Jarvis");
        if (choice == 0) {
            name1 = JOptionPane.showInputDialog(null, "Player 1,\nPlease Enter Your name: ");
            if (name1 == null) {
                System.exit(0);
            }
            while (nameBoolean
                    == false) {
                if (name1 != null && !name1.isEmpty()) {
                    nameBoolean = true;
                } else {
                    name1 = JOptionPane.showInputDialog(null, "" + name1 + "\nPlease enter a name:", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                }

                name2 = JOptionPane.showInputDialog(null, "Player 2,\nPlease Enter Your name:");

                nameBoolean = false;
                if (colour.equals(
                        "black")) {
                    colour2 = "white";
                } else {
                    colour2 = "black";
                }
                if (name2 == null) {
                    System.exit(0);
                }

                while (nameBoolean
                        == false) {
                    if (name2 != null && !name2.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Your bead colour is " + colour2 + ". Press OK to start the game.", "Game Starting", JOptionPane.NO_OPTION);
                        nameBoolean = true;
                    } else {
                        name2 = JOptionPane.showInputDialog(null, "" + name2 + "\nPlease enter a name: ", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

        } else if (choice == 1) {
            hasComp = true;
            name1 = JOptionPane.showInputDialog(null, "Player 1,\nPlease Enter Your name: ");
            if (name1 == null) {
                System.exit(0);
            }
            while (nameBoolean
                    == false) {
                if (name1 != null && !name1.isEmpty()) {
                    nameBoolean = true;
                } else {
                    name1 = JOptionPane.showInputDialog(null, "" + name1 + "\nPlease enter a name:", "Invalid Name", JOptionPane.ERROR_MESSAGE);
                }
            }

            JOptionPane.showMessageDialog(null, "Your bead colour is  Black. Press OK to start the game.", "Game Starting", JOptionPane.NO_OPTION);

            name2 = "Jarvis";
        } else if (choice == 2) {
            twoComp = true;

            /**
             *
             * Nme chnge
             *
             */

            name1 = "Retro";
            name2 = "Jarvis";
        } else {
            System.exit(0);
        }

        System.out.println(choice);
        Player player1 = new Player(name1, colour);
        Player player2 = new Player(name2, colour2);

        gui.hasComputer(hasComp, twoComp);
        gui.createWindow(player1, player2);
    }

    public String getName(int x) {
        if (x == 1) {
            return name1;
        } else {
            return name2;
        }
    }

    public String getColour(int x) {

        if (x == 1) {
            return colour;
        } else if (colour.equals("black")) {
            colour2 = "white";
        } else {
            colour2 = "black";
        }
        return colour2;
    }
}
