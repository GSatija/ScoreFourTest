package ca.unbc.cpsc.caffeine.scorefour;



import java.awt.*;

import ca.unbc.cpsc.caffeine.bead.Bead;
import ca.unbc.cpsc.caffeine.peg.Peg;

public class Line {

    // peg[] pegs = new peg[100];

    public boolean check(Peg currentPeg, int indexPeg, Peg[] pegs) {

        int indexnumber = (indexPeg % 4),
                height = currentPeg.height - 1;
        if (height >= 3) {
            height = 3;
        }
        Bead color = currentPeg.array[height];
        System.out.println("height is: " + height);


        try {
            if (color.compareTo(pegs[indexPeg].array[0].c)
                    && color.compareTo(pegs[indexPeg].array[1].c)
                    && color.compareTo(pegs[indexPeg].array[2].c)
                    && color.compareTo(pegs[indexPeg].array[3].c)) {    // To check beads at the same height of the bead added
                return true;
            }
        } catch (NullPointerException e) {

        }
        try {
            if (color.compareTo(pegs[indexnumber].array[height].c)
                    && color.compareTo(pegs[indexnumber + 4].array[height].c)
                    && color.compareTo(pegs[indexnumber + 8].array[height].c)
                    && color.compareTo(pegs[indexnumber + 12].array[height].c)) {    // To check beads at the same height of the bead added
                return true;
            }
        } catch (NullPointerException e) {

        }

        // check

        try {
            if (color.compareTo(pegs[indexnumber].array[0].c)
                    && color.compareTo(pegs[indexnumber + 4].array[1].c)
                    && color.compareTo(pegs[indexnumber + 8].array[2].c)
                    && color.compareTo(pegs[indexnumber + 12].array[3].c)) {
                return true;
            }
        } catch (NullPointerException e) {

        }

//    try {
//
//        if (color.compareTo(pegs[indexnumber + 4].array[height - 1].c)
//                && color.compareTo(pegs[indexnumber + 8].array[height - 2].c)
//                && color.compareTo(pegs[indexnumber + 12].array[height - 3].c)) {
//            return true;
//        }
//    } catch (NullPointerException e) {
//
//    }

        //******


/* Repeated
        try {
            if (color.compareTo(pegs[indexnumber].array[0].c)
                    && color.compareTo(pegs[indexnumber].array[1].c)
                    && color.compareTo(pegs[indexnumber].array[2].c)
                    && color.compareTo(pegs[indexnumber].array[3].c)) {    // To check beads at the same height of the bead added
                return true;
            }
        } catch (NullPointerException e) {

        }
*/
        //****

        try {


            indexnumber = (indexPeg / 4) * 4;   // This is important

            if (color.compareTo(pegs[indexnumber].array[height].c)
                    && color.compareTo(pegs[indexnumber + 1].array[height].c)
                    && color.compareTo(pegs[indexnumber + 2].array[height].c)
                    && color.compareTo(pegs[indexnumber + 3].array[height].c)) {
                return true;
            }
        } catch (NullPointerException e) {

        }

        try {


            if (color.compareTo(pegs[indexnumber].array[0].c)
                    && color.compareTo(pegs[indexnumber + 1].array[1].c)
                    && color.compareTo(pegs[indexnumber + 2].array[2].c)
                    && color.compareTo(pegs[indexnumber + 3].array[3].c)) {
                return true;
            }
        } catch (NullPointerException e) {

        }

        try {


            if (color.compareTo(pegs[indexnumber].array[3].c)
                    && color.compareTo(pegs[indexnumber + 1].array[2].c)
                    && color.compareTo(pegs[indexnumber + 2].array[1].c)
                    && color.compareTo(pegs[indexnumber + 3].array[0].c)) {
                return true;
            }
        } catch (NullPointerException e) {

        }


        if (indexPeg % 3 == 0) {

            try {
                if (color.compareTo(pegs[3].array[height].c)
                        && color.compareTo(pegs[6].array[height].c)
                        && color.compareTo(pegs[9].array[height].c)
                        && color.compareTo(pegs[12].array[height].c)) {
                    return true;
                }
            } catch (NullPointerException e) {

            }

            try {

                if (color.compareTo(pegs[3].array[0].c)
                        && color.compareTo(pegs[6].array[1].c)
                        && color.compareTo(pegs[9].array[2].c)
                        && color.compareTo(pegs[12].array[3].c)) {
                    return true;
                }
            } catch (NullPointerException e) {

            }

            try {

                if (color.compareTo(pegs[3].array[3].c)
                        && color.compareTo(pegs[6].array[2].c)
                        && color.compareTo(pegs[9].array[3].c)
                        && color.compareTo(pegs[12].array[4].c)) {
                    return true;
                }
            } catch (NullPointerException e) {

            }
        }



        if (indexPeg % 5 == 0) {
            try {
                if (color.compareTo(pegs[0].array[height].c)
                        && color.compareTo(pegs[5].array[height].c)
                        && color.compareTo(pegs[10].array[height].c)
                        && color.compareTo(pegs[15].array[height].c)) {
                    return true;
                }
            } catch (NullPointerException e) {

            }

            try {

                if (color.compareTo(pegs[0].array[0].c)
                        && color.compareTo(pegs[5].array[1].c)
                        && color.compareTo(pegs[10].array[2].c)
                        && color.compareTo(pegs[15].array[3].c)) {
                    return true;
                }
            } catch (NullPointerException e) {

            }

            try {

                if (color.compareTo(pegs[0].array[3].c)
                        && color.compareTo(pegs[5].array[2].c)
                        && color.compareTo(pegs[10].array[3].c)
                        && color.compareTo(pegs[15].array[4].c)) {
                    return true;
                }
            } catch (NullPointerException e) {

            }

        }


        return false;

    }


}
