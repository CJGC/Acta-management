package com.aguas.model;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "Compromises")
public class Compromises implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer compromises_id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant_id;
    
    @ManyToOne
    @JoinColumn(name = "acta_id")
    private Acta acta_id;

    public Integer getCompromises_id() {
        return compromises_id;
    }

    public void setCompromises_id(Integer compromises_id) {
        this.compromises_id = compromises_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Participant getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(Participant participant_id) {
        this.participant_id = participant_id;
    }

    public Acta getActa_id() {
        return acta_id;
    }

    public void setActa_id(Acta acta_id) {
        this.acta_id = acta_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.compromises_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compromises other = (Compromises) obj;
        if (!Objects.equals(this.compromises_id, other.compromises_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compromises{" + "compromises_id=" + compromises_id + '}';
    }
    
}
