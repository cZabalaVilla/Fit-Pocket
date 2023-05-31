package edu.fpdual.webapplication;

public class GlobalInfo {
    /*
     * URL de la aplicacion
     */
    public static final String URL_PROYECTO = "/ProyectoPrueba";
    /*
     * URL de los .jsp
     */
    public static final String URL_INDEX = URL_PROYECTO + "/";
    public static final String URL_JSP = URL_PROYECTO + "/jsp";
    public static final String URL_JSP_HOME = URL_JSP + "/common/home.jsp";
    public static final String URL_JSP_LOGIN = URL_JSP + "/login/login.jsp";
    public static final String URL_JSP_CONTROLPANEL = URL_JSP + "/admin/controlPanel.jsp";
    public static final String URL_JSP_NEWADMIN = URL_JSP + "/admin/adminManager.jsp";
    public static final String URL_JSP_PROFILE = URL_JSP + "/common/profile.jsp";
    public static final String URL_JSP_RESTOREPASSWORD = URL_JSP + "/login/restorePassword.jsp";
    public static final String URL_JSP_REGISTER = URL_JSP + "/login/register.jsp";
    public static final String URL_JSP_LISTS = URL_JSP + "/admin/database/lists.jsp";
    public static final String URL_JSP_REDIRECCION = URL_JSP + "/redir/redireccion.jsp";
    public static final String URL_JSP_ABOUTUS = URL_JSP + "/aboutUs.jsp";
    public static final String URL_JSP_CONTACTUS = URL_JSP + "/contactUs.jsp";


    /*
     * Páginas de error
     */
    public static final String URL_JSP_ERROR403 = URL_JSP + "/error/error403.jsp";
    public static final String URL_JSP_ERROR404 = URL_JSP + "/error/error404.jsp";
    public static final String URL_JSP_ERROR500 = URL_JSP + "/error/error500.jsp";


    /*
     * URL de los servlets
     */
    public static final String URL_SERVLET_ = URL_PROYECTO;
    public static final String URL_SERVLET_LOGIN = URL_SERVLET_ + "/login-servlet";
    public static final String URL_SERVLET_ADMINMANAGER = URL_SERVLET_ + "/admin-manager-servlet";
    public static final String URL_SERVLET_TEST = URL_SERVLET_ + "/notification-servlet";
    public static final String URL_SERVLET_PROFILE = URL_SERVLET_ + "/profile-servlet";
    public static final String URL_SERVLET_LOGOUT = URL_SERVLET_ + "/logout-servlet";
    public static final String URL_SERVLET_REGISTER = URL_SERVLET_ + "/register-servlet";
    public static final String URL_SERVLET_LISTS = URL_SERVLET_ + "/lists-servlet";
    public static final String URL_SERVLET_PINGLIST = "/ping-list-servlet.jsp";


    /*
     * Variables globales
     */
    public static final String URL_FAVICON = URL_PROYECTO + "/img/icon/favicon.ico";
    public static final String URL_WEBTARGET = "http://localhost:8081/webService/webapi/";
    public static final String session = "session";

}