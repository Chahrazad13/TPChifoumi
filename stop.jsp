<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<h2> La partie s'arrête ici </h2>

<c:forEach items="${sessionScope.users}" var="play">
    <p>${play}</p>
</c:forEach>

</body>
</html>