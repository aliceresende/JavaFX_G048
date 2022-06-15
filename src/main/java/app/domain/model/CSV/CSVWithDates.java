package app.domain.model.CSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Csv with dates.
 */
public class CSVWithDates implements CSV {
    final private String splitBy = ";";

    /**
     * Instantiates a new Csv with dates.
     */
    public CSVWithDates() {
    }
    @Override
    public List<List<String>> readFile(String filePath, List<List<String>> listcsvInfo) throws FileNotFoundException {
        List<String> csvlineinfo = new ArrayList<String>();
        Scanner in = new Scanner(new FileReader(filePath));
        String header = in.nextLine(); //removes header info
        String line;

        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] info = line.split(splitBy);

            info[0] = info[0].replaceAll(" ", ""); //snsusernumber
            info[1] = info[1].replaceAll(" ", ""); //vaccinename
            info[2] = info[2].replaceAll(" ","");  //dose
            info[3] = info[3].replaceAll(" ", ""); //lotnumber

            // adding info to list
            csvlineinfo.add(info[0]); //snsusernumber
            csvlineinfo.add(info[1]); //vaccinename
            csvlineinfo.add(info[2]); //dose
            csvlineinfo.add(info[3]); //lotnumber
            csvlineinfo.add(info[4]); //schedule date
            csvlineinfo.add(info[5]); //arrival date
            csvlineinfo.add(info[6]); //administration date
            csvlineinfo.add(info[7]); //leaving date

            listcsvInfo.add(csvlineinfo);
        }
        return listcsvInfo;
    }
}

