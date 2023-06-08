<%@ page import="edu.fpdual.webapplication.dto.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="edu.fpdual.webapplication.service.CategoryService" %>
<%@ page import="edu.fpdual.webapplication.client.CategoryClient" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="../insert/headTemplate.jsp" %>
    <title>Categorias</title>
    <link rel="stylesheet" href="<%=GlobalInfo.URL_PROYECTO%>/css/style_v2.css"/>
</head>

<body>
<div class="container">
    <%@ include file="../insert/header.jsp" %>
    <main>
        <%@ include file="../insert/mainNav.jsp" %>
        <div class="mainBlock">
            <div class="content">
                <%List<Category> basicCategories = new CategoryService(new CategoryClient()).getAllCategoriesByUserId(thisSession.getUserId());%>
                <% for (Category category : basicCategories) {
                %><p><%=category.getCategoryName()%>
                </p>
                <% } %>
            </div>
        </div>
        <%@ include file="../insert/footer.jsp" %>
    </main>
</div>
</body>

</html>
