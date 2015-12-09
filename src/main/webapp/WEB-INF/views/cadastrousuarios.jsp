<%-- 
    Document   : cadastroUsuario
    Created on : 06/11/2015, 23:20:07
    Author     : Anna Paula, Ivson, Marcus Vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Usuarios</h1>
       
        <form action="usuario/add" method="POST">
            <div>Nome: <input type="text" name="nome">
            </div>
            <div>Nivel de Acesso: <input type="int" name="niveldeacesso">
            </div>
            <div>Login: <input type="text" name="login">
            </div>
            <div>Senha: <input type="text" name="senha">
            </div>            
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>
