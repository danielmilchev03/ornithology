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
@Table(name = "nutritions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nutrition.findAll", query = "SELECT n FROM Nutrition n"),
    @NamedQuery(name = "Nutrition.findByNutritionId", query = "SELECT n FROM Nutrition n WHERE n.nutritionId = :nutritionId"),
    @NamedQuery(name = "Nutrition.findByNutritionName", query = "SELECT n FROM Nutrition n WHERE n.nutritionName = :nutritionName"),
    @NamedQuery(name = "Nutrition.findBySpeciesId", query = "SELECT n FROM Nutrition n WHERE n.speciesId = :speciesId")})
public class Nutrition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nutrition_id")
    private Integer nutritionId;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "nutrition_name")
    private String nutritionName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "species_id")
    private int speciesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutritionId")
    @JsonIgnore
    private List<SpecieNutrition> specieNutritionList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private User userId;

    public Nutrition() {
    }

    public Nutrition(Integer nutritionId) {
        this.nutritionId = nutritionId;
    }

    public Nutrition(Integer nutritionId, String nutritionName, int speciesId) {
        this.nutritionId = nutritionId;
        this.nutritionName = nutritionName;
        this.speciesId = speciesId;
    }

    public Integer getNutritionId() {
        return nutritionId;
    }

    public void setNutritionId(Integer nutritionId) {
        this.nutritionId = nutritionId;
    }

    public String getNutritionName() {
        return nutritionName;
    }

    public void setNutritionName(String nutritionName) {
        this.nutritionName = nutritionName;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    @XmlTransient
    public List<SpecieNutrition> getSpecieNutritionList() {
        return specieNutritionList;
    }

    public void setSpecieNutritionList(List<SpecieNutrition> specieNutritionList) {
        this.specieNutritionList = specieNutritionList;
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
        hash += (nutritionId != null ? nutritionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutrition)) {
            return false;
        }
        Nutrition other = (Nutrition) object;
        if ((this.nutritionId == null && other.nutritionId != null) || (this.nutritionId != null && !this.nutritionId.equals(other.nutritionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "nutritionId=" + nutritionId +
                ", nutritionName='" + nutritionName + '\'' +
                ", speciesId=" + speciesId +
                ", specieNutritionList=" + specieNutritionList +
                ", userId=" + userId +
                '}';
    }
}
