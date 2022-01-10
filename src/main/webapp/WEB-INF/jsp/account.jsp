<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>ATM Account</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<font color="red">${ErrorMessage}</font><br>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="/account" class="navbar-brand">ATM Interface</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/login">Home</a></li>
			<li><a href="/account">Account</a></li>

		</ul>
	</div>
</nav>
<div class="container">
    <div>
    <caption>Welcome to your ATM Account ${userid}.</caption>
    </div>

    <div>
    Current Balance: $ ${balance}
    </div>

    <form >
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
</script>
</body>
</html>