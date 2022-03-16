package ornithology.data.entity;

        import com.sun.istack.NotNull;
        import org.springframework.security.core.GrantedAuthority;

        import java.io.Serializable;
        import java.util.Set;
        import javax.persistence.*;
        import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
        @NamedQuery(name = "Role.findByRoleAuthority", query = "SELECT r FROM Role r WHERE r.authority = :authority")})
public class Role implements Serializable, GrantedAuthority {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private Long roleId;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "role_authority")
    private String authority;
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Role() {
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(Long roleId, String authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", authority='" + authority + '\'' +
                '}';
    }
}