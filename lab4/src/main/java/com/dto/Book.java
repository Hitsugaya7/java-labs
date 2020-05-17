package com.dto;

import com.dto.information.Author;
import com.dto.information.BookInfo;
import com.dto.information.Reader;

import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "Book")
public class Book {

    private Author author;

    private BookInfo bookInfo;

    private Reader reader;


    public Book() {
    }

    public Book(final Author author, final BookInfo bookInfo) {
        this.author = author;
        this.bookInfo = bookInfo;
    }

    public Book(Author author, BookInfo bookInfo, Reader reader) {
        this.author = author;
        this.bookInfo = bookInfo;
        this.reader = reader;
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

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getBookInfo(), book.getBookInfo()) &&
                Objects.equals(reader, book.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getBookInfo(), reader);
    }
}
