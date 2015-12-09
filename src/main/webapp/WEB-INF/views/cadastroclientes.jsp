<%-- 
    Document   : cadastroclientes
    Created on : 09/12/2015, 07:38:36
    Author     : Anna Paula, Ivson, Marcus Vinicius
--%>

<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Clientes</h1>
       
        <form action="cliente/add" method="POST">
            <div>Nome: <input type="text" name="nome">                
            </div> 
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>
