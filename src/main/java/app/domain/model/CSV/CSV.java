package app.domain.model.CSV;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;


public interface CSV {

    List<List<String>> readFile (String filePath, List<List<String>> listcsvInfo) throws FileNotFoundException, ParseException;
}
