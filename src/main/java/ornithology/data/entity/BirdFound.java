/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ornithology.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "birds_found")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BirdFound.findAll", query = "SELECT b FROM BirdFound b"),
    @NamedQuery(name = "BirdFound.findByBirdFoundId", query = "SELECT b FROM BirdFound b WHERE b.birdFoundId = :birdFoundId"),
    @NamedQuery(name = "BirdFound.findByBirdFoundDate", query = "SELECT b FROM BirdFound b WHERE b.birdFoundDate = :birdFoundDate"),
    @NamedQuery(name = "BirdFound.findByBirdFoundCoordinates", query = "SELECT b FROM BirdFound b WHERE b.birdFoundCoordinates = :birdFoundCoordinates"),
    @NamedQuery(name = "BirdFound.findByBirdFoundPicture", query = "SELECT b FROM BirdFound b WHERE b.birdFoundPicture = :birdFoundPicture")})
public class BirdFound implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bird_found_id")
    private Integer birdFoundId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bird_found_date")
    @Temporal(TemporalType.TIMESTAMP)
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birdFoundDate;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "bird_found_coordinates")
    private String birdFoundCoordinates;
    //@Size(max = 2147483647)
    @Column(name = "bird_found_picture")
    private String birdFoundPicture;
    @JoinColumn(name = "species_id", referencedColumnName = "species_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private Specie speciesId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("")
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "birdsFoundId")
    @JsonIgnore
    private List<CountryBirdFound> countryBirdFoundList;

    public BirdFound() {
    }

    public BirdFound(Integer birdFoundId) {
        this.birdFoundId = birdFoundId;
    }

    public BirdFound(Integer birdFoundId, Date birdFoundDate, String birdFoundCoordinates) {
        this.birdFoundId = birdFoundId;
        this.birdFoundDate = birdFoundDate;
        this.birdFoundCoordinates = birdFoundCoordinates;
    }

    public Integer getBirdFoundId() {
        return birdFoundId;
    }

    public void setBirdFoundId(Integer birdFoundId) {
        this.birdFoundId = birdFoundId;
    }

    public Date getBirdFoundDate() {
        return birdFoundDate;
    }

    public void setBirdFoundDate(Date birdFoundDate) {
        this.birdFoundDate = birdFoundDate;
    }

    public String getBirdFoundCoordinates() {
        return birdFoundCoordinates;
    }

    public void setBirdFoundCoordinates(String birdFoundCoordinates) {
        this.birdFoundCoordinates = birdFoundCoordinates;
    }

    public String getBirdFoundPicture() {
        return birdFoundPicture;
    }

    public void setBirdFoundPicture(String birdFoundPicture) {
        this.birdFoundPicture = birdFoundPicture;
    }

    public Specie getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Specie speciesId) {
        this.speciesId = speciesId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<CountryBirdFound> getCountryBirdFoundList() {
        return countryBirdFoundList;
    }

    public void setCountryBirdFoundList(List<CountryBirdFound> countryBirdFoundList) {
        this.countryBirdFoundList = countryBirdFoundList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (birdFoundId != null ? birdFoundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BirdFound)) {
            return false;
        }
        BirdFound other = (BirdFound) object;
        if ((this.birdFoundId == null && other.birdFoundId != null) || (this.birdFoundId != null && !this.birdFoundId.equals(other.birdFoundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BirdFound{" +
                "birdFoundId=" + birdFoundId +
                ", birdFoundDate=" + birdFoundDate +
                ", birdFoundCoordinates='" + birdFoundCoordinates + '\'' +
                ", birdFoundPicture='" + birdFoundPicture + '\'' +
                ", speciesId=" + speciesId +
                ", userId=" + userId +
                ", countryBirdFoundList=" + countryBirdFoundList +
                '}';
    }
}
