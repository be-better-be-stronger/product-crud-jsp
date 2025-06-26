package com.productapp.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.productapp.dao.ProductRepositoryImpl;
import com.productapp.model.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class ProductServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
	@Override
    public void init() {
        productService = new ProductServiceImpl();  // Thay vì gọi class cụ thể
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		String action = request.getParameter("action");		
		if(action == null) action = "list";	    
	    switch (action) {
		    case "new":
		        request.setAttribute("product", null);
		        request.getRequestDispatcher("views/form.jsp").forward(request, response);
		        break;
		    case "edit":
		        int id = Integer.parseInt(request.getParameter("id"));
		        Product editProduct = productService.findById(id);
		        request.setAttribute("product", editProduct);
		        request.getRequestDispatcher("views/form.jsp").forward(request, response);
		        break;
		    case "delete":
		        int deleteId = Integer.parseInt(request.getParameter("id"));
		        productService.deleteProductById(deleteId);
		        response.sendRedirect("products");
		        break;
		    default:
		    	List<Product> productList = productService.getAllProducts();
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
	        new ProductRepositoryImpl().insert(product);
	        response.sendRedirect("products");
	    } else if ("update".equals(action)) {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Product product = new ProductRepositoryImpl().findById(id);
	        product.setName(request.getParameter("name"));
	        product.setPrice(Double.parseDouble(request.getParameter("price")));
	        new ProductRepositoryImpl().update(product);
	        response.sendRedirect("products");
	    }
	}

}
