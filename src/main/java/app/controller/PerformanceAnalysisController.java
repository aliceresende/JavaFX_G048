package app.controller;

import app.domain.shared.Constants;
import app.service.CenterPerformanceCSV;
import app.service.algorithms.subsequence.Subsequence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PerformanceAnalysisController {

    public PerformanceAnalysisController() {

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
