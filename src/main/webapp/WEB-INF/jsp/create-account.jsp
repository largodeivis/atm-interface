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
    <form method="post">
        <fieldset class="form-group">
            <label>User ID:</label> <input type="text" name="userid" required="required"/>
            <label>Name:</label> <input type="text" name="name"/>
            <label>PIN: </label> <input type="password" name="strPin" required="required"/>
            <label>Verify PIN: </label> <input type="password" name="verifyPin" required="required"/>
            <label>Balance:</label> <input type="text" name="balance" required="required"/>
         </fieldset>
        <button type="submit" class="btn btn-success">Create</button>
    </form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
