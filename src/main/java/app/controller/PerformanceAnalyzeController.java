package app.controller;

import app.domain.algorithms.subsequence.Subsequence;
import app.domain.model.Company;
import app.domain.shared.Constants;
import app.domain.store.AdministrationStore;
import app.domain.store.ArrivalOfSNSUserStore;
import app.domain.store.VaccinationCenterStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PerformanceAnalyzeController {
    private Company company;
    private ArrivalOfSNSUserStore storeArrival;
    private AdministrationStore storeAdmin;

    private VaccinationCenterStore storeCenter;

    public PerformanceAnalyzeController() {
        company = App.getInstance().getCompany();
        storeArrival = company.getArrivalStore();
        storeAdmin = company.getAdministrationStore();
        storeCenter = company.getRegisterCenterStore();
    }
    public int[] getMaxSublist(int[] subsequence) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Properties properties = new Properties();
        InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
        properties.load(in);
        Class<?> subsequenceClass = Class.forName(properties.getProperty("Company.Algorithms.subsequence"));
        Subsequence subsequenceAlgorithm = null;
        try{
            subsequenceAlgorithm = (Subsequence) subsequenceClass.getDeclaredConstructor().newInstance();
        }catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        in.close();
        return subsequenceAlgorithm.getSubsequence(subsequence);
    }
    public int[] inputList(int interval,String day){
       return storeCenter.inputtedList(interval,storeArrival.ArrivalByDay(day),storeAdmin.ExitByDay(day));
    }


}
