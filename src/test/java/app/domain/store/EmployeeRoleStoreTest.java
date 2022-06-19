package app.domain.store;

import app.store.EmployeeRoleStore;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.domain.model.UserRole;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


class EmployeeRoleStoreTest {

    @Test
    public void getRolesTest() {
        EmployeeRoleStore test = new EmployeeRoleStore();
        ArrayList<UserRole> roles = new ArrayList<>();
        roles.add(new UserRole("Receptionist", "Responsible for scheduling appointments and registering the arrival of the patients."));
        roles.add(new UserRole("Center Coordinator","Responsible for coordinating the Vaccination Center"));
        roles.add(new UserRole("Nurse","Responsible for administrating the vaccine, can access the list of all the SNSUsers and can access all their data and medical history, and the ones that work in the healthcare centers cand also issue and deliver on site the vaccination certificate.  "));

        assertEquals(roles, test.getRoles());
    }
}