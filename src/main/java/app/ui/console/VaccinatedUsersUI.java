package app.ui.console;

import app.controller.VaccinatedUsersController;
import app.service.vaccinated_users.CSVFileCreatorVaccinatedUsers;
import app.service.vaccinated_users.CSVFileVaccinatedUsersReader;
import app.ui.console.utils.Utils;

import java.io.IOException;
import java.util.Scanner;

public class VaccinatedUsersUI implements Runnable {
    static Scanner read = new Scanner(System.in);
    private VaccinatedUsersController controller = new VaccinatedUsersController();
    private CSVFileCreatorVaccinatedUsers createCsvFile = new CSVFileCreatorVaccinatedUsers();
    private CSVFileVaccinatedUsersReader reader = new CSVFileVaccinatedUsersReader();

    /**
     * Asks the information of the vaccinated users and reads it
     * @throws Exception if the information enter is not valid
     */

    public void run() {
        System.out.println("Enter the required information:\n");

        boolean check = true;
        do {
            String date = Utils.readLineFromConsole("Day (YYYY/MM/DD): ");
            System.out.println();
            if (controller.NumberOfVaccinatedUsers(date) != null) {
                System.out.println(controller.NumberOfVaccinatedUsers(date));
                System.out.println();

                check = Utils.confirm("Would you like to check more date \n----> Yes or No? <----\n");
            } else {
                System.out.println("The given date does not exist on the file.");
                System.out.println();
            }

        } while (check);

        boolean useCsv;
        useCsv = Utils.confirm("Do you want to save the chosen data in a csv file \\n----> Yes or No? <----\\n\"");

        if (useCsv) {
            String filePath = Utils.readLineFromConsole("File Path: ");
            try {
                createCsvFile.CSVFileCreaterVaccinatedUsers(filePath, controller.getDateList(), reader.getFileContents());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Success");
        }
    }
}
