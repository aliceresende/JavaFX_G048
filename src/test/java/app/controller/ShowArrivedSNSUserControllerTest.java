package app.controller;

import app.domain.model.ArrivalOfSNSUser;
import app.store.ArrivalOfSNSUserStore;
import app.mappers.ArrivalOfSNSUserMapper;
import app.mappers.dto.ArrivalOfSNSUserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShowArrivedSNSUserControllerTest {

    @Test
    @DisplayName("Should return the list of ArrivalOfSNSUser from store")
    public void testGetWaitingListShouldReturnTheListOfArrivalOfSNSUserFromStore() {

        ArrivalOfSNSUserStore aStore = new ArrivalOfSNSUserStore();
        ArrivalOfSNSUserMapper aMapper = new ArrivalOfSNSUserMapper();
        ArrayList<ArrivalOfSNSUserDTO> listOfWaitingRoomDTO = new ArrayList<ArrivalOfSNSUserDTO>();
        ArrayList<ArrivalOfSNSUser> listOfWaitingRoomFromStore = new ArrayList<ArrivalOfSNSUser>();
        ShowArrivedSNSUserController controller = new ShowArrivedSNSUserController();

        listOfWaitingRoomFromStore = controller.GetWaitingList();

        assertEquals(aStore.GetArrivalOfSNSUsers(), listOfWaitingRoomFromStore);
    }

}