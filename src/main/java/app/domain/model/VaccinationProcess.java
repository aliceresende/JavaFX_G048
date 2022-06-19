package app.domain.model;

import app.domain.States.VaccinationStates;

import javax.swing.plaf.nimbus.State;


public class VaccinationProcess {


    private VaccinationStates state;
    private String snsuser;


    public VaccinationProcess(String snsuserNumber){
        this.snsuser = snsuserNumber;
        this.state = VaccinationStates.SCHEDULED;
    }


    //instance of vaccination process, will be given a vacination process state, that will be used as the initial state of that process;

    State NOT_VACCINATED;
    State SCHEDULED;
    State ARRIVED;
    State WAITING;
    State ADMINISTERED;
    State LEAVES;


    public void schedules(){

    }
    public void arrives(){
        this.state = VaccinationStates.ARRIVED;
    }

    public void waiting(){
        this.state = VaccinationStates.WAITING;
    }

    public void receivesVaccine() {
        this.state = VaccinationStates.VACCINATED;
    }

    public void leaves(){
        this.state = VaccinationStates.LEAVES;
    }


    public String getSnsuser() {
        return snsuser;
    }

    @Override
    public String toString() {
        return "VaccinationProcess{" +
                ", state=" + state +
                '}';
    }


    //-Apenas o VaccinacionProcess é que contém os estados
//-Criar a VaccinacionProcessStore
//-Tratar da lógica na store relativa à lógica dos VaccinationProcess  (exemplo: ir buscar todos os users com schedule)

    //=======================================


}
