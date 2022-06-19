package app.controller;

import app.domain.model.Company;
import app.service.algorithm.performance.CenterPerformanceCSV;
import app.service.algorithm.subsequence.Subsequence;
import app.domain.shared.Constants;
import app.store.ArrivalOfSNSUserStore;
import app.store.PerformanceDataStore;
import app.store.VaccineAdministrationStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PerformanceAnalysisController {
    private final ArrivalOfSNSUserStore storeArrival;
    private final VaccineAdministrationStore storeAdmin;

    private final PerformanceDataStore storePerform;


    public PerformanceAnalysisController() {
        Company company = App.getInstance().getCompany();
        storeArrival = company.getArrivalStore();
        storeAdmin = company.getAdministrationStore();
        storePerform = company.getPerformanceDataStore();

    }
    public int[] getMaxSublist(int[] subsequence) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Subsequence subsequenceAlgorithm = getSubsequenceConfigFile();
        return subsequenceAlgorithm.getSubsequence(subsequence);
    }

    private Subsequence getSubsequenceConfigFile() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
        properties.load(in);
        Class<?> subsequenceClass = Class.forName(properties.getProperty("Company.Algorithms.subsequence"));
        Subsequence subsequenceAlgorithm;
        try{
            subsequenceAlgorithm = (Subsequence) subsequenceClass.getDeclaredConstructor().newInstance();
        }catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        in.close();
        return subsequenceAlgorithm;
    }

    public int[] getInputList(int interval, String day){
        return new CenterPerformanceCSV().listOfInput(interval,day);
    }

    public int sumSublist(int[] arr) {
       return new CenterPerformanceCSV().sumSublist(arr);
    }


}
