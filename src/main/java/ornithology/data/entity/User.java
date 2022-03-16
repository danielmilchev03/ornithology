package ornithology.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.username = :username")})
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    //@Size(max = 2147483647)
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_is_account_non_expired")
    private boolean isAccountNonExpired;
    @Column(name = "user_is_account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "user_is_credentials_non_expired")
    private boolean isCredentialsNonExpired;
    @Column(name = "user_is_enabled")
    private boolean isEnabled;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> authorities;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Classification> classificationList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Specie> specieList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BirdClass> birdClassList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<BirdFound> birdFoundList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Family> familyList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Genus> genusList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Nutrition> nutritionList;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public List<Classification> getClassificationList() {
        return classificationList;
    }

    public void setClassificationList(List<Classification> classificationList) {
        this.classificationList = classificationList;
    }

    public List<Specie> getSpecieList() {
        return specieList;
    }

    public void setSpecieList(List<Specie> specieList) {
        this.specieList = specieList;
    }

    public List<BirdClass> getBirdClassList() {
        return birdClassList;
    }

    public void setBirdClassList(List<BirdClass> birdClassList) {
        this.birdClassList = birdClassList;
    }

    public List<BirdFound> getBirdFoundList() {
        return birdFoundList;
    }

    public void setBirdFoundList(List<BirdFound> birdFoundList) {
        this.birdFoundList = birdFoundList;
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    public List<Genus> getGenusList() {
        return genusList;
    }

    public void setGenusList(List<Genus> genusList) {
        this.genusList = genusList;
    }

    public List<Nutrition> getNutritionList() {
        return nutritionList;
    }

    public void setNutritionList(List<Nutrition> nutritionList) {
        this.nutritionList = nutritionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + username + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}