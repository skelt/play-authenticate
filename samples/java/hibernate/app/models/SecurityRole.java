package models;

// Generated Jul 4, 2015 5:56:59 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import be.objectify.deadbolt.core.models.Role;

/**
 * SecurityRole generated by hbm2java
 */
@Entity
@Table(name = "security_role")
public class SecurityRole implements java.io.Serializable, Role {

	private Integer id;
	private String roleName;
	private Set<User> users = new HashSet<User>(0);

	public SecurityRole() {
	}

	public SecurityRole(String roleName, Set<User> users) {
		this.roleName = roleName;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_has_security_role", joinColumns = { @JoinColumn(name = "security_role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	@Transient
	public String getName() {
		// TODO Auto-generated method stub
		return this.getRoleName();
	}

}