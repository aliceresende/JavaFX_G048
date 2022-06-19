package app.domain.model;

import app.domain.shared.Constants;
import org.apache.commons.lang3.StringUtils;

public class WorkingHours {
    private String openingHours;
    private String closingHours;


    public WorkingHours(String openingHours, String closingHours){
        //check_openingHoursRules(openingHours);
        //check_closingHoursRules(closingHours);
        this.openingHours = openingHours;
        this.closingHours = closingHours;

    }
    public void check_openingHourRules(String openingHours) {
        if (StringUtils.isBlank(openingHours))
            throw new IllegalArgumentException("Opening hours cannot have null (blank) value.");
        //if (openingHours.length() != Constants.MAX_openingHours)
            throw new IllegalArgumentException("Opening hours must be lower than Closing hours.");
    }

}
