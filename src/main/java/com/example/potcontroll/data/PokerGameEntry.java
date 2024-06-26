package com.example.potcontroll.data;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PokerGameEntry {

    /*
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Gametype gametype;

    private int sb;
    private int bb;
    private int ante;

    private String date;

    private int buyIn;
    private int cashOut;

    private String owner;

    public PokerGameEntry() {}

    public PokerGameEntry(Gametype gametype, int sb, int bb, int ante, String date, int buyIn, int cashOut, String owner) {
        this.gametype = gametype;
        this.sb = sb;
        this.bb = bb;
        this.ante = ante;
        this.date = date;
        this.buyIn = buyIn;
        this.cashOut = cashOut;
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getDate() {
        return date;
    }

    public int getBuyIn() {
        return buyIn;
    }

    public int getCashOut() {
        return cashOut;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "PokerGameEntry{" +
                "id=" + id +
                ", gametype=" + gametype +
                ", sb=" + sb +
                ", bb=" + bb +
                ", ante=" + ante +
                ", date=" + date +
                ", buyIn=" + buyIn +
                ", cashOut=" + cashOut +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PokerGameEntry that = (PokerGameEntry) obj;
        return sb == that.sb && bb == that.bb && ante == that.ante && buyIn == that.buyIn && cashOut == that.cashOut && gametype == that.gametype && date.equals(that.date) && owner.equals(that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gametype, sb, bb, ante, date, buyIn, cashOut, owner);
    }
}