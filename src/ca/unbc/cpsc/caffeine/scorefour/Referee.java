package ca.unbc.cpsc.caffeine.scorefour;

public class Referee {

    private int location = 0;

    public boolean checkLocation() {
        return true;
    }

    public int getMove(char x, int y) {

        char newX = Character.toUpperCase(x);

        switch (newX) {
            case 'A':
                location = (10 + y);
                break;
            case 'B':
                location = (20 + y);
                break;
            case 'C':
                location = (30 + y);
                break;
            case 'D':
                location = (40 + y);
                break;

        }
        return location;
    }

    public int setBead() {
        return location;
    }
}
