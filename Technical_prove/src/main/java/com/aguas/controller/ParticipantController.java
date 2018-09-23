package com.aguas.controller;

import com.aguas.ejb.ParticipantFacadeLocal;
import com.aguas.model.Participant;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cj
 */
@Named
@ViewScoped
@RequestScoped
public class ParticipantController implements Serializable {

    @EJB
    private ParticipantFacadeLocal partFacLoc;
    private Participant participant;
    private String participant_id;

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public String getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(String participant_id) {
        this.participant_id = participant_id;
    }

    @PostConstruct
    public void init() {
        participant = new Participant();
    }

    public String create() {
        String url = "/index";
        try {
            partFacLoc.create(participant);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Notice", "The participant was created successfully!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Warning", "There was a problem creating the participant!"));
            url = "/Acta/create";
        }
        return url;
    }

    public String edit() {
        String url = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("url");
        try {
            Participant targetParticipant = 
                    partFacLoc.find(Integer.parseInt(participant_id));
            targetParticipant.setAttributes(participant);
            partFacLoc.edit(targetParticipant);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Notice", "The participant was updated successfully!"));
        } catch (NumberFormatException e) {
            e.getMessage();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Warning", "There was a problem updating the participant!"));
        }
        return url;
    }

    public String remove() {
        Integer id = Integer.parseInt(FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("part_id"));
        String url = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("url");

        try {
            Participant tempAct = partFacLoc.find(id);
            partFacLoc.remove(tempAct);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Notice", "The participant was deleted sucessfully!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Warning", "There was an error removing the participant!"));
        }
        
        return url;
    }

    public Participant show() {
        Participant tempParticipant = null;
        Integer id = Integer.parseInt(FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("part_id"));
        try {
            tempParticipant = partFacLoc.find(id);
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning", "There was an error showing the participant!"));
        }
        return tempParticipant;
    }
    
    public List<Participant> findAll() {
        List<Participant> participants = null;
        try {
            participants = partFacLoc.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Warning", "There was an error finding participants!"));
        }
        return participants;
    }
    
}
