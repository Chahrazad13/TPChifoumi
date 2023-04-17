<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    body {
        background-color: ${userColor};
    }
</style>

<body>
<h4> Tapez 1 pour pierre 2 pour feuille ou 3 pour ciseaux</h4>

<form action="${pageContext.request.contextPath}/" method="post" >
    <input type="number" name="Input" placeholder="tapez ici" >
    <button type="submit">Ok</button>

</form>
<button action="redirect" method="get" name="Replay" type="submit">Rejouer</button>

<c:forEach items="${sessionScope.users}" var="play">
    <p>${play}</p>
</c:forEach>
<c:forEach items="${sessionScope.redirect}" var="redirection">
    <p>${redirection}</p>
</c:forEach>

</body>
</html>