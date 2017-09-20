<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<html>
    <head>
        <title>SpringHibernate | Customers</title>
    </head>
    <body>
        <h1>${title}</h1>

        <c:forEach items="${customers}" var="customer">
            <div class="customerItem">
                <custom:line id="${customer.id}" name="${customer.name}"/>
            </div>
        </c:forEach>
    </body>
</html>
