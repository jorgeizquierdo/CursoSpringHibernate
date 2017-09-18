<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SpringHibernate | Customers</title>
</head>
<body>

<h1>${title}</h1>

<c:forEach items="${customers}" var="customer">
    <div class="customerItem">
        [${customer.id}] ${customer.name}
    </div>
</c:forEach>
</body>
</html>
