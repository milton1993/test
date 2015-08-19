package com.mitong.test.servlet;

import com.mitong.test.factory.ServiceFactory;
import com.mitong.test.model.User;
import com.mitong.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    private static final UserService USER_SERVICE = ServiceFactory.getUserService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = USER_SERVICE.userLogin(username, password);
            if(user != null) {
                if(user.isAdmin()) {
                    response.sendRedirect("user_manage.jsp");
                } else {

                }
            } else {
                response.sendRedirect("login.jsp?message=username or password is incorrect");
            }
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("The encoding for request is unsupported", e);
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
    }
}
