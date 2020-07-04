/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author skyba
 */
@Entity
@Table(name = "user_activity")
@NamedQueries({
    @NamedQuery(name = "UserActivity.findAll", query = "SELECT u FROM UserActivity u"),
    @NamedQuery(name = "UserActivity.findById", query = "SELECT u FROM UserActivity u WHERE u.id = :id"),
    @NamedQuery(name = "UserActivity.findByOccurrence", query = "SELECT u FROM UserActivity u WHERE u.occurrence = :occurrence")})
public class UserActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "occurrence")
    @Temporal(TemporalType.TIMESTAMP)
    private Date occurrence;
    @JoinColumn(name = "activity_id", referencedColumnName = "id")
    @ManyToOne
    private Activity activityId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public UserActivity() {
    }

    public UserActivity(Integer id) {
        this.id = id;
    }

    public UserActivity(Integer id, Date occurrence) {
        this.id = id;
        this.occurrence = occurrence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Date occurrence) {
        this.occurrence = occurrence;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserActivity)) {
            return false;
        }
        UserActivity other = (UserActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.UserActivity[ id=" + id + " ]";
    }
    
}
