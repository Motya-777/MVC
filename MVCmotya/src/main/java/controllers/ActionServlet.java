package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/action")
public class ActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/index.jsp";
        try {
            if (req.getParameter("SelectDeleteButton") != null) {
                path = "/selectDelete.jsp";
            } else if (req.getParameter("UpdateButton") != null) {
                path = "/update.jsp";
            } else if (req.getParameter("InsertButton") != null) {
                path = "/insert.jsp";
            } else if (req.getParameter("ArmyButton") != null) {
                path = "/army.jsp";
            }
            req.getRequestDispatcher(path).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
