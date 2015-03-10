package base;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post>{
	
	@Override
	/**
	 *  compares p1 and p2 based on our customized sorting logic
	 *  sort posts by content length
	 * 1. Return 1 if p1 is greater than p2 (in terms of the length of post content)
	 * 2. Return -1 if p1 is less than p2
	 * 3. Return 0 if p1 equals to p2
	 */
	public int compare(Post p1, Post p2){
		//TODO write your code here
		if (p1.getContent().length() > p2.getContent().length())
			return 1;
		else if (p1.getContent().length() < p2.getContent().length())
			return -1;
		else return 0;
	}
}
