package app.ui.console;

import app.ui.console.utils.Utils;


//import javafx.scene.control.Menu;

import java.util.ArrayList;
import java.util.List;

public class CenterCoordinatorUI implements Runnable{
    public CenterCoordinatorUI(){
    }
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("List all Vaccines",  new ListVacinneUI()));
        options.add(new MenuItem("Analyze the performance of a Center", new PerformanceAnalysisUI()));
        options.add(new MenuItem("Show Number of Vaccinated Users", new VaccinatedUsersUI()));
        options.add(new MenuItem("Load Legacy Data",new LoadLegacyDataUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nCenter Coordinator Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
