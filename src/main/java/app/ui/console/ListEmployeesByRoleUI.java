package app.ui.console;

import app.controller.ListEmployeesByRoleController;
import app.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.UserRole;


public class ListEmployeesByRoleUI implements Runnable{
    private final ListEmployeesByRoleController controller = new ListEmployeesByRoleController();

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
