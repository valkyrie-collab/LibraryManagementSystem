package com.byte_trio.transaction_service.model;

public class Fine {
    private String id;
    private String transactionId;
    private double amount;
    private String reason;
    private boolean paidStatus;

    public String getId() {
        return id;
    }

    public Fine setId(String id) {
        this.id = id;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Fine setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Fine setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Fine setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public Fine setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
        return this;
    }
}
