package app.controller;

import app.services.algorithms.subsequence.Subsequence;
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

/**
 * The type Performance analyze controller.
 */
public class PerformanceAnalysisController {
    private Company company;
    private ArrivalOfSNSUserStore storeArrival;
    private AdministrationStore storeAdmin;

    private VaccinationCenterStore storeCenter;

    /**
     * Instantiates a new Performance analyze controller.
     */
    public PerformanceAnalysisController() {
        company = App.getInstance().getCompany();
        storeArrival = company.getArrivalStore();
        storeAdmin = company.getAdministrationStore();
        storeCenter = company.getRegisterCenterStore();
    }

    /**
     * Get max sublist int [ ].
     *
     * @param subsequence the subsequence
     * @return the int [ ]
     * @throws IOException            the io exception
     * @throws ClassNotFoundException the class not found exception
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     */
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

    /**
     * Input list int [ ].
     *
     * @param interval the interval
     * @param day      the day
     * @return the int [ ]
     */
    public int[] inputList(int interval,String day){
       return storeCenter.inputtedList(interval,storeArrival.ArrivalByDay(day),storeAdmin.ExitByDay(day));
    }


}
