package app.ui;

import app.controller.App;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistence {
    public static Object readObjectFromFile(String file) throws IOException, ClassNotFoundException {
        file = "./storage/" + file;

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object a = (ArrayList)in.readObject();
        in.close();

        return a;

    }
    public static void saveObjectToFile(Object ob, String file)throws IOException{
        file= "./storage/" + file;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(ob);
        out.close();

    }
    public static void saveAllStores ()throws IOException {
        saveObjectToFile(App.getInstance().getCompany().getVaccineTypeList().getArray(), "Vaccinetype.bin");
        saveObjectToFile(App.getInstance().getCompany().getVaccineStore().getVaccineList(), "Vaccine.bin");
        saveObjectToFile(App.getInstance().getCompany().getSNSUserStore().getSnsUserList(), "SNSUser.bin");
        saveObjectToFile(App.getInstance().getCompany().getVaccineScheduleStore().getVaccineScheduleList(), "VaccineShedule.bin");
        saveObjectToFile(App.getInstance().getCompany().getRegisterCenterStore().getKnows(), "VaccinationCenter.bin");
        saveObjectToFile(App.getInstance().getCompany().getEmployeeStore().getKnows(), "Employees.bin");

        saveObjectToFile(App.getInstance().getCompany().getEmployeeStore().getCenterCoordinators(), "CenterCoordinator.bin");
        saveObjectToFile(App.getInstance().getCompany().getArrivalStore().GetArrivalOfSNSUsers(),"UserArrival.bin");
        saveObjectToFile(App.getInstance().getCompany().getReactionStore().getReactionArray(),"EmployeeRoles.bin");

    }

}
