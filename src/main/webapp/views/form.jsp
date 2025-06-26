<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.productapp.model.Product" %>
<%
    String action = request.getParameter("action");
    Product product = (Product) request.getAttribute("product");
    boolean isEdit = (product != null && action.equals("edit"));
%>
<html>
<head>
    <title><%= isEdit ? "Sửa sản phẩm" : "Thêm sản phẩm" %></title>
</head>
<body>
    <h2><%= isEdit ? "Sửa sản phẩm" : "Thêm sản phẩm" %></h2>
    <form action="products" method="post">
        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= product.getId() %>"/>
        <% } %>
        Tên: <input type="text" name="name" value="<%= isEdit ? product.getName() : "" %>" required/><br/>
        Giá: <input type="text" name="price" value="<%= isEdit ? product.getPrice() : "" %>" required/><br/>
        <input type="hidden" name="action" value="<%= isEdit ? "update" : "insert" %>"/>
        <button type="submit">Lưu</button>
        <a href="products">Hủy</a>
    </form>
</body>
</html>
