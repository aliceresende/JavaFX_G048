package app.domain.store;

import app.controller.App;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.util.ArrayList;

/**
 * The type Employee role store.
 */
public class EmployeeRoleStore {

    private ArrayList<UserRole> roles = new ArrayList<>();

    /**
     * Instantiates a new Employee role store.
     */
    public EmployeeRoleStore(){
        roles.add(new UserRole(Constants.ROLE_RECEPT, "Responsible for scheduling appointments and registering the arrival of the patients."));
        roles.add(new UserRole(Constants.ROLE_CENTER_COORDINATOR,"Responsible for coordinating the Vaccination Center"));
        roles.add(new UserRole(Constants.ROLE_NURSE,"Responsible for administrating the vaccine, can access the list of all the SNSUsers and can access all their data and medical history, and the ones that work in the healthcare centers cand also issue and deliver on site the vaccination certificate.  "));
    }

    /**
     * Adds a new role to the list
     *
     * @param role the role that is going to be added
     * @return true and adds a new role if it isn't already added
     */
    public boolean addRole(UserRole role) {
        int i = 0;
        boolean check = true;
        if (role != null) {
            for (UserRole roleR : roles) {
                if (role.equals(roleR)) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check) {
                roles.add(role);
                return check;
            }
        }
        return false;

    }

    private void addUserRolesToSystem(){
        AuthFacade authFacade = App.getInstance().getCompany().getAuthFacade();

        for(UserRole u : roles){
            authFacade.addUserRole(u.getId(),u.getDescription());
        }
    }


    /**
     * This method returns a list with all the roles
     *
     * @return roles
     */
    public ArrayList<UserRole> getRoles() {
        return roles;
    }



}
