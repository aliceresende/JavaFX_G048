package app.domain.CSVFileReader;

import app.domain.model.CSV.CSV;
import app.domain.model.CSV.CSVWithHeader;
import app.domain.model.SNSUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVWithHeaderTest {

    private CSV csvWithHeader;

    @BeforeEach
    public void setUp() {
        csvWithHeader = new CSVWithHeader();
    }



    List<SNSUser> users = new ArrayList<>();
    //String filePath = "C:\Users\Inês Alves\OneDrive\Documentos\ISEP\2º Semestre\Lapr2\lei-22-s2-1dk-g48\src\Testing CSV files\csvwithheader";
    CSVWithHeader csvFileReaderWithHeader = new CSVWithHeader();

    //List<SNSUser> result = csvFileReaderWithHeader.readFile(filePath, users);

    // assertEquals(3, result.size());
}
