import dto.AuthorizationDtoRequest;
import dto.ClientCredentialsDtoRequest;
import dto.ClientDtoRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import request.AuthorizationRequest;
import request.ClientRequest;
import utils.Coder;


public class ApiTests {

    private ClientCredentialsDtoRequest clientCredentialsDtoRequest;
    private AuthorizationRequest authorizationRequest;
    private ClientRequest clientRequest;
    private ClientDtoRequest clientDtoRequest;
    private AuthorizationDtoRequest authorizationDtoRequest;
    private String token;
    private final String userName = "front_2d6b0a8391742f5d789d7d915755e09e";

    @BeforeEach
    public void init() {
        authorizationRequest = new AuthorizationRequest();
        clientRequest = new ClientRequest();
        clientCredentialsDtoRequest = ClientCredentialsDtoRequest.builder()
                .grantType("client_credentials")
                .scope("guest:default")
                .build();
        clientDtoRequest = ClientDtoRequest.builder()
                .email(RandomStringUtils.randomAlphabetic(6) + "@example.com")
                .name(RandomStringUtils.randomAlphabetic(6))
                .passwordChange(Coder.encode("password1234"))
                .passwordRepeat(Coder.encode("password1234"))
                .surname(RandomStringUtils.randomAlphabetic(6))
                .userName(RandomStringUtils.randomAlphabetic(7))
                .build();
        authorizationDtoRequest = AuthorizationDtoRequest.builder()
                .grantType("client_credentials")
                .userName(clientDtoRequest.getUserName())
                .password(Coder.encode("password1234"))
                .build();
    }

    @org.junit.jupiter.api.Test
    public void getTokenGuest() {
        Assertions.assertTrue(authorizationRequest.getToken(clientCredentialsDtoRequest, userName, "").isPresent());
    }

    @org.junit.jupiter.api.Test
    public void registerClient() {
        token = authorizationRequest.getToken(clientCredentialsDtoRequest, userName, "").get().getAccessToken();
        Assertions.assertTrue(clientRequest.registerClientInSystem(clientDtoRequest, token).isPresent());
    }

    @org.junit.jupiter.api.Test
    public void authorizationPlayer() {
        Assertions.assertTrue(clientRequest.authorizationPlayerInSystem(authorizationDtoRequest, userName, "").isPresent());
    }

    @org.junit.jupiter.api.Test
    public void getInfoProfilePlayer() {
        token = authorizationRequest.getToken(clientCredentialsDtoRequest, userName, "").get().getAccessToken();
        int id = clientRequest.registerClientInSystem(clientDtoRequest, token).get().getId();
        token = clientRequest.authorizationPlayerInSystem(authorizationDtoRequest, userName, "").get().getAccessToken();
        Assertions.assertTrue(clientRequest.getInfoProfilePlayer(token, id).isPresent());
    }

    @org.junit.jupiter.api.Test
    public void getInfoProfileOtherPlayer() {
        token = clientRequest.authorizationPlayerInSystem(authorizationDtoRequest, userName, "").get().getAccessToken();
        int id = clientRequest.registerClientInSystem(clientDtoRequest, token).get().getId();
        Assertions.assertTrue(clientRequest.getInfoProfileOtherPlayer(token, id).isEmpty());
    }

}
