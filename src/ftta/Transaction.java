package ftta;

public class Transaction {
    private double transactionID;
    private String date;
    private String description;
    private double debit;
    private double credit;

    public Transaction(String date, String description, double debit, double credit) { // constructed using data from the
                                                                                   // bank record.
        this.date = date;
        this.description = description;
        this.debit = debit;
        this.credit = credit;
    }

    public void setTransactionID(double transactionID) {
        this.transactionID = transactionID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getTransactionID() {
        return transactionID;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getDebit() {
        return debit;
    }

    public double getCredit() {
        return credit;
    }
}