package edu.fpdual.webapplication.dto;

import edu.fpdual.webapplication.utilities.InvalidPasswordException;
import edu.fpdual.webapplication.utilities.Password;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private boolean isAdmin;


    public User(String userName, String userPassword, boolean isAdmin) throws InvalidPasswordException {
        this.userName = userName;
        this.userPassword = new Password(userPassword, userName).toString();
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        String esAdmin = "NO";
        if (isAdmin) esAdmin = "SI";
        return "Usuario: " + userName
                + " | Id de usuario: " + userId
                + " | Password: " + userPassword
                + " | Administrador?: " + esAdmin;
    }
}
