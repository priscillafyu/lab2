package base;

public class User {
	int userID;
	String userName;
	String userEmail;
	
	public User(int id, String name, String email){
		userID = id;
		userName = name;
		userEmail = email;
	}

	@Override
	public String toString() {
		return "[userID=" + userID + ", userName=" + userName
				+ ", userEmail=" + userEmail + "]";
	}
	
}
