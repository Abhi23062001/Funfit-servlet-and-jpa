package com.astr.gymproject.servlets;

import com.astr.gymproject.service.BatchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBatch")
public class DeleteBatchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("batchId"));
        BatchService batchService = BatchService.getBatchService();
//        System.out.println(batchService.getBatchById(id));
        batchService.deleteBatch(batchService.getBatchById(id));
        resp.sendRedirect("/index.jsp");
    }
}
