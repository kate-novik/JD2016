<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<main>
    <div class="container">
        <form class="form-horizontal" action="do?command=Index" method="POST">
            <p>Здесь будет список всех автомобилей</p>
            <p>${ListCars}</p>
        </form>
    </div>
</main>
<%@ include file="include/end-html.jsp" %>
