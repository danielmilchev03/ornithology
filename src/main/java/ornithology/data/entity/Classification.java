/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ornithology.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "classifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classification.findAll", query = "SELECT c FROM Classification c"),
    @NamedQuery(name = "Classification.findByClassificationId", query = "SELECT c FROM Classification c WHERE c.classificationId = :classificationId"),
    @NamedQuery(name = "Classification.findByClassificationName", query = "SELECT c FROM Classification c WHERE c.classificationName = :classificationName")})
public class Classification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "classification_id")
    private Integer classificationId;
    //@Size(max = 2147483647)
    @Column(name = "classification_name")
    private String classificationName;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classificationId")
    @JsonIgnore
    private List<BirdClass> birdClassList;

    public Classification() {
    }

    public Classification(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<BirdClass> getBirdClassList() {
        return birdClassList;
    }

    public void setBirdClassList(List<BirdClass> birdClassList) {
        this.birdClassList = birdClassList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classificationId != null ? classificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classification)) {
            return false;
        }
        Classification other = (Classification) object;
        if ((this.classificationId == null && other.classificationId != null) || (this.classificationId != null && !this.classificationId.equals(other.classificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "classificationId=" + classificationId +
                ", classificationName='" + classificationName + '\'' +
                ", userId=" + userId +
                ", birdClassList=" + birdClassList +
                '}';
    }
}