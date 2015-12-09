<%-- 
    Document   : cadastropedidos
    Created on : 09/12/2015, 09:39:08
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
            <div>Data do Pedido: <input type="date" name="data">                
            </div>
            <div>Hora do Pedido: <input type="time" name="horaPedido">
            </div>  
            <div>Mesa: <input type="int" name="mesa_id">
            </div>
            <div>Usuario: <input type="int" name="usuario_id">
            </div>
            <div>Rodada: <input type="int" name="rodada_id">
            </div>
            <div>Cliente: <input type="int" name="cliente_id">
            </div>
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>

