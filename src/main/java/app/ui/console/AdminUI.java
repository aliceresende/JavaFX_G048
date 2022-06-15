package app.ui.console;

import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Admin ui.
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class AdminUI implements Runnable{
    /**
     * Instantiates a new Admin ui.
     */
    public AdminUI()
    {
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Create a new Employee ", new RegisterEmployeeUI()));
        options.add(new MenuItem("List employees by role ", new ListEmployeesByRoleUI()));
        options.add(new MenuItem("Specify a new vaccine type and its administration process ", new SpecifyNewVaccineTypeUI()));
        options.add(new MenuItem("Register a new Center ",  new RegisterCenterUI()));
        options.add(new MenuItem("Register a new vaccine and its administration process", new SpecifyNewVaccineUI()));
        options.add(new MenuItem("Load a set of users from a CSV file ", new LoadSNSUsersCSVUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
