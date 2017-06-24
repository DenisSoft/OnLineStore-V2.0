<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div class="container">
    <table class="table table-condensed">
        <thead>
        <tr bgcolor="#99CC99">

            <td valign=top>
                <strong>#</strong>
            </td>
            <td valign=top>
                <strong>Firstname</strong>
            </td>
            <td valign=top>
                <strong>Lastname</strong>
            </td>
            <td valign=top>
                <strong>Address</strong>
            </td>
            <td valign=top>
                <strong>E-Mail</strong>
            </td>
            <td valign=top>
                <strong>Phone</strong>
            </td>
            <td valign=top>
                <strong>Password</strong>
            </td>
        </tr>
        </thead>
        <c:forEach var="person" items="${persons}" >
            <tr bgcolor="#CCFFCC">
                <td valign=top>
                        ${person.id}
                </td>
                <td valign=top>
                        ${person.firstName}
                </td>
                <td valign=top >
                        ${person.lastName}
                </td>
                <td valign=top>
                        ${person.address}
                </td>
                <td valign=top>
                        ${person.email}
                </td>
                <td valign=top>
                        ${person.phone}
                </td>
                <td valign=top >
                        ${person.password}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
