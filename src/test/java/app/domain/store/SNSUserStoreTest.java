package app.domain.store;

import app.domain.model.SNSUser;
import app.store.SNSUserStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SNSUserStoreTest {

    private SNSUserStore snsUserStore = new SNSUserStore();
    private List<SNSUser> users = new ArrayList<SNSUser>();

    @BeforeEach
    void setUp() throws ParseException {
        users.add(new SNSUser("Alice","Female","19/09/2002","Rua do Isep","404","4004-9","Porto","987654321","987654321@gmail.com","123456789","87654321"));
        SNSUser user = new SNSUser("Diogo","Male","16/6/2000","Rua do Isep","666","3009-987","Vila Nova de Gaia","971234568","971234568@gmail.com","861234579","16234578");

    }


    @Test
    @DisplayName("Should return false when the list of users is not valid")
    public void testValidateCSVUsersWhenListOfUsersIsNotValidThenReturnFalse() throws ParseException {
        List<SNSUser> listUsers = new ArrayList<>();
        SNSUser user1 = new SNSUser("Tiago","Male","5/4/2000","Rua do Isep","666","3009-987","Vila Nova de Gaia","912345678","912345678@gmail.com","812345679","12345678");
        SNSUser user2 = new SNSUser("Luana"," ","15/2/2003","Rua do Isep","676","3009-987","Vila Nova de Gaia","981234567","981234567@gmail.com","891234567","81234567");
        listUsers.add(user1);
        listUsers.add(user2);

        assertFalse(snsUserStore.validateCSVUsers(listUsers));
    }



    /*@Test
=======
/*
    @Test
>>>>>>> Stashed changes
    @DisplayName("Should return CSVFileReaderWithHeader when the file has header")
    public void testKnowsFileTypeWhenTheFileHasHeaderThenReturnCSVFileReaderWithHeader() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
<<<<<<< HEAD
        String filePath = "src/Testing CSV files/csvwithheader";
        CSVFileReader csv = SNSUserStore.knowsFileType(filePath);
        assertTrue(csv instanceof CSVFileReaderWithHeader);
=======
        String filePath = "C:\\Users\\Inês Alves\\OneDrive\\Documentos\\ISEP\\2º Semestre\\Lapr2\\lei-22-s2-1dk-g48\\src\\Testing CSV files\\csvwithheader";
        CSV csv = SNSUserStore.knowsFileType(filePath);
        assertTrue(csv instanceof CSVWithHeader);
>>>>>>> 73893f0bcbbe7090e300da19250356376bda8083
    }

    @Test
    @DisplayName("Should return CSVFileReaderNoHeader when the file has no header")
    public void testKnowsFileTypeWhenTheFileHasNoHeaderThenReturnCSVFileReaderNoHeader() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
<<<<<<< HEAD
        String filePath = "src/Testing CSV files/csvnoheader";
        CSVFileReader csv = SNSUserStore.knowsFileType(filePath);
        assertEquals(CSVFileReaderNoHeader.class, csv.getClass());
=======
        String filePath = "C:\\Users\\Inês Alves\\OneDrive\\Documentos\\ISEP\\2º Semestre\\Lapr2\\lei-22-s2-1dk-g48\\src\\Testing CSV files\\csvnoheader";
        CSV csv = SNSUserStore.knowsFileType(filePath);
        assertEquals(CSVNoHeader.class, csv.getClass());
>>>>>>> 73893f0bcbbe7090e300da19250356376bda8083
    }
*/

    @Test
    @DisplayName("Should return true when all users are valid")
    public void testValidateSNSUsersWhenAllUsersAreValidThenReturnTrue() {
        SNSUserStore snsUserStore = new SNSUserStore();
        assertTrue(snsUserStore.validateSNSUsers(users));
    }


    @Test
    @DisplayName("Should return a string with the name, email and password of the user")
    public void testShowAuthenticationDataShouldReturnStringWithNameEmailAndPasswordOfUser() {
        String pwd = "12345678";
        String expected =
                String.format(
                        "\n\nSNS USER AUTHENTICATION DATA\n\nName: %s\nEmail: %s\nPassword: %s\n",
                        users.get(0).getName(), users.get(0).getEmail(), pwd);

        String actual = snsUserStore.showAuthenticationData(users.get(0), pwd);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should return a string with 7 characters")
    public void testGeneratePasswordShouldReturnAStringWith7Characters() {
        String password = SNSUserStore.generatePassword();
        assertEquals(7, password.length());
    }

    @Test
    @DisplayName("Should return a string with at least one uppercase letter")
    public void testGeneratePasswordShouldReturnAStringWithAtLeastOneUppercaseLetter() {
        String password = SNSUserStore.generatePassword();
        assertTrue(password.matches("^(?=.*[A-Z]).*$"));
    }

    @Test
    @DisplayName("Should return a SNSUser when the name is not null")
    public void testCreateSNSUserWhenNameIsNotNull() throws ParseException {
        SNSUser snsUser = new SNSUser("Luana"," ","15/2/2003","Rua do Isep","676","3009-987","Vila Nova de Gaia","981234567","981234567@gmail.com","891234567","81234567");
        assertNotNull(snsUser);
    }


    @Test
    @DisplayName("Should return a list of SNSUsers")
    public void testGetSnsUserListShouldReturnAListOfSNSUsers() {
        SNSUserStore snsUserStore = new SNSUserStore();
        List<SNSUser> snsUsers = snsUserStore.getSnsUserList();
        assertEquals(0, snsUsers.size());
    }

    @Test
    @DisplayName("Should return true when the SNSUser is not in the list")
    public void testValidateSNSUserWhenSNSUserIsNotInTheListThenReturnTrue() throws ParseException {
        SNSUser snsUser =new SNSUser("Alice","Female","19/09/2002","Rua do Isep","404","4004-9","Porto","987654321","987654321@gmail.com","123456789","87654321");
        assertTrue(snsUserStore.validateSNSUser(snsUser));
    }

}