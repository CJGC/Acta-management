package com.aguas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cj
 */
@Entity
@Table(name = "Acta_participant")
public class Acta_participant implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "acta_id", nullable = false)
    private Acta acta_id;
    
    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = true)
    private Participant participant_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Acta getActa_id() {
        return acta_id;
    }

    public void setActa_id(Acta acta_id) {
        this.acta_id = acta_id;
    }

    public Participant getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Participant participant_id) {
        this.participant_id = participant_id;
    }
    
}
