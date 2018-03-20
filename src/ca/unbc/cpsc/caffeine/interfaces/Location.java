package ca.unbc.cpsc.caffeine.interfaces;

public interface Location {

    public static final int MAX_ROW    =3;
    public static final int MIN_ROW    =0;
    public static final int MAX_COLUMN =3;
    public static final int MIN_COLUMN =0;

    public abstract  int getRow();
    public abstract  int getColumn();



}
