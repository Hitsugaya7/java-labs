package com.dto.information;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Reader {

    private String firstName;

    private String lastName;

    public Reader() {
    }

    public Reader(final String first, final String last) {
        this.firstName = first;
        this.lastName = last;
    }

    @XmlAttribute(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @XmlAttribute(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Reader name = (Reader) o;
        return Objects.equals(firstName, name.firstName) &&
                Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
