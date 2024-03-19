package com.astr.gymproject.servlets;

import com.astr.gymproject.entity.Participant;
import com.astr.gymproject.service.ParticipantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createNewParticipant")
public class CreateNewParticipantServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Participant participant = new Participant(
          Integer.parseInt(req.getParameter("id")),
          req.getParameter("name"),
          Integer.parseInt(req.getParameter("age")),
          Integer.parseInt(req.getParameter("batchId"))
        );
//        System.out.println(participant);
        ParticipantService.getParticipantService().addNewParticipant(participant);
        resp.sendRedirect("/index.jsp");
    }
}
