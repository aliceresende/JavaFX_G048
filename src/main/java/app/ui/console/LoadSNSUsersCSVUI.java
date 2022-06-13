package app.ui.console;

import app.controller.LoadSNSUsersCSVController;
import app.domain.model.SNSUser;
import app.ui.console.utils.Utils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class LoadSNSUsersCSVUI implements Runnable{
    private final LoadSNSUsersCSVController controller = new LoadSNSUsersCSVController();

    public LoadSNSUsersCSVUI() {
    }

    /**
     * The run() method, calls methods in the Utils class, to get the file path, to upload the users
     */
    public void run() {

        String filePath = Utils.readLineFromConsole("Please indicate the file path of the file you want to upload: ");

        List<SNSUser> users = new ArrayList<>();
        File csv = new File(filePath);
        boolean validpath;

        do{
            if(csv.exists()) {
                validpath = true;
                System.out.println("***** Loading the Data ****\n");
                try {
                    users = controller.readFile(filePath);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }else {
                validpath = false;
                filePath = Utils.readLineFromConsole(" File was not founded! Please try to introduce another file path:");
                csv = new File(filePath);
            }
        }while (!validpath);

        boolean conf;
        boolean saving;

        if(users == null){
            System.out.println("The Data in the csv file was not fulfilled correctly!");
        }else{

            System.out.println("Data extracted from the csv file:");
            for (SNSUser u: users) {
                System.out.println("--------------------");
                System.out.println(u.toString());
            }

                conf = Utils.confirm("Is this data you pretend to be save? \n----> Yes or No? <----\n ");
                if (conf ) {
                    saving = controller.saveUsers(users);

                    if(saving){
                        System.out.println("***** Saving the users ****");
                        controller.saveUsers(users);
                        System.out.println("The SNS Users were saved with success!");
                    }else if (!saving){
                        conf = false;
                        System.out.println("Something went wrong, the system was not able to save the users!");
                    }

                } else if(!conf) {
                    System.out.println("Couldn't save the SNS Users! Please try again ");
                }

        }



    }

}

