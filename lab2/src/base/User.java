package base;

public class User implements Comparable<User>{
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
	
	/**
	 * 1. Return 1 if this user・s ID is greater than u・s ID
	 * 2. Return -1 if this user・s ID is less than u・s ID
	 * 3. Return 0 if this user・s ID equals to u・s ID
	 * @return
	 */
	@Override
	public int compareTo(User u) {
		// TODO
		if (userID > u.userID)
			return 1;
		else if (userID < u.userID)
			return -1;
		else return 0;
	}
}
