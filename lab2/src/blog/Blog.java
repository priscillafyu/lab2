package blog;

import base.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Blog {
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * Constructor
	 * @param user
	 */
	public Blog(User user){
		this.user = user;
		allPosts = new ArrayList<Post>();
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user){
		this.user = user;
	}
	
	/**
	 * 
	 * @return user
	 */
	public void getUser(){
		System.out.println(user);
	}
	
	public void setPosts(ArrayList<Post> posts) {
		// TODO Auto-generated method stub
		allPosts = posts;
	}
	
	/**
	 * create a new post in your blog
	 * @param post
	 */
	public void post(Post p){
		// add Post p to your blog

		boolean success = allPosts.add(p);
		// print a message if success
		if (success){
			System.out.println("A new Post:");
			System.out.println(p);
		}
	}
	
	/**
	 * list all posts in the blog
	 */
	public void list(){
		System.out.println("Current posts:");
		for (int i = 0; i < allPosts.size(); i++){
			System.out.println("["+i+"]"+allPosts.get(i));
		}
	}
	
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		// Is the index legal?neither too high nor negative
		if if (index < allPosts.size() && index >=0){){
		// if it is legal, delete the corresponding post
			allPosts.remove(index);
		}
		// otherwise print a fault message
		else System.out.println("Illegal deletion.");
	}


	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString() {
		return "Blog [user=" + user + ", allPosts=" + allPosts + "]";
	}
	
	@Override
	/**
	 * @return
	 */
	public int hashCode() {
		int hashCode = 0;
		int factor = 43;  // prime
		int temp = 0;
		if(allPosts != null){
			for (int i = 0; i < allPosts.size(); i++){
				temp = temp + allPosts.get(i).hashCode();
			}
		}
		hashCode = factor * hashCode + temp;
		
		if (user != null)
			temp = user.hashCode();
		hashCode = factor * hashCode + temp;
		
		return hashCode;
	}

	@Override
	/**
	 * 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	/**
	 * Search posts created in month and mention someone
	 * @param month
	 * @param someone
	 */
	public void search(int month, String someone){
		
		Calendar cal = Calendar.getInstance();
		
		// search from all posts
		for (Post p : allPosts){
			// get the current post's month
			// ( the Calendar.Month starts with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH);
			
			// TODO
			if (postMonth+1 == month){
				if (p.contains(someone))
					System.out.println(p.toString());
			}
		}
	}

}
