package edu.fpdual.webapplication.servlet;

import edu.fpdual.webapplication.client.UserClient;
import edu.fpdual.webapplication.dto.User;
import edu.fpdual.webapplication.service.UserService;
import edu.fpdual.webapplication.utilities.Password;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;

import java.io.IOException;

@WebServlet(name = "UpdatePasswordServlet", urlPatterns = {"/update-password-servlet"})
public class UpdatePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String notFoundError = "Codigo incorrecto";
        String ok = "Se ha restablecido tu contraseña";

        String dispatcherURLUpdate = "jsp/login/updatePassword.jsp";

        try {
            UserService userService = new UserService(new UserClient());
            String code = new Password(request.getParameter("code")).toString();
            String newPassword = request.getParameter("newPassword");
            User user = userService.getUserByPassword(code);

            user.setUserPassword(new Password(newPassword).toString());
            userService.updateUser(user);
            request.setAttribute("ok", ok);
            request.getRequestDispatcher(dispatcherURLUpdate).forward(request, response);
        } catch (NotFoundException | NullPointerException | BadRequestException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher(dispatcherURLUpdate).forward(request, response);
        }
    }
}
