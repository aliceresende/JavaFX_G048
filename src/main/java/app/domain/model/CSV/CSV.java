package app.domain.model.CSV;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;


/**
 * The interface Csv.
 */
public interface CSV {

    /**
     * Read file list.
     *
     * @param filePath    the file path
     * @param listcsvInfo the listcsv info
     * @return the list
     * @throws FileNotFoundException the file not found exception
     */
    List<List<String>> readFile (String filePath, List<List<String>> listcsvInfo) throws FileNotFoundException, ParseException;
}
