package com.aguas.controller;

import com.aguas.ejb.ActaFacadeLocal;
import com.aguas.model.Acta;
import java.io.Serializable;
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

    public Acta getActa() {
        return acta;
    }

    public void setActa(Acta acta) {
        this.acta = acta;
    }
    
    @PostConstruct
    public void init() {
        acta = new Acta();
    }
    
    public String create() {
        String url = null;
        try {
            actFacLoc.create(acta);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Notice","The acta was created successfully!"));
            url="/index";
        }
        catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Warning","There was a problem creating the acta!"));
            url="/Acta/create";
        }
        return url;
    }
}
