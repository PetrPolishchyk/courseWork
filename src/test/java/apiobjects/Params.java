package apiobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Params {
    //user
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
    //project
    private String description;
    private Integer owner_id;
    private String identifier;
    //add project to user
    private Integer project_id;
    private Integer user_id;
    //task
    private String title;
    private String color_id;
    private Integer column_id;
    private Integer creator_id;
    private Integer category_id;
    private Integer score;
    private Integer swimlane_id;
    private Integer priority;
    private Integer recurrence_status;
    private Integer recurrence_trigger;
    private Integer recurrence_factor;
    private Integer recurrence_timeframe;
    private Integer recurrence_basedate;
    private String reference;
    private Integer task_id;

}
