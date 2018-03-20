package ca.unbc.cpsc.caffeine.scorefour;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
            /**
             * changed
             */
        } catch (Exception e) {
        }
        Game game = new Game();
        javax.swing.SwingUtilities.invokeLater(() -> {
            game.startGame();
        });
    }
}
