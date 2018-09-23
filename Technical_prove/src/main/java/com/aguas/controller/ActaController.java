package com.aguas.controller;

import com.aguas.ejb.ActaFacadeLocal;
import com.aguas.model.Acta;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
public class ActaController implements Serializable {

    @EJB
    private ActaFacadeLocal actFacLoc;
    private Acta acta;
    private String acta_id;

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public String getActa_id() {
        return acta_id;
    }

    public void setActa_id(String acta_id) {
        this.acta_id = acta_id;
    }

    @PostConstruct
    public void init() {
        acta = new Acta();
    }

    public String create() {
        String url = "/index";
        try {
            actFacLoc.create(acta);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Notice", "The acta was created successfully!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Warning", "There was a problem creating the acta!"));
            url = "/Acta/create";
        }
        return url;
    }

    public String edit() {
        String url = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("url");
        try {
            Acta targetActa = actFacLoc.find(Integer.parseInt(acta_id));
            targetActa.setAttributes(acta);
            actFacLoc.edit(targetActa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Notice", "The acta was updated successfully!"));
        } catch (NumberFormatException e) {
            e.getMessage();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning", "There was a problem updating the acta!"));
        }
        return url;
    }

    public String remove() {
        Integer id = Integer.parseInt(FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("acta_id"));
        String url = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("url");

        try {
            Acta tempAct = actFacLoc.find(id);
            actFacLoc.remove(tempAct);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Notice", "The acta was deleted sucessfully!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning", "There was an error removing the acta!"));
        }
        
        return url;
    }

    public Acta show() {
        Acta tempAct = null;
        Integer id = Integer.parseInt(FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap().get("acta_id"));
        try {
            tempAct = actFacLoc.find(id);
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning", "There was an error showing the acta!"));
        }
        return tempAct;
    }
    
    public List<Acta> findAll() {
        List<Acta> act = null;
        try {
            act = actFacLoc.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Warning", "There was an error finding actas!"));
        }
        return act;
    }
    
}
