package com.dto;

import com.dto.information.Author;
import com.dto.information.BookInfo;
import com.dto.information.Reader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarshallingDemarshallingIndividualTaskTest {

    @Test
    public void marshallingTest() throws JAXBException, IOException {
        Library telephoneDirectory = createTestLibrary();

        JAXBContext context = JAXBContext.newInstance(Library.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();
        marshaller.marshal(telephoneDirectory, writer);

        List<String> demarshallingResultByLine = Arrays.stream(writer.toString().split("\n"))
                .map(line -> line.trim())
                .collect(Collectors.toList());

        Path pathToTestFile = Paths.get("src/test/resources/data/library_test_individual_task.xml");
        List<String> expectedValue = Files.readAllLines(pathToTestFile)
                .stream()
                .map(line -> line.trim())
                .collect(Collectors.toList());

        Assert.assertEquals(expectedValue, demarshallingResultByLine);
    }

    @Test
    public void demarshallingTest() throws JAXBException, IOException {
        File file = new File("src/test/resources/data/library_test_individual_task.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Library actualTelephoneDirectory = (Library) jaxbUnmarshaller.unmarshal(file);
        Library expectedTelephoneDirectory = createTestLibrary();

        Assert.assertEquals(expectedTelephoneDirectory, actualTelephoneDirectory);
    }

    private Library createTestLibrary() {
        Author author = new Author("Yerdos", "Ilyassov");
        BookInfo bookInfo = new BookInfo("The Lord of the Rings: chapter one", "1997");
        Reader reader = new Reader("ReaderFirstName1", "ReaderLastName1");
        Book book = new Book(author, bookInfo, reader);

        Author author2 = new Author("Chingis", "Yessenbayev");
        BookInfo bookInfo2 = new BookInfo("The Lord of the Rings: chapter two", "1996");
        Reader reader2 = new Reader("ReaderFirstName2", "ReaderLastName2");
        Book book2 = new Book(author2, bookInfo2, reader2);

        Author author3 = new Author("Baurzhan", "Nurgazy");
        BookInfo bookInfo3 = new BookInfo("The Lord of the Rings: chapter three", "1998");
        Reader reader3 = new Reader("ReaderFirstName3", "ReaderLastName3");
        Book book3 = new Book(author3, bookInfo3, reader3);

        return new Library(
                List.of(
                        book,
                        book2,
                        book3
                )
        );
    }
}
