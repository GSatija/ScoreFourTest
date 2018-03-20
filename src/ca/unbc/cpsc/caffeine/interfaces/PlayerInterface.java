package ca.unbc.cpsc.caffeine.interfaces;


import ca.unbc.cpsc.caffeine.enums.GameOverStatus;
import ca.unbc.cpsc.caffeine.exception.PlayerException;

public interface PlayerInterface {

    public abstract void reset() throws PlayerException;

    public abstract void startGameAs(Colour c) throws PlayerException;

    public abstract void noteOpponentsId(int id) throws PlayerException;

    public abstract void opponentPlays(Location ell) throws PlayerException;

    public abstract Location requestMoveLocation() throws PlayerException;

    public abstract Location retry() throws PlayerException;

    public abstract void noteGameOver(GameOverStatus whatHappened) throws PlayerException;

}

