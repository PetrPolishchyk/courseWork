package apiobjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreateRequest {
    private String jsonrpc;
    private String method;
    private String id;
    private Params params;

}
