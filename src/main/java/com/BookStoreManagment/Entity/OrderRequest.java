package com.BookStoreManagment.Entity;

import java.util.List;

public class OrderRequest {

    private int userId;

    private List<BookOrderEntry> books;

    // inner static class to hold book ID + quantity
    public static class BookOrderEntry {
        private int bookId;
        private int quantity;

        // Getters & Setters

        public int getBookId() {
            return bookId;
        }

        public void setBookId(int bookId) {
            this.bookId = bookId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<BookOrderEntry> getBooks() {
        return books;
    }

    public void setBooks(List<BookOrderEntry> books) {
        this.books = books;
    }
}

