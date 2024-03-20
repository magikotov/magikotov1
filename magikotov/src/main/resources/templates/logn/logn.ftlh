<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL!</h1>
<h4>Регистрация</h4>
<from action="/registration" methood="post">
имя пользователя: <input type= "text" name="name"><br><br>
Эл.почта: <input type= "email" name="email"><br><br>
Номер телефона: <input type= "text" name="phoneNumber"><br><br>
Пороль: <input type= "password" name="password"><br><br>
 <input type= "hidden" name="_csrf" value="${_csrf.token}>
 <input type= "submit" value="Зарегистрироваться"/>
 </from>
 <#if errorMessage??>
 <h2 style="color: red">${errorMessage}</h2>
 </#if>:

</body>
</html>
