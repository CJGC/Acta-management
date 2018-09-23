package com.aguas.ejb;

import com.aguas.model.Participant;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author cj
 */
@Stateless
public class ParticipantFacade extends AbstractFacade<Participant> implements ParticipantFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParticipantFacade() {
        super(Participant.class);
    }
    
}
