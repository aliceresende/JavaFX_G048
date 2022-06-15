package app.mappers;

import app.controller.App;
import app.domain.model.ArrivalOfSNSUser;
import app.domain.model.Company;
import app.domain.store.ArrivalOfSNSUserStore;
import app.mappers.dto.ArrivalOfSNSUserDTO;

/**
 * The type Arrival of sns user mapper.
 */
public class ArrivalOfSNSUserMapper {
    private final Company company;
    private final ArrivalOfSNSUserStore arrivalStore;

    /**
     * Instantiates a new Arrival of sns user mapper.
     */
    public ArrivalOfSNSUserMapper() {
        company = App.getInstance().getCompany();
        arrivalStore = company.getArrivalStore();
    }

    /**
     * Sends the SNS user data to the DTO and creating a new DTO copy of the SNS user data
     *
     * @param user the user
     * @return returns the DTO of the SNS user data
     */
    public ArrivalOfSNSUserDTO toDTO(ArrivalOfSNSUser user){
        return new ArrivalOfSNSUserDTO(user.getSNSUserNumber(), user.getTimeOfArrival(), user.getvCenterName());

    }
}
