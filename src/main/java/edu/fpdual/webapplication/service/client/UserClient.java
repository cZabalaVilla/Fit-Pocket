package edu.fpdual.webapplication.service.client;

import edu.fpdual.webapplication.service.client.dto.User;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class UserClient extends Client<User> {
    private final WebTarget webTarget;

    private final String URL_DIRECCION = "http://localhost:8080";
    private final String URL_PROYECTO = "/ProyectoPrueba/";

    public UserClient() {
        jakarta.ws.rs.client.Client client = ClientBuilder.newClient();
        this.webTarget = client.target(URL_DIRECCION + URL_PROYECTO + "model/persistence");
    }

    @Override
    public String ping() {
        return webTarget.path("users/ping")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
    }

    @Override
    public User get(String str) {
        return webTarget.path("users/get/" + str)
                .request(MediaType.APPLICATION_JSON)
                .get(User.class);
    }

    @Override
    public User put(String str) {
        return webTarget.path("notifications/get/" + str)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity("", MediaType.APPLICATION_JSON), User.class);
    }

    @Override
    public User post(User user) {
        return webTarget.path("users/post")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(user, MediaType.APPLICATION_JSON), User.class);
    }
}
