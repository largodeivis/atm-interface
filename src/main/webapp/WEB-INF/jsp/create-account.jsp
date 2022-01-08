<html>
<head>
<title>ATM Login</title>
</head>
<body>
<font color="red">${ErrorMessage}</font><br>
Create new ATM Account here:
<BR/>
<form method="post">
    User ID: <input type="text" name="userid"/> <br>
    Name: <input type="text" name="name"/> <br>
    PIN : <input type="password" name="strPin"/> <br>
    Verify PIN <input type="password" name="verifyPin"/> <br>
    Balance: <input type="number" name="balance"/> <br>
    <input type="submit"/>
</form>
</body>
</html>
