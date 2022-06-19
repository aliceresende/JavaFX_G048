package app.ui.console;

import app.controller.ReactionsController;
import app.ui.console.utils.Utils;

public class ReactionsUI implements Runnable{
    private ReactionsController ctrl=new ReactionsController();
    public void formulary(){
        String snsnumber=Utils.readLineFromConsole("\nPlease write the snsuser number: ");
        String sns_name=Utils.readLineFromConsole("\nPlease write the user name: ");
        String allergy="none";
        Boolean answer=Utils.confirm("\nDoes the user have any allergy of important mention? ");
        if (answer){
            allergy=Utils.readLineFromConsole("If yes write it/them here(separate by comas): ");
        }
        String Vaccine_reaction="none";
        answer=Utils.confirm("\nHas the user ever had an allergic reaction from a Vaccine? ");
        if (answer){
            Vaccine_reaction=Utils.readLineFromConsole("If yes write it/them here(separate by comas): ");
        }
        String anaphylactic_reaction=Utils.readLineFromConsole("\nHas the user ever had and anaphylactic reaction?(yes/no) ");
        String blood_clotting_disorders=Utils.readLineFromConsole("\nDoes the user have a blood clotting disorder?(yes/no) ");
        String immunodeficiency=Utils.readLineFromConsole("\nDoes the user have some kind of immunodeficiency?(yes/no) ");
        String chemo=Utils.readLineFromConsole("\nIs the user going under any kind of chemo therapy session?(yes/no) ");
        String this_vaccine="none";
        answer=Utils.confirm("\nHas the user ever had a dose of the Vaccine about to be administered?(yes/no) ");
        if (answer){
            this_vaccine=Utils.readLineFromConsole("\nPlease write down the experience or, by other words, any adverse reaction of the process: ");
        }
        ctrl.registerReaction(snsnumber, sns_name, allergy, Vaccine_reaction, anaphylactic_reaction, blood_clotting_disorders,
                immunodeficiency, chemo, this_vaccine);


    }

    @Override
    public void run() {
        Boolean answer;
        do{
            formulary();
            answer=Utils.confirm("\nIs the information about the adverses reactions of the user right?(yes/no) ->");
            if(answer) {
                ctrl.validateReaction();
                System.out.println("\nSucess!!");
            }
        }while (!answer);
    }
}
