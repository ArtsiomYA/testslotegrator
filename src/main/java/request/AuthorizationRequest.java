package request;

import dto.ClientCredentialsDtoRequest;
import dto.ClientCredentialsDtoResponse;
import io.restassured.response.Response;

import java.util.Optional;

public class AuthorizationRequest extends RestService {

    public Optional<ClientCredentialsDtoResponse> getToken(ClientCredentialsDtoRequest clientCredentialsDtoRequest, String userName, String password) {
        Response response =  postReq(clientCredentialsDtoRequest, "oauth2/token", userName, password);
        if (response.statusCode() == 200 || response.statusCode() == 201 ) {
            return Optional.of(response.as(ClientCredentialsDtoResponse.class));
        } return Optional.empty();
    }

}
