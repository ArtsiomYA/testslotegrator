package request;

import dto.AuthorizationDtoRequest;
import dto.AuthorizationDtoResponse;
import dto.ClientDtoRequest;
import dto.ClientDtoResponse;
import io.restassured.response.Response;

import java.util.Optional;

public class ClientRequest extends RestService {

    public Optional<ClientDtoResponse> registerClientInSystem(ClientDtoRequest clientDtoRequest, String token) {
        Response response = postReq(clientDtoRequest, "players" , token);
        if (response.statusCode() == 201) {
            return Optional.of(response.as(ClientDtoResponse.class));
        } return Optional.empty();
    }

    public Optional<AuthorizationDtoResponse> authorizationPlayerInSystem(AuthorizationDtoRequest authorizationDtoRequest, String userName, String password) {
        Response response = postReq(authorizationDtoRequest, "oauth2/token", userName, password);
        if (response.statusCode() == 200) {
            return Optional.of(response.as(AuthorizationDtoResponse.class));
        } return Optional.empty();
    }

    public Optional<ClientDtoResponse> getInfoProfilePlayer(String token, int id) {
        Response response = getReq(id, "players/", token);
        if (response.statusCode() == 200) {
            return Optional.of(response.as(ClientDtoResponse.class));
        } return Optional.empty();
    }

    public Optional<ClientDtoResponse> getInfoProfileOtherPlayer(String token, int id) {
        Response response = getReq(id, "players/", token);
        if (response.statusCode() == 404) {
            return Optional.empty();
        } return Optional.of(response.as(ClientDtoResponse.class));
    }

}
