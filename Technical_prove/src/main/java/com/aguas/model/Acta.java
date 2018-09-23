package com.aguas.model;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cj
 */
@Entity
@Table(name = "Acta")
public class Acta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acta_id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "_date")
    private Date date;
    
    @Column(name = "place")
    private String place;
    
    @Column(name = "project")
    private String project;
    
    @Column(name = "topics")
    private String topics;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "nextMeeting")
    private Date nextMeeting;

    public Integer getActa_id() {
        return acta_id;
    }

    public void setActa_id(Integer acta_id) {
        this.acta_id = acta_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public Date getNextMeeting() {
        return nextMeeting;
    }

    public void setNextMeeting(Date nextMeeting) {
        this.nextMeeting = nextMeeting;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.acta_id);
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
        final Acta other = (Acta) obj;
        
        if (!Objects.equals(this.acta_id, other.acta_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Acta{" + "acta_id=" + acta_id + '}';
    }
    
    public void setAttributes(Acta acta) {        
        date = acta.getDate();
        nextMeeting = acta.getNextMeeting();
        place = acta.getPlace();
        project = acta.getProject();
        topics = acta.getTopics();
    }
}
