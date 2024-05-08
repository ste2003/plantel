package com.acuaa.plantel.models;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//@Table(	name = "usr", 
//uniqueConstraints = { 
//	@UniqueConstraint(columnNames = "usr_codigo") 
//})
@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
public class User {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 120)
	  private String password;

	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "user_roles", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();  
	  
	  //@OneToMany(targetEntity = Time.class, cascade = CascadeType.ALL)
	  //@JoinColumn(name = "userId", referencedColumnName = "id")
	  @OneToMany (mappedBy="user")
	  private List<Time> times;
	  
	  public User() {
	  }

	  public User(String username, String email, String password) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	  }
	  
	  public User(String username, String email) {
		    this.username = username;
		    this.email = email;		   
		  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ",  roles="
				+ roles + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, roles, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(username, other.username);
	}
	  
}
