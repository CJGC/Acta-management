package com.aguas.ejb;

import com.aguas.model.Acta_participant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cj
 */
@Stateless
public class Acta_participantFacade extends AbstractFacade<Acta_participant> implements Acta_participantFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Acta_participantFacade() {
        super(Acta_participant.class);
    }
    
}
