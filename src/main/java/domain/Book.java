package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    private String isbn;
    private double price;
    public Book() {
    }
    public Book(String title, String author, String isbn, double price) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', author='%s', isbn='%s', price='%s']", id, title, author, isbn, price);
    }

}
