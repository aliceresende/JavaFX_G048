package app.mappers;

import app.domain.model.ArrivalOfSNSUser;
import app.mappers.dto.ArrivalOfSNSUserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ArrivalOfSNSUserMapperTest {

    private ArrivalOfSNSUserMapper arrivalOfSNSUserMapper;

    @BeforeEach
    public void setUp() {
        arrivalOfSNSUserMapper = new ArrivalOfSNSUserMapper();
    }

    @Test
    @DisplayName("Should return an ArrivalOfSNSUserDTO with the same SNSUserNumber, timeOfArrival and vCenterName as the ArrivalOfSNSUser")
    public void testToDTOWhenArrivalOfSNSUserThenReturnArrivalOfSNSUserDTOWithSameData() {

        ArrivalOfSNSUser arrivalOfSNSUser = new ArrivalOfSNSUser("123456789", "12:00", "Vaccination Center 1");
        ArrivalOfSNSUserDTO arrivalOfSNSUserDTO = arrivalOfSNSUserMapper.toDTO(arrivalOfSNSUser);
        assertEquals(arrivalOfSNSUser.getSNSUserNumber(), arrivalOfSNSUserDTO.getSNSUserNumber());
        assertEquals(arrivalOfSNSUser.getTimeOfArrival(), arrivalOfSNSUserDTO.getTimeOfArrival());
        assertEquals(arrivalOfSNSUser.getvCenterName(), arrivalOfSNSUserDTO.getvCenterName());
    }

}