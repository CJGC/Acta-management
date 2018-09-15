package com.aguas.ejb;

import com.aguas.model.Acta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cj
 */
@Local
public interface ActaFacadeLocal {

    void create(Acta acta);

    void edit(Acta acta);

    void remove(Acta acta);

    Acta find(Object id);

    List<Acta> findAll();

    List<Acta> findRange(int[] range);

    int count();
    
}
