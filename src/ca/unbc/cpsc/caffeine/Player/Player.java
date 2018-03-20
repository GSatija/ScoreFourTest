package ca.unbc.cpsc.caffeine.Player;
        import java.awt.*;
public class Player {

    private final Color colour;
    private final String name;

    public Player(String n, String c) {
        name = n;
        if(c=="white"){
            colour = Color.white;
        }
        else{
            colour=Color.black;
        }
    }

    public String getName() {
        return name;
    }

    public Color getColour() {
        return colour;
    }
}
