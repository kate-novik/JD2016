<%@ include file="include/begin-html.jsp" %>
<%@ include file="include/header-html.jsp" %>

<div class="main container">
    <div class="row">
        <div class="pull-right">
            <button type="button" class="btn btn-link">Kate Novik</button>
            <a href="do?command=Accounts&reference=1" class="btn btn-default" type="button">Create Account</a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-3">
            <h2>Main page</h2>
        </div>
    </div>
    <div class="row">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th># of account</th>
                <th>Amount</th>
                <th>State</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>2</td>
                <td></td>
                <td></td>
                <td>
                    <div class="btn-group">
                        <a href="do?command=Refill&id_account=2" class="btn btn-default btn-sm" aria-label="Left Align">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        </a>
                        <a href="do?command=Pay&id_account=2" class="btn btn-default btn-sm" aria-label="Center Align">
                            <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
                        </a>
                        <a href="do?command=Block&id_account=2&reference=1" class="btn btn-default btn-sm" aria-label="Right Align">
                            <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                        </a>
                        <a href="do?command=Payments&id_account=2" class="btn btn-default btn-sm" aria-label="Justify">
                            <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
                        </a>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="include/end-html.jsp" %>