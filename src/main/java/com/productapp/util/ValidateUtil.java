package com.productapp.util;

import java.time.LocalDate;

import com.productapp.exception.AppException;
import com.productapp.model.Product;



public class ValidateUtil {
	// Kiểm tra số nguyên
	private static int parsePositiveInt(String input, String fieldName) {
		try {
			int value = Integer.parseInt(input.trim());
			if (value < 0) {
				throw new com.productapp.exception.AppException("Trường '" + fieldName + "' không được âm.");
			}
			return value;
		} catch (NumberFormatException e) {
			throw new AppException("Trường '" + fieldName + "' phải là số nguyên hợp lệ.");
		}
	}

	// Kiểm tra số thực
	private static double parsePositiveDouble(String input, String fieldName) {
		try {
			double value = Double.parseDouble(input.trim());
			if (value < 0) {
				throw new AppException("Trường '" + fieldName + "' không được âm.");
			}
			return value;
		} catch (NumberFormatException e) {
			throw new AppException("Trường '" + fieldName + "' phải là số thực hợp lệ.");
		}
	}

	public static Product validateForm(String idText, String name, String priceText, String quantityText, String unit,
			String createdBy, FormMode mode) {
		if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty() || unit.isEmpty() || createdBy.isEmpty()) {
			throw new AppException("Vui lòng điền đầy đủ thông tin sản phẩm.");
		}

		double price = parsePositiveDouble(priceText, "Giá sản phẩm");
		int quantity = parsePositiveInt(quantityText, "Số lượng");

		if (mode == FormMode.ADD) {
			return new Product(name, price, quantity, unit, LocalDate.now(), createdBy);
		} else {
			int id = parsePositiveInt(idText, "Mã sản phẩm");
			return new Product(id, name, price, quantity, unit, LocalDate.now(), createdBy);
		}
	}
}
