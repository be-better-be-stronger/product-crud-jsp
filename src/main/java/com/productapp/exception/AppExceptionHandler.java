package com.productapp.exception;

import java.util.logging.*;

import javax.swing.JOptionPane;

public class AppExceptionHandler {
	private static final Logger logger = Logger.getLogger(AppExceptionHandler.class.getName());

    public static void handle(Exception ex, String action) {
        // Ghi log chi tiết (bao gồm stacktrace)
        logger.log(Level.SEVERE, "Lỗi khi thực hiện: " + action, ex);

        // Hiển thị thông báo cho người dùng
        JOptionPane.showMessageDialog(null,
            "Đã xảy ra lỗi khi " + action + ":\n" + ex.getMessage(),
            "Lỗi hệ thống",
            JOptionPane.ERROR_MESSAGE);
    }

    // Dùng mặc định nếu không truyền tên hành động cụ thể
    public static void handle(Exception ex) {
        handle(ex, "thực hiện thao tác");
    }
}
