package models.register;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import data.Credentials;

public class RegisterPayloadModel extends BaseModel {
    @JsonProperty("username")
    private final String username;
    @JsonProperty("email")
    private final String email;
    @JsonProperty("password")
    private final String password;

    public RegisterPayloadModel() {
        final var faker = new Faker();
        username = faker.name().username();
        email = faker.internet().emailAddress();
        password = faker.internet().password();

        Credentials.setEmail(email);
        Credentials.setPassword(password);
        Credentials.setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
