package app.domain.model.CSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CSVWithDates implements CSV {
    final private String splitBy = ";";
    private final SimpleDateFormat programFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final SimpleDateFormat csvFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    public CSVWithDates() {
    }
    @Override
    public List<List<String>> readFile(String filePath, List<List<String>> listcsvInfo) throws FileNotFoundException, ParseException {
        List<List<String>> csvInfo = new ArrayList<>();
        Scanner in = new Scanner(new FileReader(filePath));
        String header = in.nextLine(); //removes header info
        String line;

        while (in.hasNextLine()) {
            List<String> csvlineinfo = new ArrayList<String>();
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

            Date s = csvFormat.parse(info[4]);
            String sf = programFormat.format(s);
            csvlineinfo.add(sf); //schedule date

            Date a = csvFormat.parse(info[5]);
            String af = programFormat.format(a);
            csvlineinfo.add(af); //arrival date

            Date na = csvFormat.parse(info[6]);
            String naf = programFormat.format(na);
            csvlineinfo.add(naf); //administration date

            Date l = csvFormat.parse(info[7]);
            String lf = programFormat.format(l);
            csvlineinfo.add(lf); //leaving date

            csvInfo.add(csvlineinfo);
        }
        listcsvInfo = csvInfo;
        return listcsvInfo;
    }
}

