<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Medicines</title>
    </head>
    <body>
        <table id="medicinesTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${medicines}" var="medicine">
                    <tr>
                        <td>
                            <c:out value="${medicine.id}"/>
                        </td>
                        <td>
                            <c:out value="${medicine.name}"/>
                        </td>
               
                        <td>
                            <spring:url value="/medicines/details/{medicineId}" var="medicinesUrl">
                                <spring:param name="medicineId" value="${medicine.id}"/>
                            </spring:url>
                            <a href="${fn:escapeXml(medicineUrl)}">Details</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>