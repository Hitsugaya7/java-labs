package com.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "library")
public class Library {

    private List<Book> book;

    public Library() {
    }

    public Library(final List<Book> books) {
        this.book = books;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(final List<Book> book) {
        this.book = book;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Library that = (Library) o;
        return Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
