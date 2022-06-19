package app.service.vaccinated_users;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class CSVFileCreatorVaccinatedUsers {
    public void CSVFileCreaterVaccinatedUsers(String filePath, ArrayList<String> dateList, String[][] listFileContents) throws IOException {
        File csvfile = new File(filePath + "\\VaccinatedUsers.csv");
        PrintWriter out = new PrintWriter(csvfile);

        for (int i = 0; i < listFileContents.length; i++) {
            if (dateList.contains(listFileContents[i][0])) {
                out.printf("%s; %s\n",listFileContents[i][0], listFileContents[i][8]);
            }
        }
        out.close();
    }
}
