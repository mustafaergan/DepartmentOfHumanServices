package tr.com.altay.Entity;

import javax.persistence.*;

/**
 * Created by mustafa.ergan on 25.02.2017.
 */
@Entity
public class Employee {
    private Long id;
    private String name;
    private Departmant departmanId;
    private Role roleId;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "DEPARTMAN_ID", referencedColumnName = "ID")
    public Departmant getDepartmanId() {
        return departmanId;
    }

    public void setDepartmanId(Departmant departmanId) {
        this.departmanId = departmanId;
    }

    @OneToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}
