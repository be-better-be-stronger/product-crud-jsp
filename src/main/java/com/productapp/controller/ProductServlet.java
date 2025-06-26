package com.productapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.productapp.dao.ProductDAO;
import com.productapp.model.Product;

public class ProductServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		String action = request.getParameter("action");
//	    if (action == null || action.equals("list")) {
//	        List<Product> productList = new ProductDAO().findAll();
//	        request.setAttribute("productList", productList);
//	        request.getRequestDispatcher("views/list.jsp").forward(request, response);
//	    }
		
		if(action == null) action = "list";
//	    
	    switch (action) {
		    case "new":
		        request.setAttribute("product", null);
		        request.getRequestDispatcher("views/form.jsp").forward(request, response);
		        break;
		    case "edit":
		        int id = Integer.parseInt(request.getParameter("id"));
		        Product editProduct = new ProductDAO().findById(id);
		        request.setAttribute("product", editProduct);
		        request.getRequestDispatcher("views/form.jsp").forward(request, response);
		        break;
		    case "delete":
		        int deleteId = Integer.parseInt(request.getParameter("id"));
		        new ProductDAO().deleteById(deleteId);
		        response.sendRedirect("products");
		        break;
		    default:
		    	List<Product> productList = new ProductDAO().findAll();
		        request.setAttribute("productList", productList);
		        request.getRequestDispatcher("views/list.jsp").forward(request, response);
		        break;
		}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if ("insert".equals(action)) {
	        Product product = new Product();
	        product.setName(request.getParameter("name"));
	        product.setPrice(Double.parseDouble(request.getParameter("price")));
	        new ProductDAO().insert(product);
	        response.sendRedirect("products");
	    } else if ("update".equals(action)) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Product product = new ProductDAO().findById(id);
	        product.setName(request.getParameter("name"));
	        product.setPrice(Double.parseDouble(request.getParameter("price")));
	        new ProductDAO().update(product);
	        response.sendRedirect("products");
	    }
	}

}
