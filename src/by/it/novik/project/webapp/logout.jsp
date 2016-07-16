<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/header-html.jsp" %>

<div class="main container">
    <div class="row">
        <div class="col-sm-offset-3">
            <h2>Ending session</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <form class="form-horizontal" action="do?command=Logout" method="POST">
                <div class="form-group">
                    <div class="col-sm-offset-9 col-sm-3">
                        <button type="submit" name="ButtonLogout" value="2" class="btn btn-default">Log Out</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<%@ include file="include/end-html.jsp" %>