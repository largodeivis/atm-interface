<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>ATM Login</title>
</head>
<body>
<font color="red">${ErrorMessage}</font><br>
<div>
Create new ATM Account here:
</div>
<div class="container">
    <form:form method="post" modelAttribute="account">
        <fieldset class="form-group">
            <form:label path="customer">User ID:</form:label> <form:input type="text" path="customer" class="form-control" required="required"/>
            <form:label path="name">Name:</form:label> <form:input type="text" path="name" class="form-control"/>
            <form:label path="pin">PIN: </form:label> <form:input type="password" path="pin" class="form-control" required="required"/>
            <label>Verify PIN: </label> <input type="password" name="verifyPin" required="required"/>
            <form:label path="balance">Balance:</form:label> <form:input type="text" path="balance" class="form-control" required="required"/>
         </fieldset>
        <button type="submit" class="btn btn-success">Create</button>
    </form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
