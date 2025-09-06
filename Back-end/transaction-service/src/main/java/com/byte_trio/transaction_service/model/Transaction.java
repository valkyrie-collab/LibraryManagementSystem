package com.byte_trio.transaction_service.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    private String id;
    private String borrowerId;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private long numberOfDueDate;
    @ElementCollection
    private List<String> bookIds;

    public String getId() {return id;}

    public String getBorrowerId() {return borrowerId;}

    public long getNumberOfDueDate() {return numberOfDueDate;}

    public Date getIssueDate() {return issueDate;}

    public Date getDueDate() {return dueDate;}

    public Date getReturnDate() {return returnDate;}

    public List<String> getBookIds() {return bookIds;}

    public Transaction setId(String id) {
        this.id = id;
        return this;
    }

    public Transaction setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
        return this;
    }

    public Transaction setNumberOfDays(long numberOfDueDate) {
        this.numberOfDueDate = numberOfDueDate;
        return this;
    }

    public Transaction setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public Transaction setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Transaction setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Transaction setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
        return this;
    }

    @Override
    public String toString() {
        return id + borrowerId + issueDate + dueDate + returnDate + numberOfDueDate;
    }
}
