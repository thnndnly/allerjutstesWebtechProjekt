package com.example.potcontroll.data;

import java.util.Date;

/**
 * PokerGameEntry
 */
public class PokerGameEntry {

    /**
     *  Gametype enthält den Spieltypen, der gespielt wurde.
     *  Bis jetzt:
     *  0 - Cashgame
     *  1 - Tournament
     *  2 - Spin and Go
     */
    public enum Gametype {
        CASHGAME,
        TOURNAMENT,
        SPINANDGO,
    }

    private final Gametype gametype;

    private final int sb;
    private final int bb;
    private final int ante;

    private final Date date;

    private final int buyIn;
    private final int cashOut;

    public PokerGameEntry(Gametype gametype, int sb, int bb, int ante, Date date, int buyIn, int cashOut) {
        this.gametype = gametype;
        this.sb = sb;
        this.bb = bb;
        this.ante = ante;
        this.date = date;
        this.buyIn = buyIn;
        this.cashOut = cashOut;
    }

    public Gametype getGametype() {
        return gametype;
    }

    public int getSb() {
        return sb;
    }

    public int getBb() {
        return bb;
    }

    public int getAnte() {
        return ante;
    }

    public Date getDate() {
        return date;
    }

    public int getBuyIn() {
        return buyIn;
    }

    public int getCashOut() {
        return cashOut;
    }
}
