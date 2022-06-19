package app.domain.States;

public interface VaccinationProcessStates {

    void arrive();
    void waiting();
    void receiveVaccine();
    void leave();



   
}
