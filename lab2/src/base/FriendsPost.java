package base;

import java.util.Date;

public class FriendsPost extends Post {
	private User friend;

	public FriendsPost(Date date, String content, User user) {
		super(date, content);

		friend = user;
	}

	@Override
	public String toString() {
		String result = "User " + friend.toString();
		result = result + "\n" + super.toString();
		return result;
	}

}
