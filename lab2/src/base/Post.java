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

	public static void main(String[] args){
		Date date = new Date();
		String content = "Hi!";
		Post a = new Post(date,content);
		String result = a.toString();
		System.out.println(result);
	}
}
