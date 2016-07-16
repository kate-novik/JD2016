<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=SIGNUP" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Form Name</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="id">ID</label>
                <div class="col-md-2">
                    <input id="id" name="id" placeholder="id" class="form-control input-md" type="text">
                    <span class="help-block">ID пользователя</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">Login</label>
                <div class="col-md-4">
                    <input id="login" name="login" placeholder="логин" class="form-control input-md" type="text">
                    <span class="help-block">Введите логин</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="pass">Password</label>
                <div class="col-md-4">
                    <input id="pass" name="pass" placeholder="пароль" class="form-control input-md" type="text">
                    <span class="help-block">Введите пароль</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">E-mail</label>
                <div class="col-md-4">
                    <input id="email" name="email" placeholder="почта" class="form-control input-md" type="text">
                    <span class="help-block">Введите почту</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">Name</label>
                <div class="col-md-4">
                    <input id="name" name="name" placeholder="имя" class="form-control input-md" type="text">
                    <span class="help-block">Введите имя</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="lastname">Last Name</label>
                <div class="col-md-4">
                    <input id="lastname" name="lastname" placeholder="фамилия" class="form-control input-md" type="text">
                    <span class="help-block">Введите фамилию</span>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="address">Address</label>
                <div class="col-md-4">
                    <input id="address" name="address" placeholder="адрес" class="form-control input-md" type="text">
                    <span class="help-block">Введите адрес</span>
                </div>
            </div>

            <!-- Select Basic -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="role">Role</label>
                <div class="col-md-2">
                    <select id="role" name="role" class="form-control">
                        <option value="1">Administrator</option>
                        <option value="2">User</option>
                        <option value="3">Guest</option>
                    </select>
                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="registr"></label>
                <div class="col-md-4">
                    <button id="registr" name="registr" class="btn btn-success">Зарегистрировать</button>
                </div>
            </div>

        </fieldset>
    </form>

<%@ include file="include/end-html.jsp" %>