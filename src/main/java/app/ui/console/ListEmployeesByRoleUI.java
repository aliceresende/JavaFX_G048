package app.ui.console;

import app.controller.ListEmployeesByRoleController;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.UserRole;


/**
 * The type List employees by role ui.
 */
public class ListEmployeesByRoleUI implements Runnable{
    private final ListEmployeesByRoleController controller = new ListEmployeesByRoleController();

    /**
     * Instantiates a new List employees by role ui.
     */
    public ListEmployeesByRoleUI() {
    }

    /**
     * The run() method, calls methods in the Utils class. The first one
     */
    public void run() {
        String selectedRole = ((UserRole) Utils.showAndSelectOne(controller.getListOfRoles(),"Select one of the roles:")).getId();
        Utils.showList(controller.getEmployeesBySelectedRole(selectedRole),"Employees with the "+ selectedRole +" role:");
    }

}
