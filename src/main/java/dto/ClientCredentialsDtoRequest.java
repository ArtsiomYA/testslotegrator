package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientCredentialsDtoRequest {

    @JsonProperty("grant_type")
    private String grantType;
    private String scope;

}
