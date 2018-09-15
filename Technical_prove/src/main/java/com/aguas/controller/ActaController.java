package com.aguas.controller;

import com.aguas.ejb.ActaFacadeLocal;
import com.aguas.model.Acta;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
    
    public void create() {
        try {
            actFacLoc.create(acta);
        }
        catch(Exception e) {
            e.getMessage();
        }
    }
}
