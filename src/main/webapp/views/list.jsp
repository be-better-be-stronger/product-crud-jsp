<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.productapp.model.Product" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <h2>Danh sách sản phẩm</h2>
    <a href="products?action=new">➕ Thêm sản phẩm</a>
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Hành động</th>
        </tr>
        <%-- <%
            List<Product> list = (List<Product>) request.getAttribute("productList");
            if (list != null) {
                for (Product p : list) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getPrice() %></td>
            <td>
                <a href="products?action=edit&id=<%= p.getId() %>">Sửa</a> |
                <a href="products?action=delete&id=<%= p.getId() %>">Xóa</a>
            </td>
        </tr>
        <%
                }
            }
        %> --%>
        <c:forEach var="p" items="${productList}">
		    <tr>
		        <td>${p.id}</td>
		        <td>${p.name}</td>
		        <td>${p.price}</td>
		        <td>
		            <a href="products?action=edit&id=${p.id}">Sửa</a> |
		            <a href="products?action=delete&id=${p.id}">Xóa</a>
		        </td>
		    </tr>
		</c:forEach>
    </table>
</body>
</html>
