package app.domain.model.CSV;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVNoHeader implements CSV {
    final private String splitBy = ",";

    public CSVNoHeader() {
    }

    /**
     * Reads the data from the csv file
     *
     * @param filePath the filepath of a file with header
     * @return List<SNSUsers> list with all the users info registered
     */

    @Override
    public List<List<String>> readFile(String filePath, List<List<String>> listcsvInfo) {
        String line;
        List<String> csvlineinfo = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new FileReader(filePath));
            in.useDelimiter(splitBy);
            while (in.hasNextLine()) {
                line = in.nextLine();
                String[] atributes = line.split(splitBy);
                String[] address = atributes[3].split("\\|"); // atributes[3] - 4 attributes of address
                atributes[1] = atributes[1].replaceAll(" ","");
                atributes[2] = atributes[2].replaceAll(" ","");
                atributes[4] = atributes[4].replaceAll(" ","");
                atributes[5] = atributes[5].replaceAll(" ","");
                atributes[6] = atributes[6].replaceAll(" ","");
                atributes[7] = atributes[7].replaceAll(" ","");

                // adding user info to list
                csvlineinfo.add(atributes[0]); //name
                csvlineinfo.add(atributes[1]); //sex
                csvlineinfo.add(atributes[2]); //age
                csvlineinfo.add(address[0]); //street
                csvlineinfo.add(address[1]); //doornumber
                csvlineinfo.add(address[2]); //postcode
                csvlineinfo.add(address[3]); // city
                csvlineinfo.add(atributes[4]); //phonenumber
                csvlineinfo.add(atributes[5]); //email
                csvlineinfo.add(atributes[6]); //snsusernumber
                csvlineinfo.add(atributes[7]); //ccnumber

                listcsvInfo.add(csvlineinfo);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return listcsvInfo;
    }



}
