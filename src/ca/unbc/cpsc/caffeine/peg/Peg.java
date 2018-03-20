package ca.unbc.cpsc.caffeine.peg;


import ca.unbc.cpsc.caffeine.bead.Bead;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Peg {

    int myX = 0;
    int myY = 0;
    public int position;
    public Bead[] array = new Bead[4];
    public int height = 0;
    public BufferedImage peg;
    private String name;
    private int[] loc = new int[2];

    public Peg() {

    }

    public Peg(int x, int y, String n) {
        myX = x;
        myY = y;
        name = n;
        loc[0] = x;
        loc[1] = y;
    }

    public void draw(Graphics g) throws IOException {

        Graphics2D g2 = (Graphics2D) g;
        peg = ImageIO.read(new File("/Users/gauravsatija/IdeaProjects/ScoreFourTest/src/images/peg2.png"));
        g2.drawImage(peg, myX, myY, null);
        int cnt = 0;
        while (cnt < height) {
            array[cnt].draw(g2);
            cnt++;
        }

    }

    public void addBead(Bead bead) {      // Adding the bead to the peg
        if (height >= 4) {
            System.err.println("Maximum height of the peg reached!");   // Printing an error line when going out of bounds
        } else if (height >= 0) {
            array[height] = bead; //  pointing the array index to the bead object
            height++;
        }
    }

    public void clearPeg() {
        int cnt = 0;
        while (cnt < height) {
            array[cnt] = null;
            cnt++;
        }
        height = 0;
    }

    public int getHeight() {
        return (height);
    }

    public String getName() {
        return name;
    }

    public int[] getLocation() {
        return loc;
    }
}

