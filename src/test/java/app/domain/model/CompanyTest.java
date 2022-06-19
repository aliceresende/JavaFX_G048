package app.domain.model;

import app.store.SNSUserStore;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.isep.lei.esoft.auth.AuthFacade;

class CompanyTest {
    @Rule
    public Company com;
    public SNSUserStore store;
    public AuthFacade auth;

    @BeforeEach
    void setUp() {
        com=new Company("DGS");
        this.store=new SNSUserStore();
        this.auth=new AuthFacade();
    }

    @Test
    void getSNSUserStore() {
        Assert.assertEquals(true,com.getSNSUserStore().getSnsUserList().equals(this.store.getSnsUserList()));
    }

    @Test
    void getDesignation() {
        Assert.assertEquals(com.getDesignation(),"DGS");
    }

    @Test
    void getAuthFacade() {
        Assert.assertEquals(true,com.getAuthFacade().getClass().equals(this.auth.getClass()));
    }
}