package com.byte_trio.transaction_service.model;

import java.util.Date;
import java.util.List;

public class TransactionDTO {
    private String id;
    private String borrowerId;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private long numberOfDueDate;
    private List<BookDTO> books;

    public String getId() {
        return id;
    }

    public TransactionDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public TransactionDTO setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
        return this;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public TransactionDTO setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public TransactionDTO setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public TransactionDTO setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public long getNumberOfDueDate() {
        return numberOfDueDate;
    }

    public TransactionDTO setNumberOfDueDate(long numberOfDueDate) {
        this.numberOfDueDate = numberOfDueDate;
        return this;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public TransactionDTO setBooks(List<BookDTO> books) {
        this.books = books;
        return this;
    }
}
