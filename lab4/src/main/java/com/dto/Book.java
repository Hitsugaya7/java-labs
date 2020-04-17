package com.dto;

import com.dto.contact.Author;
import com.dto.contact.BookInfo;

import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "Book")
public class Book {

    private Author author;

    private BookInfo bookInfo;


    public Book() {
    }

    public Book(final Author author, final BookInfo bookInfo) {
        this.author = author;
        this.bookInfo = bookInfo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(final Author author) {
        this.author = author;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(final BookInfo number) {
        this.bookInfo = number;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Book contact = (Book) o;
        return Objects.equals(author, contact.author) &&
                Objects.equals(bookInfo, contact.bookInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, bookInfo);
    }
}
