<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Каталог</h1>
        <p class="lead">Готовим макет для вывода данных в виде таблицы</p>
      </div>

      <h3>Телефоны</h3>

      <div class="row">
        <div class="col-md-2">Производитель</div>
        <div class="col-md-2">Название</div>
        <div class="col-md-1">Модель</div>
        <div class="col-md-1">Цена</div>
        <div class="col-md-4">Описание</div>
        <div class="col-md-2"></div>
      </div>

      <div class="row">
        <div class="col-md-2">Apple</div>
        <div class="col-md-2">Iphone</div>
        <div class="col-md-1">5s</div>
        <div class="col-md-1">200</div>
        <div class="col-md-4">крутая мобила</div>
          <label class="col-md-2 control-label" for="buy"></label>
          <div class="col-md-2">
              <button id="buy" name="buy" class="btn btn-success">Купить</button>
          </div>
      </div>




<%@ include file="include/end-html.jsp" %>
