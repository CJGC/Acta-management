package com.aguas.ejb;

import com.aguas.model.Acta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cj
 */
@Stateless
public class ActaFacade extends AbstractFacade<Acta> implements ActaFacadeLocal {

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActaFacade() {
        super(Acta.class);
    }
    
}
