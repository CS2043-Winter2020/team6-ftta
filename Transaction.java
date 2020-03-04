package ftta;

import java.util.Date;

public class Transaction {
    private double transactionID;
    private Date date;
    private String description;
    private float debit;
    private float credit;

    public Transaction(Date date, String description, float debit, float credit) { // constructed using data from the
                                                                                   // bank record.
        this.date = date;
        this.description = description;
        this.debit = debit;
        this.credit = credit;
    }

    public void setTransactionID(double transactionID) {
        this.transactionID = transactionID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDebit(float debit) {
        this.debit = debit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public double getTransactionID() {
        return transactionID;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public float getDebit() {
        return debit;
    }

    public float getCredit() {
        return credit;
    }
}