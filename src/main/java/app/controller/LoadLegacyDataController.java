package app.controller;


import app.domain.model.*;
import app.domain.model.CSV.CSV;
import app.mappers.PerformanceDataMapper;
import app.service.algorithms.sorting.SortingTimeService;
import app.store.NewVaccineStore;
import app.store.NewVaccineTypeStore;
import app.store.PerformanceDataStore;
import app.store.SNSUserStore;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Load legacy data controller.
 */
public class LoadLegacyDataController {

    private Company company;
    private String filePath;
    private SNSUserStore userStore;
    private NewVaccineStore vaccineStore;
    private NewVaccineTypeStore typeStore;
    private String sCriteria;
    private String sOrder;
    private PerformanceDataStore perfdataStore;
    private List<PerformanceData> importedData;

    private PerformanceDataMapper pdmapper;

    /**
     * Gets company.
     *
     * @return the company
     */
    public Company getCompany() {
        return this.company;
    }



    /**
     * Instantiates a new Load legacy data controller.
     *
     */
    public LoadLegacyDataController(){
        this.company =  App.getInstance().getCompany();

        //UserSession cc = App.getInstance().getCurrentUserSession();
        //this.email = cc.getUserId().getEmail();

        userStore = company.getSNSUserStore();
        vaccineStore = company.getVaccineStore();
        typeStore = company.getVaccineTypeList();
        perfdataStore = company.getPerformanceDataStore();

        this.importedData = new ArrayList<>();

    }
    /**
     * method that receives from ui the criteria for sorting
     * @return
     */



    public void loadLegacyData(String path, String index, String order) throws IOException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<List<String>> csvInfo = new ArrayList<>();
        this.filePath = path;
        this.sCriteria = index;
        this.sOrder = order;

        CSV csv;

        try {
            csv = company.knowsFileType(filePath);

        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("Something is wrong with the file");
            return;
        }

        csvInfo = readFile(filePath,csv);
        csvInfo = userStore.validPDUser(csvInfo);

        if(!csvInfo.isEmpty()){
            if(!vaccineStore.validPDVaccine(csvInfo)){
                //throw IllegalArgumentException ("The vaccine is not registered in the system!");
            }else{
                for(List<String> i : csvInfo){
                    PerformanceData pd = perfdataStore.createPerformanceData(i.get(0),i.get(1),i.get(2),i.get(3),i.get(4),i.get(5),i.get(6),i.get(7)) ;
                    this.importedData.add(pd);
                    perfdataStore.savePerformanceData(pd);
                }

                SortingTimeService s = new SortingTimeService();
                this.importedData = s.sortPerfData(importedData, sCriteria, sOrder);
            }
        }


    }


    //-----------------------------------------------------------------------------
    public List<List<String>> readFile(String filePath, CSV csv) {

        List<List<String>> csvInfo = new ArrayList<>();

        try {
            csvInfo = csv.readFile(filePath,csvInfo); // using the instance to read the file

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return csvInfo;
    }
    //--------------------------------------------------------------------------

    public List<PerformanceData> getPerformanceDataAndExtras() {
        List<PerformanceData> importedData = this.importedData;
        List<String> name = new ArrayList<>();
        List<String> descr = new ArrayList<>();
        String vaccid ;

        for(PerformanceData id: importedData){
            name.add(userStore.username(id.getSnsUserNumber()));
            vaccid = vaccineStore.vaccID(id.getVaccineName());
            descr.add(typeStore.vaccDescription(vaccid));
        }

        //return pdmapper.multipleToDTO(importedData);

        return importedData;
    }


    /*public List<List<String>> getPerformanceDataAndExtras(){

        List<List<String>> order = new ArrayList<>();
        List<String> lineData = new ArrayList<>();
        for (PerformanceData d: perfdata){
            lineData.add(d.getSnsUserNumber());
            lineData.add(username(d.getSnsUserNumber()));
            lineData.add(d.getVaccineName());
            lineData.add(vaccDescription(d.getVaccineName()));
            lineData.add(d.getDose());
            lineData.add(d.getLotNumber());
            lineData.add(d.getSchedule());
            lineData.add(d.getArrival());
            lineData.add(d.getAdministration());
            lineData.add(d.getLeaving());

            order.add(lineData);
        }

        return order;

    }
    /**
     * Gets the list of PerformanceData with extras
     *
     * @return list of PerformanceData with extras
     */


   /* public String username(String usernumber){
        List<SNSUser> u = userStore.getSnsUserList();
        String username = "";
        for(SNSUser user: u){
            if(user.getSnsUserNumber().equals(usernumber)){
                username = user.getName();
            }
        }
        return username;
    }

    public String vaccDescription (String vaccinename){
        List<Vaccine> vacc = vaccineStore.ArrayList();
        List<VaccineType> type = typeStore.getVaccineTypeList();
        String description = "", id ="";
        for(Vaccine v: vacc){
            if(v.get_designation().equals(vaccinename)){
                id=v.get_code();
                for(VaccineType t: type){
                    if(t.getCode().equals(id)) {
                        description = t.getTech();
                    }
                }
            }
        }
        return description;
    }*/

   /* public List<PerformanceDataDTO> getPerformanceDataAndExtras() {
        return pdmapper.multipleToDTO(perfdata);
    }*/



    //============================DTO_TO_PRINT=======================================================

    //=====================================


}
