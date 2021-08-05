package userdto;

import userentity.UserA;

public class UserDTO {

	private String username;
	private String email;
	private String password;
	
	public UserDTO(UserA user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}
	
	public UserDTO of(UserA user) {
         return new UserDTO(user);
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
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
	
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
}
