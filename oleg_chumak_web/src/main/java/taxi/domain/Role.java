package taxi.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by GFalcon on 16.07.15.
 */
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @Column(name = "DISPATCHER_PANEL")
    private boolean dispatcherPanelVisible;
    @Column(name = "ADMIN_PANEL")
    private boolean adminPanelVisible;

    @OneToMany(mappedBy = "role",
            cascade = {CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH})
    private Set<Operator> operators;

    public Role() {

    }

    public Role(String roleName) {
        this(roleName, false, true);
    }

    public Role(String roleName, boolean adminPanelVisible, boolean dispatcherPanelVisible) {
        operators = new HashSet<>();
        this.roleName = roleName;
        this.adminPanelVisible = adminPanelVisible;
        this.dispatcherPanelVisible = dispatcherPanelVisible;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isDispatcherPanelVisible() {
        return dispatcherPanelVisible;
    }

    public void setDispatcherPanelVisible(boolean dispatcherPanelVisible) {
        this.dispatcherPanelVisible = dispatcherPanelVisible;
    }

    public boolean isAdminPanelVisible() {
        return adminPanelVisible;
    }

    public void setAdminPanelVisible(boolean adminPanelVisible) {
        this.adminPanelVisible = adminPanelVisible;
    }

    public Set<Operator> getOperators() {
        return operators;
    }

    public void setOperators(Set<Operator> operators) {
        this.operators = operators;
    }

    public boolean addOperator(Operator operator) {
        return this.operators.add(operator);
    }

    public boolean removeOperator(Operator operator) {
        return this.operators.remove(operator);
    }

    @Override
    public String toString() {
        return  roleName + '|'
                + dispatcherPanelVisible + '|'
                + adminPanelVisible
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(isDispatcherPanelVisible(), role.isDispatcherPanelVisible()) &&
                Objects.equals(isAdminPanelVisible(), role.isAdminPanelVisible()) &&
                Objects.equals(getRoleName(), role.getRoleName()) &&
                Objects.equals(getOperators(), role.getOperators());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName(), isDispatcherPanelVisible(), isAdminPanelVisible(), getOperators());
    }
}
