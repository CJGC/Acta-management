package com.aguas.controller;

import com.aguas.ejb.ActaFacadeLocal;
import com.aguas.model.Acta;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author cj
 */
@Named
@ViewScoped
public class ActaController implements Serializable {
    
    @EJB
    private ActaFacadeLocal actFacLoc;
    private Acta acta;
    private Acta targetActa;

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }

    public Acta getTargetActa() {
        return targetActa;
    }

    public void setTargetActa(Acta targetActa) {
        this.targetActa = targetActa;
    }
    
    @PostConstruct
    public void init() {
        acta = new Acta();
        targetActa = null;
    }
    
    public String create() {
        String url = "/index";
        try {
            actFacLoc.create(acta);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Notice","The acta was created successfully!"));
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning","There was a problem creating the acta!"));
            url="/Acta/create";
        }
        return url;
    }

    public void remove() {
        Acta tempAct;
        Integer acta_id=15;
        try {
            tempAct = actFacLoc.find(acta_id);
            actFacLoc.remove(tempAct);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Notice","The acta was deleted sucessfully!"));
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning","There was an error removing the acta!"));
        }
    }
    
    public List<Acta> findAll() {
        List<Acta> act = null;
        try {
            act = actFacLoc.findAll();
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning","There was an error finding actas!"));
        }
        return act;
    }
    
    public String find() {
        Map<String,String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        Integer acta_id = Integer.parseInt(params.get("acta_id"));
        
        try {
            targetActa = actFacLoc.find(acta_id);
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning","There was an error finding the acta!"));
        }
        return params.get("url");
    }
    
}
