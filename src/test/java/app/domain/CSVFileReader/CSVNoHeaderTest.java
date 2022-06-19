package app.domain.CSVFileReader;

import app.domain.model.CSV.CSVNoHeader;
import app.domain.model.SNSUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVNoHeaderTest {
    private CSVNoHeader cSVFileReaderNoHeader;

    @BeforeEach
    public void setUp() {
        cSVFileReaderNoHeader = new CSVNoHeader();
    }
}



    /*@Test
    @DisplayName("Should return a list of users when the file is found")
    public void testReadFileWhenFileIsFoundThenReturnListOfUsers() {

        List<SNSUser> users = new ArrayList<>();
        String filePath = "src/Testing CSV files/csvnoheader";

        List<SNSUser> result = cSVFileReaderNoHeader.readFile(filePath, users);

        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Should return an empty list when the file is not found")
    public void testReadFileWhenFileIsNotFoundThenReturnEmptyList() {

        List<SNSUser> users = new ArrayList<>();
        String filePath = "src/test/resources/users.csv";

        List<SNSUser> result = cSVFileReaderNoHeader.readFile(filePath, users);

        assertEquals(0, result.size());
    }*/



