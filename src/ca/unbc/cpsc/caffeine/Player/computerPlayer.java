package ca.unbc.cpsc.caffeine.Player;

import ca.unbc.cpsc.caffeine.Player.Player;
import ca.unbc.cpsc.caffeine.enums.GameOverStatus;
import ca.unbc.cpsc.caffeine.exception.PlayerException;
import ca.unbc.cpsc.caffeine.interfaces.Colour;
import ca.unbc.cpsc.caffeine.interfaces.Location;
import ca.unbc.cpsc.caffeine.interfaces.PlayerInterface;


import java.util.Random;

public class computerPlayer extends Player implements Colour, PlayerInterface {

    private GameOverStatus currentStatus=null;      // null state represent that the game is still going on.

    private final String name="Jarvis";
    private boolean isBlack=false,isWhite=false;
    public    char[][] board=new char[16][4];

    public computerPlayer(String n, String c) {
        super("Jarvis", c);
    }


    @Override
    public void reset() throws PlayerException { currentStatus=null; }

    @Override
    public void noteOpponentsId(int id) throws PlayerException{  // just ignoring this info right now

    }

    @Override
    public void opponentPlays(Location ell) throws PlayerException {

        int row = ell.getRow(), column = ell.getColumn();

        int insert = row * 4 + column;

        int i = 0;

        if (isBlack()) {
            while (i < 4) {
                if (board[insert][i] != '\u0000') {
                    i++;
                } else if (board[insert][i] == '\u0000') {
                    board[insert][i] = 'b';
                    i = 4;
                }
            }
        } else {
            while (i < 4) {
                if (board[insert][i] != '\u0000') {
                    i++;
                } else if (board[insert][i] == '\u0000') {
                    board[insert][i] = 'w';
                    i = 4;
                }

            }

        }
    }

    @Override
    public void startGameAs(Colour c) throws PlayerException{

        // Change is colour methods as per the argument
        isBlack=c.isBlack();
        isWhite=c.isWhite();    // I don't know why I did this

    }

    @Override
    public Location requestMoveLocation() throws PlayerException{

        Location location=new Location() {


            Random ran=new Random();

            @Override
            public int getRow() {
                return ran.nextInt(4);
            }

            @Override
            public int getColumn() {
                return ran.nextInt(4);
            }


        };

        Location l1=checkRowWise(),l2=checkColumnWise(),l3=checkHeightWise();

        if(l1!=null){
            return l1;
        }

        if(l2!=null){
            return l2;
        }

        if(l3!=null){
            return l3;
        }


        return location;
    }

    @Override
    public Location retry() throws PlayerException {
        Location location=new Location() {

            Random ran=new Random();

            @Override
            public int getRow() {
                return ran.nextInt(4);
            }

            @Override
            public int getColumn() {
                return ran.nextInt(4);
            }

        };
        return location;
    }

    @Override
    public void noteGameOver(GameOverStatus whatHappened) throws PlayerException {

        currentStatus=whatHappened;

    }


    @Override
    public boolean isBlack() {
        return isBlack;
    }

    @Override
    public boolean isWhite() {
        return isWhite;
    }






    // Checking methods for the AI player so that the opponent cannot win.

    public  Location checkHeightWise(){

        Location localResult;

        int i=0;
        char colourChar;

        while (i<16) {

            colourChar=board[i][0];

            if (colourChar == board[i][1] && colourChar == board[i][2]){

                int finalI = i;
                localResult=new Location() {
                    @Override
                    public int getRow() {
                        return finalI;
                    }

                    @Override
                    public int getColumn() {
                        return 3;
                    }
                };

                return localResult;

            }
            i++;

        }
        return null;
    }


    public  Location checkRowWise(){

        Location localResult;

        int i=0;
        char colourChar;

        while (i<13) {

            int height=0,pegNumber=0;

            int count=0;

            while (height<4) {

                int row1=0,row2=0,row3=0;
                colourChar= 'z';    // just initializing

                if (board[i][height] != '\u0000') {
                    colourChar = board[i][height];
                    row1 = i + 1;
                    row2 = row1 + 1;
                    row3 = row2 + 1;

                } else if (board[i + 1][height] != '\u0000') {
                    colourChar = board[i + 1][height];
                    row1 = i;
                    row2 = row1 + 1;
                    row3 = row2 + 1;
                }

                if (colourChar == board[row1][height]){
                    ++count;
                } else {
                    pegNumber=row1;
                }

                if(colourChar == board[row2][height]){
                    ++count;
                }else {
                    pegNumber=row2;
                }

                if(colourChar == board[row3][height]){
                    ++count;
                }else {
                    pegNumber=row3;
                }

                if (count==1) {


                    int finalHeight = height;
                    int finalPegNumber = pegNumber;
                    localResult = new Location() {
                        @Override
                        public int getRow() {
                            return finalPegNumber;
                        }

                        @Override
                        public int getColumn() {
                            return finalHeight;
                        }
                    };

                    return localResult;
                }
                height++;
            }
            i+=4;

        }
        return null;

    }


    public  Location checkColumnWise(){

        Location localResult;

        int i=0;
        char colourChar;

        while (i<4) {

            int height=0,pegNumber=0;

            int count=0;

            while (height<4) {

                int column1=0,column2=0,column3=0;
                colourChar= 'z';    // just initializing

                if (board[i][height] != '\u0000') {
                    colourChar = board[i][height];
                    column1 = i + 4;
                    column2 = i + 8;
                    column3 = i + 12;

                } else if (board[i + 1][height] != '\u0000') {
                    colourChar = board[i + 1][height];
                    column1 = i;
                    column2 = i + 8;
                    column3 = i + 12;
                }

                if (colourChar == board[column1][height]){
                    ++count;
                } else {
                    pegNumber=column1;
                }

                if(colourChar == board[column2][height]){
                    ++count;
                }else {
                    pegNumber=column2;
                }

                if(colourChar == board[column3][height]){
                    ++count;
                }else {
                    pegNumber=column3;
                }

                if (count==1) {


                    int finalHeight = height;
                    int finalPegNumber = pegNumber;
                    localResult = new Location() {
                        @Override
                        public int getRow() {
                            return finalPegNumber;
                        }

                        @Override
                        public int getColumn() {
                            return finalHeight;
                        }
                    };

                    return localResult;
                }
                height++;
            }
            i++;

        }
        return null;

    }


    /**
     *
     *  Work on diagnols combination
     *
     *  3 and 5 multiples
     * @return
     */





}
