package com.example.iveci.mad4;

/**
 * Created by iveci on 2017-04-04.
 */

public class Table {
    String Tablename;
    String EnterDate;
    int numspag, numpizza;
    boolean member;
    public Table(String table){
        this.Tablename = table;
        this.EnterDate = "";
        this.numspag = 0;
        this.numpizza = 0;
        this.member = false;
    }
    public void modTable(Table table,String Enter, int spag, int pizza, boolean member) {
        table.EnterDate = Enter;
        table.numspag = spag;
        table.numpizza = pizza;
        table.member = member;
    }

    public boolean isEmpty(){
        return (this.EnterDate == "" ? true : false);
    }

    public String getTablename() {
        return Tablename;
    }

    public String getEnterDate() {
        return EnterDate;
    }

    public int getNumspag() {
        return numspag;
    }

    public int getNumpizza() {
        return numpizza;
    }

    public boolean getMember() {
        return member;
    }

    @Override
    public String toString() {
        if (isEmpty()) return this.Tablename + " (비어있음)";
        else return this.Tablename;
    }
}
