package app.controller;

import app.domain.model.Company;
import app.service.vaccinated_users.CSVFileCreatorVaccinatedUsers;
import app.service.vaccinated_users.CSVFileVaccinatedUsersReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class VaccinatedUsersController {
    private ArrayList<String> dateList;
    private App app;
    private Company company;
    private String[][] vaccinatedUsersData;
    private CSVFileVaccinatedUsersReader csv = new CSVFileVaccinatedUsersReader();
    private CSVFileCreatorVaccinatedUsers creator = new CSVFileCreatorVaccinatedUsers();

    public Company getCompany() {
        return this.company;
    }

    public VaccinatedUsersController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     */

    public VaccinatedUsersController(Company company) {
        this.dateList = new ArrayList<>();
        this.company = company;
        this.vaccinatedUsersData = csv.getFileContents();
    }

    public String numberOfVaccinatedUsers(String date) {
        for (int i = 0; i < vaccinatedUsersData.length; i++) {
            if (Objects.equals(date, vaccinatedUsersData[i][0])) {
                dateList.add(date);
                return vaccinatedUsersData[i][8];
            }
        }
        return null;
    }

    public void CSVFileCreatorVaccinatedUsers(String filePath) throws IOException {
        creator.CSVFileCreatorVaccinatedUsers(filePath, dateList, vaccinatedUsersData);
    }

    /* public ArrayList<String> getDateList() {
        return dateList;
    }*/
}
