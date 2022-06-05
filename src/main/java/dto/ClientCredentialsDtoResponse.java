package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientCredentialsDtoResponse {

    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private int expires;
    @JsonProperty("access_token")
    private String accessToken;

}
