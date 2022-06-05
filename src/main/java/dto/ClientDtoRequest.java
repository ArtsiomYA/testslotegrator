package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDtoRequest {

    @JsonProperty(value = "username", required = true)
    private String userName;
    @JsonProperty(value = "password_change", required = true)
    private String passwordChange;
    @JsonProperty(value = "password_repeat", required = true)
    private String passwordRepeat;
    @JsonProperty(required = true)
//    @JsonFormat(pattern = "")
    private String email;
    private String name;
    private String surname;
    @JsonProperty("currency_code")
    private String currencyCode;

}
