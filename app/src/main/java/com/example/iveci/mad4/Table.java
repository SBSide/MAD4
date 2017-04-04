package com.example.iveci.mad4;

/**
 * Created by iveci on 2017-04-04.
 */

public class Table {
    String Tablename;
    String EnterDate;
    int numspag, numpizza;
    int member;
    public Table(String Table){
        this.Tablename = Table;
        this.EnterDate = "";
        this.numspag = 0;
        this.numpizza = 0;
        this.member = 0;
    }
    public void modTable(Table table,String Enter, int spag, int pizza, int member) {
        table.EnterDate = Enter;
        table.numspag = spag;
        table.numpizza = pizza;
        table.member = member;
    }

    public boolean isEmpty(){
        return (this.EnterDate == "" ? true : false);
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

    public int getMember() {
        return member;
    }

    @Override
    public String toString() {
        return this.Tablename;
    }
}
