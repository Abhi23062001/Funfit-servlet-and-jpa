package com.astr.gymproject.servlets;

import com.astr.gymproject.entity.Batch;
import com.astr.gymproject.service.BatchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createNewBatch")
public class CreateNewBatchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Batch batch = new Batch(
                Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("startDate"),
                req.getParameter("endDate")
        );
//        System.out.println(batch);
        BatchService.getBatchService().addNewBatch(batch);
        resp.sendRedirect("/index.jsp");

    }
}
