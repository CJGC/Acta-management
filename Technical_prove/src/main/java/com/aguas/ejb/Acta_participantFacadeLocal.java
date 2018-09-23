package com.aguas.ejb;

import com.aguas.model.Acta_participant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cj
 */
@Local
public interface Acta_participantFacadeLocal {

    void create(Acta_participant acta_participant);

    void edit(Acta_participant acta_participant);

    void remove(Acta_participant acta_participant);

    Acta_participant find(Object id);

    List<Acta_participant> findAll();

    List<Acta_participant> findRange(int[] range);

    int count();
    
}
