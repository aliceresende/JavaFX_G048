package app.domain.store;

import app.domain.model.ComunityMassVaccinationCenter;
import app.domain.model.Schedule;
import app.store.VaccinationCenterStore;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

class RegisterCenterStoreTest {

    @Rule
    public ComunityMassVaccinationCenter center;
    public List<ComunityMassVaccinationCenter> centerList = new ArrayList<ComunityMassVaccinationCenter>();

    @BeforeEach
    void setUp() throws ParseException {
        Schedule sche = new Schedule("08:00","16:00");
        centerList.add(new ComunityMassVaccinationCenter("123","Covid Center","Covid Center Street","911111111","CovidCenter@gmail.com","01111111","www.Covid.com",sche,"5","3"));
        center = new ComunityMassVaccinationCenter("124","Covid Center","Covid Center Street","911111111","CovidCenter@gmail.com","01111111","www.Covid.com",sche,"5","3");
    }

    @Test
    void registersCenter() {
        VaccinationCenterStore store = new VaccinationCenterStore();
        ComunityMassVaccinationCenter teste = store.RegistersCenter("123","Not Covid Center","Not Covid Center Street","911111112","NotCovidCenter@gmail.com","01111112","www.NotCovid.com","08:00","16:00","5","3");
        Assert.assertEquals(false,center.equals(teste));
    }

    @Test
    void ValidateCenter(){
        VaccinationCenterStore store = new VaccinationCenterStore();
        Assert.assertTrue(store.ValidateCenter(center));
    }

    @Test
    void SaveCenter() {
        VaccinationCenterStore store = new VaccinationCenterStore();
        store.SaveCenter(center);
        Assert.assertTrue(store.ArrayListGetter().contains(center));
    }


}