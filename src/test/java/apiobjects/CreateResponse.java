package apiobjects;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateResponse {
    private String jsonrpc;
    private Integer id;
    private Integer result;
}
