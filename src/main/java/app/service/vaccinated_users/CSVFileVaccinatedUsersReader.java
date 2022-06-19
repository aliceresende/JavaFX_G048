package app.service.vaccinated_users;

import app.domain.shared.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CSVFileVaccinatedUsersReader {
    private String[][] listFileContents;
    static final String allDataPath = Constants.ALLVACCINATEDDATAPATH;

    public CSVFileVaccinatedUsersReader() {
        try {
            readCSV(allDataPath);
        } catch (IOException e) {
            System.out.println("There is an error with the file path");
        }
    }

    public void readCSV(String filePath) throws FileNotFoundException {
        String[][] fileContents = new String[121][9];
        Scanner read = new Scanner(new File(filePath));
        int i = 0;
        do {
            String contentLine = read.nextLine();
            String[] splitedContent = contentLine.split(";");
            for (int j = 0; j < fileContents[0].length; j++) {
                fileContents[i][j] = splitedContent[j];
            }
            i++;
        } while (i < fileContents.length);

        listFileContents = fileContents;
        read.close();
    }

    public String[][] getFileContents() {
        return listFileContents;
    }
}
