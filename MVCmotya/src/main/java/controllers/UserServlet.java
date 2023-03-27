package controllers;

import entity.User;
import service.IUserService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = null;
        try {
            if (req.getParameter("insertButton") != null) {
                path = "/insert.jsp";
                req.setAttribute("text",
                        userService.insert(req.getParameter("userName"),
                                Byte.valueOf(req.getParameter("userAge")),
                                req.getParameter("userEmail")));
            } else if (req.getParameter("deleteButton") != null) {
                path = "/selectDelete.jsp";
                req.setAttribute("text",
                        userService.delete(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("selectButton") != null) {
                path = "/selectDelete.jsp";
                req.setAttribute("text",
                        userService.getUser(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("updateButton") != null) {
                path = "/update.jsp";
                if (req.getParameter("userNameCheckbox") != null) {
                    req.setAttribute("textname", userService.update_name(Long.parseLong(req.getParameter("userId")),
                            req.getParameter("userName")));
                }
                if (req.getParameter("userAgeCheckbox") != null) {
                    req.setAttribute("textage", userService.update_age(Long.parseLong(req.getParameter("userId")),
                            Byte.valueOf(req.getParameter("userAge"))));
                }
                if (req.getParameter("userEmailCheckbox") != null) {
                    req.setAttribute("textemail", userService.update_email(Long.parseLong(req.getParameter("userId")),
                            req.getParameter("userEmail")));
                }
//            if(req.getParameter("userUpdate") !=null)
//
//
//                req.setAttribute("text",
//                        userService.update(Long.parseLong(req.getParameter("userId")),
//                                req.getParameter("userName"),
//                                Byte.valueOf(req.getParameter("userAge")),
//                                req.getParameter("userEmail")));
            } else if (req.getParameter("SelectArmyButton") != null) {
                path = "/army.jsp";
                req.setAttribute("text", userService.getUser(Long.parseLong(req.getParameter("userId"))));
            } else if (req.getParameter("home") != null) {
                path = "/index.jsp";
            }
        } catch (
                Exception e) {
            req.setAttribute("text", "Error");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

}
