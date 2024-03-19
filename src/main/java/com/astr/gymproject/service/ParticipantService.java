package com.astr.gymproject.service;

import com.astr.gymproject.dao.ParticipantDAO;
import com.astr.gymproject.entity.Participant;

import java.util.List;

public class ParticipantService {
    private ParticipantDAO participantDAO;

    private static ParticipantService participantService;

    static {
        participantService = new ParticipantService();
    }

    public ParticipantService(){
        this.participantDAO = ParticipantDAO.createParticipantDao();
    }

    public static ParticipantService getParticipantService(){
        return participantService;
    }

    public List<Participant> getParticipantList(){return participantDAO.getParticipantList();}

    public void addNewParticipant(Participant participant){participantDAO.addNewParticipant(participant);}

    public void deleteParticipant(Participant participant){participantDAO.deleteParticipant(participant);}

    public Participant getParticipantById(int id){return participantDAO.getParticipantById(id);}

    public void updateParticipant(Participant participant){participantDAO.updateParticipant(participant);}
}
