/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ornithology.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "species_nutritions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecieNutrition.findAll", query = "SELECT s FROM SpecieNutrition s"),
    @NamedQuery(name = "SpecieNutrition.findBySpeciesNutritionId", query = "SELECT s FROM SpecieNutrition s WHERE s.speciesNutritionId = :speciesNutritionId")})
public class SpecieNutrition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "species_nutrition_id")
    private Long speciesNutritionId;
    @JoinColumn(name = "nutrition_id", referencedColumnName = "nutrition_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Nutrition nutritionId;
    @JoinColumn(name = "species_id", referencedColumnName = "species_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Specie speciesId;

    public SpecieNutrition() {
    }

    public SpecieNutrition(Long speciesNutritionId) {
        this.speciesNutritionId = speciesNutritionId;
    }

    public Long getSpeciesNutritionId() {
        return speciesNutritionId;
    }

    public void setSpeciesNutritionId(Long speciesNutritionId) {
        this.speciesNutritionId = speciesNutritionId;
    }

    public Nutrition getNutritionId() {
        return nutritionId;
    }

    public void setNutritionId(Nutrition nutritionId) {
        this.nutritionId = nutritionId;
    }

    public Specie getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Specie speciesId) {
        this.speciesId = speciesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesNutritionId != null ? speciesNutritionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecieNutrition)) {
            return false;
        }
        SpecieNutrition other = (SpecieNutrition) object;
        if ((this.speciesNutritionId == null && other.speciesNutritionId != null) || (this.speciesNutritionId != null && !this.speciesNutritionId.equals(other.speciesNutritionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ornithology.models.SpecieNutrition[ speciesNutritionId=" + speciesNutritionId + " ]";
    }
    
}
