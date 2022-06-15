package app.domain.model;

import org.apache.commons.lang3.StringUtils;

/**
 * The type Working hours.
 */
public class WorkingHours {
    private String openingHours;
    private String closingHours;


    /**
     * Instantiates a new Working hours.
     *
     * @param openingHours the opening hours
     * @param closingHours the closing hours
     */
    public WorkingHours(String openingHours, String closingHours){
        //check_openingHoursRules(openingHours);
        //check_closingHoursRules(closingHours);
        this.openingHours = openingHours;
        this.closingHours = closingHours;

    }

    /**
     * Check opening hour rules.
     *
     * @param openingHours the opening hours
     */
    public void check_openingHourRules(String openingHours) {
        if (StringUtils.isBlank(openingHours))
            throw new IllegalArgumentException("Opening hours cannot have null (blank) value.");
        //if (openingHours.length() != Constants.MAX_openingHours)
            throw new IllegalArgumentException("Opening hours must be lower than Closing hours.");
    }

}
