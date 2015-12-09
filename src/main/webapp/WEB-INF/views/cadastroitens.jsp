<%-- 
    Document   : cadastroitens
    Created on : 08/12/2015, 02:02:28
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
        <h1>Cadastro de Itens</h1>
       
       <form action="item/add" method="POST">
            <div>Produto <input type="int" name="estoque">                
            </div>
            <div>Quantidade <input type="int" name="estoque">
            </div>
            <div>Total <input type="number" name="preco">
            </div> 
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>
