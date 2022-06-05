package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorizationDtoRequest {

    @JsonProperty("grant_type")
    private String grantType;
    @JsonProperty("username")
    private String userName;
    private String password;

}
