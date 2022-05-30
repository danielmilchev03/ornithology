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
@Table(name = "genuses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genus.findAll", query = "SELECT g FROM Genus g"),
    @NamedQuery(name = "Genus.findByGenusId", query = "SELECT g FROM Genus g WHERE g.genusId = :genusId"),
    @NamedQuery(name = "Genus.findByGenusName", query = "SELECT g FROM Genus g WHERE g.genusName = :genusName"),
    @NamedQuery(name = "Genus.findByGenusCreateDate", query = "SELECT g FROM Genus g WHERE g.genusCreateDate = :genusCreateDate")})
public class Genus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "genus_id")
    private Integer genusId;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "genus_name")
    private String genusName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genus_create_date ")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date genusCreateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genusId")
    @JsonIgnore
    private List<Specie> specieList;
    @JoinColumn(name = "family_id", referencedColumnName = "family_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Family familyId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private User userId;

    public Genus() {
    }

    public Genus(Integer genusId) {
        this.genusId = genusId;
    }

    public Genus(Integer genusId, String genusName, Date genusCreateDate) {
        this.genusId = genusId;
        this.genusName = genusName;
        this.genusCreateDate = genusCreateDate;
    }

    public Integer getGenusId() {
        return genusId;
    }

    public void setGenusId(Integer genusId) {
        this.genusId = genusId;
    }

    public String getGenusName() {
        return genusName;
    }

    public void setGenusName(String genusName) {
        this.genusName = genusName;
    }

    public Date getGenusCreateDate() {
        return genusCreateDate;
    }

    public void setGenusCreateDate(Date genusCreateDate) {
        this.genusCreateDate = genusCreateDate;
    }

    @XmlTransient
    public List<Specie> getSpecieList() {
        return specieList;
    }

    public void setSpecieList(List<Specie> specieList) {
        this.specieList = specieList;
    }

    public Family getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Family familyId) {
        this.familyId = familyId;
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
        hash += (genusId != null ? genusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genus)) {
            return false;
        }
        Genus other = (Genus) object;
        if ((this.genusId == null && other.genusId != null) || (this.genusId != null && !this.genusId.equals(other.genusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Genus{" +
                "genusId=" + genusId +
                ", genusName='" + genusName + '\'' +
                ", genusCreateDate=" + genusCreateDate +
                ", specieList=" + specieList +
                ", familyId=" + familyId +
                ", userId=" + userId +
                '}';
    }
}
