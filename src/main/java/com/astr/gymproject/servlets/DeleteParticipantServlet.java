package com.astr.gymproject.servlets;

import com.astr.gymproject.entity.Participant;
import com.astr.gymproject.service.ParticipantService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteParticipant")
public class DeleteParticipantServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("participantId"));
        ParticipantService participantService = ParticipantService.getParticipantService();
        Participant participant = participantService.getParticipantById(id);
        participantService.deleteParticipant(participant);
        resp.sendRedirect("/index.jsp");
    }
}
