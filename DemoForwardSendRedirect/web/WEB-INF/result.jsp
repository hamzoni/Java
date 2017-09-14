

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <p>Message: ${message}</p>
        <canvas id="result"></canvas>
        <script>
            let canvas = document.getElementById("result");
            let ctx = canvas.getContext('2d');
            let shape = {
                x: null
                
            };
//            ctx.drawRectangle();
        </script>
    </body>
</html>
