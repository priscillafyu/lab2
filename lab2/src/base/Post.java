package base;

import java.util.Date;

public class Post {
	private Date date;
	private String content;

	/**
	 * Constructor
	 */
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	
	/**
	 * get the content
	 * @return the content of the blog
	 */
	public String getContent(){
		return content;
	}
	
	/**
	 * get the date
	 * @return the date of the blog
	 */
	public Date getDate(){
		return date;
	}
	
	/**
	 * set the content
	 * @param content
	 */
	public void setContent(String content){
		this.content = content;
	}

	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString() {
		String result = date.toString() + "\n" + content.toString();
		return result;
	}
	
	@Override
	/**
	 * uniquely identify different objects
	 * @return unique hashCode for identical object
	 */
	public int hashCode() {
		int hashCode = 0;
		int factor = 37; // prime
		int temp = 0;
		if (content != null)
			temp = content.hashCode();
		hashCode = factor * hashCode + temp;
		if (date != null)
			temp = date.hashCode();
		hashCode = factor * hashCode + temp;
		return hashCode;
	}

	@Override
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 */
	public boolean equals(Object o) {
		boolean ans = true;
		// equal to itself
		if (this == o)
			ans = false;
		// if it is null
		if (o == null)
			ans = false;
		
		if (o.getClass().equals(this.getClass()) != true)
			ans = false;
		// transfer object o to Post
		Post other = (Post) o;
		
		// post A equal to post B
		if (content == null) {
			if (other.content != null)
				ans = false;
		} else if (content.equals(other.content) != true)
			ans = false;
		if (date == null) {
			if (other.date != null)
				ans = false;
		} else if (date.equals(other.date) != true)
			ans = false;
		return ans;
	}
	
	/**
	 * check whether this Post contains some keywords
	 * @param ketword
	 * @return
	 */
	public boolean contains(String keyword){
		if (content.contains(keyword))
			return true;
		else return false;
	}

	/*public static void main(String[] args){
		Date date = new Date();
		String content = "Hi!";
		Post a = new Post(date,content);
		String result = a.toString();
		System.out.println(result);
	}*/
	/**
	 * 1. Return 1 if this user’s date is greater than p’s date
	 * 2. Return -1 if this user’s date is less than p’s date
	 * 3. Return 0 if this user’s date equals to u’p date
	 * Option 1: (hint) date can be compared using before() and after() methods of Date
	 * Option 2: (Recommended and much easier) Since Date already implements compareTo(),
	 * You can directly call it as your return value here
	 * @return
	 */
	@Override
	public int compareTo(Post p) {
		// TODO
		if (date.compareTo(p.date) > 0)
			return 1;
		else if (date.compareTo(p.date) < 0)
			return -1;
		else return 0;
	}
}
