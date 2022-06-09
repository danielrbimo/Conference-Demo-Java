package com.pluralsight.conferencedemo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity(name ="speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob //Large Object, binary data can get really large, and this annotation helps JPA deal with larger data.
    @Type(type="org.hibernate.type.BinaryType") //The second annotation is needed to help Hibernate deal with binary data.
    private byte[] speaker_photo;
    
    @ManyToMany(mappedBy = "speakers")
    //This annotation will prevent it from back serialization back to the sessions. 
    @JsonIgnore
    private List<Session> sessions;
    
    public Speaker() {
      // TODO document why this constructor is empty
    }


    /**
     * @return Integer return the speaker_id
     */
    public Long getSpeaker_id() {
        return speaker_id;
    }

    /**
     * @param speaker_id the speaker_id to set
     */
    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
    }

    /**
     * @return String return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return String return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return String return the speaker_bio
     */
    public String getSpeaker_bio() {
        return speaker_bio;
    }

    /**
     * @param speaker_bio the speaker_bio to set
     */
    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }


    /**
     * @return List<Session> return the sessions
     */
    public List<Session> getSessions() {
        return sessions;
    }

    /**
     * @param sessions the sessions to set
     */
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }


    /**
     * @return byte[] return the speaker_photo
     */
    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    /**
     * @param speaker_photo the speaker_photo to set
     */
    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

}
