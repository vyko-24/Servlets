<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de personas</title>
    <%@include file="../../layouts/head.jsp"%>
</head>
<body>

<%@include file="../../layouts/navbar.jsp"%>
<h1>Index de Personas</h1>

<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col-6">PERSONAS</div>
                        <div class="col-6 text-end">
                            <a href="createPersons" class="btn btn-outline-success btn-sm">Registrar personas</a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Perfil</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellido</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Rol</th>
                            <th scope="col">Edad</th>
                            <th scope="col">Fecha de nacimiento</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Telefono</th>
                            <th scope="col">Accionesaa</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${personList}" var="person" varStatus="status">
                            <tr>
                                <th scope="row"><c:out value="${status.count}"></c:out></th>
                                <td><img src="data:image/png;base64, ${person.image}" style="height: 50px; width: 50px" class="rounded-circle"></td>
                                <td> <c:out value="${person.name}"></c:out> </td>
                                <td> <c:out value="${person.lastname}"></c:out> </td>
                                <td> <c:out value="${person.username}"></c:out> </td>
                                <td> <c:out value="${person.role}"></c:out> </td>
                                <td> <c:out value="${person.age}"></c:out> </td>
                                <td> <fmt:formatDate value="${person.birthday}" pattern="dd/mm/yyyy"></fmt:formatDate> </td>
                                <td> <c:out value="${person.email}"></c:out> </td>
                                <td> <c:out value="${person.phone}"></c:out> </td>
                                <td><a href="">Editar</a> <a href="">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../layouts/footer.jsp"/>


</body>
</html>
