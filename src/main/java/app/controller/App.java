package app.controller;

import app.domain.model.Company;
import app.domain.shared.Constants;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App()
    {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }


    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }


    private void bootstrap()
    {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEPT,Constants.ROLE_RECEPT);
        this.authFacade.addUserRole(Constants.ROLE_NURSE,Constants.ROLE_NURSE);
        this.authFacade.addUserRole(Constants.ROLE_CENTER_COORDINATOR,Constants.ROLE_CENTER_COORDINATOR);
        this.authFacade.addUserRole(Constants.ROLE_SNSUSER,Constants.ROLE_SNSUSER);

        this.authFacade.addUserWithRole("Administrator","admin@lei.sem2.pt","123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Center Coordinator","centercoordinator@isep.ipp.pt","123456",Constants.ROLE_CENTER_COORDINATOR);
        this.authFacade.addUserWithRole("SNS User","snsuser@lei.sem2.pt","123456",Constants.ROLE_SNSUSER);
        this.authFacade.addUserWithRole("Receptionist","receptionist@isep.ipp.pt","123456",Constants.ROLE_RECEPT);
        this.authFacade.addUserWithRole("Nurse","Nurse@isep.ipp.pt","123456",Constants.ROLE_NURSE);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance()
    {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}
