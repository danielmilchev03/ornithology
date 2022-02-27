/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ornithology.data.entity;

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
@Table(name = "countries_birds_found")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryBirdFound.findAll", query = "SELECT c FROM CountryBirdFound c"),
    @NamedQuery(name = "CountryBirdFound.findByCountriesBirdsFoundId", query = "SELECT c FROM CountryBirdFound c WHERE c.countriesBirdsFoundId = :countriesBirdsFoundId")})
public class CountryBirdFound implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "countries_birds_found_id")
    private Long countriesBirdsFoundId;
    @JoinColumn(name = "birds_found_id", referencedColumnName = "bird_found_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private BirdFound birdsFoundId;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Country countryId;

    public CountryBirdFound() {
    }

    public CountryBirdFound(Long countriesBirdsFoundId) {
        this.countriesBirdsFoundId = countriesBirdsFoundId;
    }

    public Long getCountriesBirdsFoundId() {
        return countriesBirdsFoundId;
    }

    public void setCountriesBirdsFoundId(Long countriesBirdsFoundId) {
        this.countriesBirdsFoundId = countriesBirdsFoundId;
    }

    public BirdFound getBirdsFoundId() {
        return birdsFoundId;
    }

    public void setBirdsFoundId(BirdFound birdsFoundId) {
        this.birdsFoundId = birdsFoundId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countriesBirdsFoundId != null ? countriesBirdsFoundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryBirdFound)) {
            return false;
        }
        CountryBirdFound other = (CountryBirdFound) object;
        if ((this.countriesBirdsFoundId == null && other.countriesBirdsFoundId != null) || (this.countriesBirdsFoundId != null && !this.countriesBirdsFoundId.equals(other.countriesBirdsFoundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ornithology.models.CountryBirdFound[ countriesBirdsFoundId=" + countriesBirdsFoundId + " ]";
    }
    
}
