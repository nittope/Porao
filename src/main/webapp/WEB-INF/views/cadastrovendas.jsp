<%-- 
    Document   : cadastrovenda
    Created on : 09/12/2015, 08:15:37
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
        <h1>Cadastro de Vendas</h1>
       
        <form action="venda/add" method="POST">
            <div>Rodada: <input type="int" name="rodadas">
            </div>
            <div>Total: <input type="number" name="total">
            </div>                    
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>

