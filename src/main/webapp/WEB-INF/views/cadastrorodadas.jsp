<%-- 
    Document   : cadastrorodadas
    Created on : 09/12/2015, 09:39:27
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
        <h1>Cadastro de Pedidos</h1>
       
        <form action="pedido/add" method="POST">
            <div>Mesa: <input type="int" name="mesa_id">                
            </div>           
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>


