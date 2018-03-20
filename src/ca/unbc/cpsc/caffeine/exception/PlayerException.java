package ca.unbc.cpsc.caffeine.exception;

public class PlayerException extends Exception{

    public PlayerException()                        { this("Unknown Player Exception");}


    public PlayerException(String s)                { super(s);}

    public PlayerException(Throwable t)             { super(t);}

    public PlayerException(String s, Throwable t)   { super(s,t);}

}