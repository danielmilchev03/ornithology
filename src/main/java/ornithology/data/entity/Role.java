package ornithology.data.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "Role.findByRoleId", query = "SELECT r FROM Role r WHERE r.roleId = :roleId"),
        @NamedQuery(name = "Role.findByRoleAuthority", query = "SELECT r FROM Role r WHERE r.roleAuthority = :roleAuthority")})
public class Role {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    //@Size(min = 1, max = 2147483647)
    @Column(name = "role_authority")
    private String roleAuthority;

    public Role() {
    }

    public Role(Integer roleId, String roleAuthority) {
        this.roleId = roleId;
        this.roleAuthority = roleAuthority;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleAuthority() {
        return roleAuthority;
    }

    public void setRoleAuthority(String roleAuthority) {
        this.roleAuthority = roleAuthority;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleAuthority='" + roleAuthority + '\'' +
                '}';
    }
}
