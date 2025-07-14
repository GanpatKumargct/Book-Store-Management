package com.BookStoreManagment.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Title;
    private String Author;
    private String Genere; //for types of book -story book, mystery book,.....
    private String ISBN;   //unique number
    private int price;
    private String Description;
    private int StockQuantity;  //number of book in a stock
    private String ImageUrl;

    public Book(int id, String title, String author, String genere, String ISBN, int price, String description, int stockQuantity, String imageUrl) {
        this.id = id;
        Title = title;
        Author = author;
        Genere = genere;
        this.ISBN = ISBN;
        this.price = price;
        Description = description;
        StockQuantity = stockQuantity;
        ImageUrl = imageUrl;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int prise) {
        this.price = prise;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuality) {
        StockQuantity = stockQuality;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", Title='").append(Title).append('\'');
        sb.append(", Author='").append(Author).append('\'');
        sb.append(", Genere='").append(Genere).append('\'');
        sb.append(", ISBN='").append(ISBN).append('\'');
        sb.append(", price=").append(price);
        sb.append(", Description='").append(Description).append('\'');
        sb.append(", StockQuality=").append(StockQuantity);
        sb.append(", ImageUrl='").append(ImageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
