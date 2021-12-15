<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Medicines</title>
    </head>
    <body>
        <table id="medicineTable">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <c:out value="${medicine.id}"/>
                    </td>
                    <td>
                        <c:out value="${medicine.name}"/>
                    </td>
                </tr>
            </tbody>
        </table>
        <spring:url value="/medicines" var="medicinesUrl"/>
        <a href="${fn:escapeXml(medicineUrl)}">Volver</a>
    </body>
</html>