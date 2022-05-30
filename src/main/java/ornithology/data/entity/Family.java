/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ornithology.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "families")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Family.findAll", query = "SELECT f FROM Family f"),
    @NamedQuery(name = "Family.findByFamilyId", query = "SELECT f FROM Family f WHERE f.familyId = :familyId"),
    @NamedQuery(name = "Family.findByFamilyName", query = "SELECT f FROM Family f WHERE f.familyName = :familyName"),
    @NamedQuery(name = "Family.findByFamilyParentId", query = "SELECT f FROM Family f WHERE f.familyParentId = :familyParentId"),
    @NamedQuery(name = "Family.findByFamilyCreateDate", query = "SELECT f FROM Family f WHERE f.familyCreateDate = :familyCreateDate")})
public class Family implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "family_id")
    private Integer familyId;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "family_name")
    private String familyName;
    @Column(name = "family_parent_id")
    private Integer familyParentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "family_create_date ")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date familyCreateDate;
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private BirdClass classId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyId")
    @JsonIgnore
    private List<Genus> genusList;

    public Family() {
    }

    public Family(Integer familyId) {
        this.familyId = familyId;
    }

    public Family(Integer familyId, String familyName, Date familyCreateDate) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.familyCreateDate = familyCreateDate;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getFamilyParentId() {
        return familyParentId;
    }

    public void setFamilyParentId(Integer familyParentId) {
        this.familyParentId = familyParentId;
    }

    public Date getFamilyCreateDate() {
        return familyCreateDate;
    }

    public void setFamilyCreateDate(Date familyCreateDate) {
        this.familyCreateDate = familyCreateDate;
    }

    public BirdClass getClassId() {
        return classId;
    }

    public void setClassId(BirdClass classId) {
        this.classId = classId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<Genus> getGenusList() {
        return genusList;
    }

    public void setGenusList(List<Genus> genusList) {
        this.genusList = genusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (familyId != null ? familyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Family)) {
            return false;
        }
        Family other = (Family) object;
        if ((this.familyId == null && other.familyId != null) || (this.familyId != null && !this.familyId.equals(other.familyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Family{" +
                "familyId=" + familyId +
                ", familyName='" + familyName + '}';
    }
}
