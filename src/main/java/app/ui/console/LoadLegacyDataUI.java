package app.ui.console;

import app.controller.LoadLegacyDataController;
import app.domain.model.PerformanceData;
import app.domain.model.SNSUser;
import app.mappers.dto.LegacyDataDTO;
import app.store.PerformanceDataStore;
import app.ui.console.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class LoadLegacyDataUI implements Runnable {

    private final LoadLegacyDataController controller = new LoadLegacyDataController();
    private LegacyDataDTO dto;

    public LoadLegacyDataUI(){
    }

    @Override
    public void run() {
        String filePath = Utils.readLineFromConsole("Please indicate the file path of the file you want to upload: ");
        String time = Utils.readLineFromConsole("Arrival Time or Leaving Time");
        String order = Utils.readLineFromConsole("Ascendent or Descendent");

        try {
            controller.loadLegacyData(filePath, time, order);
        } catch (IOException | ParseException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        List<LegacyDataDTO> m = controller.getPerformanceDataAndExtras();

        for(LegacyDataDTO d: m){
            System.out.println(d);
        }

    }
}
