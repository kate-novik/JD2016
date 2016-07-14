<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>

<div class="jumbotron text-center">
    <h1>Лучшие скачки в мире!</h1>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-4">
            <h3>Список забегов</h3>
        </div>
        <div class="col-sm-4">
            <h3>Ещё что-нибудь</h3>
        </div>
        <div class="col-sm-4">
            <h3>Авторизация</h3>
            <form class="form-horizontal" action="do?command=login" method="post" accept-charset="UTF-8">
                <fieldset>

                    <!-- Form Name -->
                    <legend></legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="login">Логин</label>
                        <div class="col-md-5">
                            <input id="login" name="login" type="text" placeholder="Логин" class="form-control input-md"
                                   required="">

                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password">Пароль</label>
                        <div class="col-md-5">
                            <input id="password" name="password" type="password" placeholder="Пароль"
                                   class="form-control input-md"
                                   required="">

                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for=""></label>
                        <div class="col-md-4">
                            <button id="" name="" class="btn btn-primary">Войти</button>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                         <label class="col-md-4 control-label" for=""></label>
                         <div class="col-md-4">
                              <a class="btn btn-primary" href="do?command=register" role="button">Зарегистрироваться</a>
                         </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<%@ include file="include/footer.jsp" %>