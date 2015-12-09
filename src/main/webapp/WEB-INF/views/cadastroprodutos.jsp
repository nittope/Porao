<%-- 
    Document   : cadastroprodutos
    Created on : 08/12/2015, 00:13:25
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
        <h1>Cadastro de Produtos</h1>
       
        <form action="produto/add" method="POST">
            <div>Nome: <input type="text" name="nome">
            </div>
            <div>Estoque: <input type="int" name="estoque">
            </div>
            <div>Preço <input type="number" name="preco">
            </div> 
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>
