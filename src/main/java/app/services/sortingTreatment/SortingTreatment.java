package app.services.sortingTreatment;

import app.domain.model.PerformanceData;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface SortingTreatment {

    List<PerformanceData> sortPerfData(List<PerformanceData> toSort, String time, String ordering) throws IOException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
