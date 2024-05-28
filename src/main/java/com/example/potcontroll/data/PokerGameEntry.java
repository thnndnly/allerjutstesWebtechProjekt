/*
package com.example.potcontroll.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class PokerGameEntry {

    @Id
    private Long id;

    public PokerGameEntry() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


     *  Gametype enthält den Spieltypen, der gespielt wurde.
     *  Bis jetzt:
     *  0 - Cashgame
     *  1 - Tournament
     *  2 - Spin and Go

    public enum Gametype {
        CASHGAME,
        TOURNAMENT,
        SPINANDGO,
    }

    private Gametype gametype;

    private int sb;
    private int bb;
    private int ante;

    private Date date;

    private int buyIn;
    private int cashOut;

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
*/