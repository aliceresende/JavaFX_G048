package app.ui.console;
import app.controller.ListVaccineController;

/**
 * The type List vacinne ui.
 */
public class ListVacinneUI implements Runnable{
    private ListVaccineController ctrl;

    /**
     * Instantiates a new List vacinne ui.
     */
    public ListVacinneUI(){
        this.ctrl=new ListVaccineController();
    };
    public void run(){
        System.out.println("\n-------#VACCINE LIST#-------\n");
        ctrl.VaccineList();
    }
}
