package app.ui.console;
import app.controller.ListVaccineController;
public class ListVacinneUI implements Runnable{
    private ListVaccineController ctrl;
    public ListVacinneUI(){
        this.ctrl=new ListVaccineController();
    };
    public void run(){
        System.out.println("\n-------#VACCINE LIST#-------\n");
        ctrl.VaccineList();
    }
}
