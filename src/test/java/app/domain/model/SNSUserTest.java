package app.domain.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SNSUserTest {

    @Rule
    public SNSUser snsU;
    public List<SNSUser> snsUserList = new ArrayList<>();

    @BeforeEach
    void setUp() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = df.parse("14-09-2002");
        snsUserList.add(new SNSUser("Alice", date, "1234567890", "123456789", "alice@gmail.com", "Rua das cavacas","200","4000-800","Porto", "Female", "12345678"));
        snsU = new SNSUser("Alice", date, "1234567891", "123456781", "alicer@gmail.com", "Rua das cavacas","24","3000-400","Porto", "Female", "12345678");
    }

    @Test
    void getName() {
        Assert.assertEquals(snsU.getName(),"Alice");
    }

    @Test
    void getEmail() {
        Assert.assertEquals(snsU.getEmail(),"alicer@gmail.com");
    }
}