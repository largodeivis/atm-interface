<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>ATM Accounts</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <caption>ATM Account List</caption>
        <thead>
            <tr>
                <th>User ID</th>
                <th>Name </th>
                <th>Balance </th>
            </tr>
        <thead>
        <tbody>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.customer}</td>
                    <td>${account.name}</td>
                    <td>${account.balance}</td>
                </tr>
            </c:forEach>
        <tbody>
    </table>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>