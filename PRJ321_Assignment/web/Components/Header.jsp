<%@page import="Config.PathConfig"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    application.setAttribute("path", PathConfig.ROOT);
%>

<head>

    <link rel="stylesheet" href="${path}Assets/font/css/awesome.css">
    <link rel="stylesheet" href="${path}Assets/css/bulma/css/bulma.css">
    <script src="${path}Assets/js/axios.js"></script>
    <script src="${path}Assets/js/vue.js"></script>
    <link rel="stylesheet" href="${path}Assets/texteditor/css/froala_editor.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/froala_style.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/code_view.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/colors.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/emoticons.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/image_manager.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/image.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/line_breaker.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/table.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/char_counter.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/video.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/fullscreen.css">
    <link rel="stylesheet" href="${path}Assets/texteditor/css/plugins/file.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">

    <style>
        table thead tr th,
        .text-center
        {
            text-align: center !important;
        }
        a {
            text-decoration: none !important;
        }
        .navbar {
            background: transparent;
        }
    </style>
</head>