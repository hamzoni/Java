
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #result {
                border: 1px solid;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <canvas id="result" width="600" height="600"></canvas>
        <script>
            let canvas = document.getElementById("result");
            let ctx = canvas.getContext('2d');
            let data = <%= request.getParameter("data") %>;
            
            ctx.lineWidth="2";
            ctx.strokeStyle="green";
            data.forEach(s => {
                ctx.rect(s.x, s.y, s.w, s.h);
            });
            ctx.stroke();
            
            canvas.onclick = function() {
//                window.location = "";
            }
        </script>
    </body>
</html>
