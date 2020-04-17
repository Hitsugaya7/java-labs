package com.dto.information;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType(name = "bookInfo")
public class BookInfo {

    private String bookName;

    private String graduationYear;

    public BookInfo() {
    }

    public BookInfo(final String bookName, final String graduationYear) {
        this.bookName = bookName;
        this.graduationYear = graduationYear;
    }

    @XmlAttribute(name = "bookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(final String bookName) {
        this.bookName = bookName;
    }

    @XmlAttribute(name = "graduationYear")
    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(final String graduationYear) {
        this.graduationYear = graduationYear;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BookInfo number = (BookInfo) o;
        return Objects.equals(bookName, number.bookName) &&
                Objects.equals(graduationYear, number.graduationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, graduationYear);
    }
}
