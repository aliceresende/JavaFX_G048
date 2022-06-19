package app.controller;

import app.domain.model.Company;
import app.domain.model.Reactions;
import app.domain.model.SNSUser;
import app.domain.store.SNSUserStore;
import app.domain.store.ReactionStore;

import java.util.List;

public class ReactionsController {
    private Company company;
    private SNSUserStore snsStore;
    private ReactionStore store;
    private Reactions reaction;
    private List<SNSUser> st;
    public ReactionsController(){this(App.getInstance().getCompany());}
    public ReactionsController(Company company){
        snsStore=company.getSNSUserStore();
        store=company.getReactionStore();
        this.reaction=null;
    }
    public void registerReaction(String snsnumber,String allergy,String Vaccine_reaction,String anaphylactic_reaction,String blood_clotting_disorders,
                                 String immunodeficiency, String chemo, String this_vaccine){
        store.createReaction(snsnumber, allergy, Vaccine_reaction, anaphylactic_reaction, blood_clotting_disorders,
                immunodeficiency, chemo, this_vaccine);
    }
    public void validateReaction(){

        //this.store.validate(snsStore.getSnsUserList());
        this.store.saveReaction();
    }

}
