package app.domain.store;

import app.domain.model.Reactions;
import app.domain.model.SNSUser;
//import app.ui.Persistence;

import java.util.ArrayList;
import java.util.List;

public class ReactionStore {
    List<Reactions> reaction;
    Reactions react;
    public ReactionStore(){
        reaction=new ArrayList<Reactions>();
        /*try{
            reaction = (List<Reactions>) Persistence.readObjectFromFile("AdverseReactions.bin");
        }catch (Exception e){
            //System.out.println("The clientStore was not loaded :)");
        }*/
    }
    public Reactions createReaction(String snsnumber,String allergy,String Vaccine_reaction,String anaphylactic_reaction,String blood_clotting_disorders,
                                String immunodeficiency, String chemo, String this_vaccine){
        this.react = new Reactions(snsnumber, allergy, Vaccine_reaction, anaphylactic_reaction, blood_clotting_disorders,
                immunodeficiency, chemo, this_vaccine);
        return this.react;
    }
    public void saveReaction(){
        reaction.add(this.react);
        System.out.println("\nSucess!!");
    }
    /*public void validate(List<SNSUser> st){
        this.react.checkRules(st);

    }*/

    public List<Reactions> getReactionArray(){
        return reaction;
    }
}
