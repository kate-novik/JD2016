<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

      <!-- Основное содержимое -->
      <div class="page-header">
        <h1>Автосервис</h1>
        <p class="lead">Готовим макет для вывода данных в виде таблицы</p>
      </div>

      <h3>Заголовок. Объявления о продаже</h3>
      <p>Строка делится на 12 частей. Для каждой колонки таблицы
         можно указать класс .col-md-N, где N-число частей</p>
      <div class="row">
        <div class="col-md-1">.col-md-1</div>
        <div class="col-md-3">.col-md-3</div>
        <div class="col-md-2">.col-md-2</div>
        <div class="col-md-1">.col-md-1</div>

      </div>

      <div class="row">
        <div class="col-md-1">Модель</div>
        <div class="col-md-3">Год выпуска</div>
        <div class="col-md-2">Пробег</div>
        <div class="col-md-1">Описание поломки</div>
      </div>




<%@ include file="include/end-html.jsp" %>
