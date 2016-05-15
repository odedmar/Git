package com.carkyp.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserProfile {
	
	@Id
	private String id;
    @Indexed(unique=true)
	private String username;
	private String password;
	private String status;
	private Boolean enabled;
	private String token;
	
	
	@DBRef
	private List<Role> roles = new ArrayList<Role>();

    
	
	
	public final String getToken() {
		return token;
	}

	public final void setToken(String token) {
		this.token = token;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	public void removeRole(Role role) {
		//use iterator to avoid java.util.ConcurrentModificationException with foreach
		for (Iterator<Role> iter = this.roles.iterator(); iter.hasNext(); )
		{
		   if (iter.next().equals(role))
		      iter.remove();
		}
	}
	
	public String getRolesCSV() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<Role> iter = this.roles.iterator(); iter.hasNext(); )
		{
		   sb.append(iter.next().getId());
		   if (iter.hasNext()) {
			   sb.append(',');
		   }
		}
		return sb.toString();
	}	
	
	public boolean equals(Object obj) {
        if (!(obj instanceof UserProfile)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        UserProfile rhs = (UserProfile) obj;
        return new EqualsBuilder().append(id, rhs.id).isEquals();
    }

	public int hashCode() {
        return new HashCodeBuilder().append(id).append(username).toHashCode();
    }

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", username=" + username
				+ ", password=" + password + ", status=" + status
				+ ", enabled=" + enabled + ", token=" + token + ", roles="
				+ roles + "]";
	}
	
	
}
