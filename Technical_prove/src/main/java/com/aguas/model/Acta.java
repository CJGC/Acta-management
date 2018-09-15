package com.aguas.model;
import java.io.Serializable;
import java.util.Date;
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
    
    
}
