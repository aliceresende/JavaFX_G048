package app.mappers;

import app.domain.model.Company;


public class LegacyDataMapper {

    private final SNSUserMapper usermapp;

    private final VaccineMapper vaccmapp;

    private final VaccineTypeMapper typemapp;

    private final Company company;

    public LegacyDataMapper(SNSUserMapper usermapp, Company company, VaccineMapper vaccmapp, VaccineTypeMapper typemapp) {
        this.usermapp = usermapp;
        this.company = company;
        this.vaccmapp = vaccmapp;
        this.typemapp = typemapp;
    }


}
