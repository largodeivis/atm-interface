<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>ATM Account</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<font color="red">${ErrorMessage}</font><br>
<div class="container">
    <div>
    <caption>Welcome to your ATM Account ${userid}.</caption>
    </div>

    <div>
    Current Balance: $ ${balance}
    </div>

    <form method="post" >
        <div>
        <input id="amount" name="amount" type="text" required="required"/>
        <a type="button" class="btn btn-success" onclick="this.href='/deposit?customer=${userid}&amount='+document.getElementById('amount').value">Deposit</a>
        <a type="button" class="btn btn-success" onclick="this.href='/withdraw?customer=${userid}&amount='+document.getElementById('amount').value">Withdraw</a>
        </div>
    </form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
function getTextBoxValue() {
  return document.getElementById("amount").value
}
</script>
</body>
</html>