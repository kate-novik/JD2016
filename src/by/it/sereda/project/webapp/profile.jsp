<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=PROFILE" method="POST">

    <p>Login:<b>          ${ProfileLogin}</b></p>
    <hr>
    <p>Email:<b>          ${ProfileEmail}</b></p>
    <hr>
    <p>Ads (DEBUG):<br>   ${ProfileAds}</p>

   <fieldset>

        <!-- Form Name -->
        <legend>Вы хотите завершенить сеанс?</legend>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LogoutButton"></label>
            <div class="col-md-4">
                <button id="LogoutButton" name="LogoutButton" value="1" class="btn btn-success">Да, завершить.</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
