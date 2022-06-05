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
public class ClientDtoResponse {

	private int id;
	@JsonProperty("country_id")
	private String countryId;
	@JsonProperty("timezone_id")
	private String timezoneId;
	@JsonProperty("username")
	private String userName;
	private String email;
	private String name;
	private String surname;
	private String gender;
	@JsonProperty("phone_number")
	private String phoneNumber;
	@JsonProperty("birthdate")
	private String birthDate;
	@JsonProperty("bonuses_allowed")
	private boolean bonusesAllowed;
	@JsonProperty("is_verified")
	private boolean isVerified;

}
