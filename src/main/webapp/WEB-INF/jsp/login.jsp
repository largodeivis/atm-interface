<html>
<head>
<title>ATM Login</title>
</head>
<body>
<font color="red">${ErrorMessage}</font>
Login to your ATM Account here:
<BR/>
<form method="post">
    User ID: <input type="text" name="userid"/>
    PIN : <input type="password" name="strPin"/>
    <input type="submit"/>
</form>
<BR/>
<a href="/create-account">Create New Account</a>
</body>
</html>
