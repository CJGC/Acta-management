package com.aguas.ejb;

import com.aguas.model.Participant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cj
 */
@Local
public interface ParticipantFacadeLocal {

    void create(Participant participant);

    void edit(Participant participant);

    void remove(Participant participant);

    Participant find(Object id);

    List<Participant> findAll();

    List<Participant> findRange(int[] range);

    int count();
    
}
