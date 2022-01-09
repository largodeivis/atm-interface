<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>ATM Login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<font color="red">${ErrorMessage}</font><br>

<div class="container">
    <caption>Create new ATM Account here:</caption>
    <form:form method="post" modelAttribute="account">
        <fieldset class="form-group">
            <div>
            <form:label path="customer">User ID:</form:label> <form:input type="text" path="customer" class="form-control" required="required"/>
            <form:errors path="customer" cssClass="text-warning"></form:errors>
            </div>

            <div>
            <form:label path="name">Name:</form:label> <form:input type="text" path="name" class="form-control" required="required"/>
            <form:errors path="name" cssClass="text-warning"></form:errors>
            </div>

            <div>
            <form:label path="pin">PIN: </form:label> <form:input type="password" path="pin" class="form-control" required="required"/>
            <form:errors path="pin" cssClass="text-warning"></form:errors>
            </div>

            <div>
            <form:label path="balance">Balance:</form:label> <form:input type="text" path="balance" class="form-control" required="required"/>
            <form:errors path="balance" cssClass="text-warning"></form:errors>
            </div>

         </fieldset>
        <button type="submit" class="btn btn-success">Create</button>
    </form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
