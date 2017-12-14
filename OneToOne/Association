package Association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_credential")
public class UserCredential {
	@Id
	@Column(name="user_name")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="status")
	private int status;
	@OneToOne
	@JoinColumn(name="profile_id")
	private UserProfile profile;
	
	public UserCredential() {
		super();
	}
	public UserCredential(String username, String password, int status, UserProfile profile) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
		this.profile = profile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
	
	
}
