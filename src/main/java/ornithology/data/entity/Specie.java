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
@Table(name = "species")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specie.findAll", query = "SELECT s FROM Specie s"),
    @NamedQuery(name = "Specie.findBySpeciesId", query = "SELECT s FROM Specie s WHERE s.speciesId = :speciesId"),
    @NamedQuery(name = "Specie.findBySpeciesName", query = "SELECT s FROM Specie s WHERE s.speciesName = :speciesName"),
    @NamedQuery(name = "Specie.findBySpeciesCreateDate", query = "SELECT s FROM Specie s WHERE s.speciesCreateDate = :speciesCreateDate")})
public class Specie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "species_id")
    private Integer speciesId;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "species_name")
    private String speciesName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "species_create_date ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date speciesCreateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciesId")
    @JsonIgnore
    private List<SpecieNutrition> specieNutritionList;
    @JoinColumn(name = "genus_id", referencedColumnName = "genus_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Genus genusId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciesId")
    @JsonIgnore
    private List<BirdFound> birdFoundList;

    public Specie() {
    }

    public Specie(Integer speciesId) {
        this.speciesId = speciesId;
    }

    public Specie(Integer speciesId, String speciesName, Date speciesCreateDate) {
        this.speciesId = speciesId;
        this.speciesName = speciesName;
        this.speciesCreateDate = speciesCreateDate;
    }

    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Date getSpeciesCreateDate() {
        return speciesCreateDate;
    }

    public void setSpeciesCreateDate(Date speciesCreateDate) {
        this.speciesCreateDate = speciesCreateDate;
    }

    @XmlTransient
    public List<SpecieNutrition> getSpecieNutritionList() {
        return specieNutritionList;
    }

    public void setSpecieNutritionList(List<SpecieNutrition> specieNutritionList) {
        this.specieNutritionList = specieNutritionList;
    }

    public Genus getGenusId() {
        return genusId;
    }

    public void setGenusId(Genus genusId) {
        this.genusId = genusId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<BirdFound> getBirdFoundList() {
        return birdFoundList;
    }

    public void setBirdFoundList(List<BirdFound> birdFoundList) {
        this.birdFoundList = birdFoundList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesId != null ? speciesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specie)) {
            return false;
        }
        Specie other = (Specie) object;
        if ((this.speciesId == null && other.speciesId != null) || (this.speciesId != null && !this.speciesId.equals(other.speciesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ornithology.models.Specie[ speciesId=" + speciesId + " ]";
    }
    
}
