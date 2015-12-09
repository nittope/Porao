<%-- 
    Document   : cadastromesas
    Created on : 08/12/2015, 15:06:09
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
        <h1>Cadastro de Mesas</h1>
       
        <form action="mesa/add" method="POST">
            <div>Nome da Mesa: <input type="text" name="nome">                
            </div>
            <div>Status da Mesa: <input type="text" name="status">
            </div>            
            <div><input type ="submit" value ="Enviar">
            </div>
        </form>   
    </body>
</html>

