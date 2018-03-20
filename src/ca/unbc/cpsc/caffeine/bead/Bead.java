
package ca.unbc.cpsc.caffeine.bead;

        import java.awt.*;
        import static java.awt.Color.black;
        import static java.awt.Color.white;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import javax.imageio.ImageIO;

public class Bead {

    int myX = 0;
    int myY = 0;
    int myTurn;
    BufferedImage bead;
    public Color c;
    public String colour;

    public Bead(int x, int y, int myTurn) {
        myX = x;
        myY = y;
        this.myTurn = myTurn;
        if (myTurn % 2 == 0) {
            c = Color.WHITE;
            colour = "White";
        } else {
            c = Color.BLACK;
            colour = "Black";
        }
    }

    //    public void drawWhite(Graphics g, int x, int y) throws IOException {
//        Graphics2D g2 = (Graphics2D) g;
//        myX = x;
//        myY = y;
//        bead = ImageIO.read(new File("images\\beadWhite.png"));
//        g2.drawImage(bead, myX - 20, myY - 20, null);
//    }
//
//    public void drawBlack(Graphics g) throws IOException {
//        Graphics2D g2 = (Graphics2D) g;
//        bead = ImageIO.read(new File("images\\beadBlack.png"));
//        g2.drawImage(bead, myX - 20, myY - 20, null);
//
//    }
    public void draw(Graphics g) throws IOException {
        Graphics2D g2 = (Graphics2D) g;
        if ((myTurn % 2) == 0) {
            bead = ImageIO.read(new File("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/images/beadWhite.png"));
            g2.drawImage(bead, myX - 17, myY - 17, null);
        } else {
            bead = ImageIO.read(new File("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/images/beadBlack.png"));
            g2.drawImage(bead, myX - 17, myY - 17, null);
        }
    }

    public String getColour() {
        return colour;
    }

    public boolean compareTo(Color c2) {
        return c.getRGB() == c2.getRGB();
    }

}
