package blog;

import base.*;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Blog implements Serializable{
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
	
	public void setPosts(ArrayList<Post> posts) {
		// TODO Auto-generated method stub
		allPosts = posts;
	}
	
	/**
	 * 
	 * @return user
	 */
	public void getUser(){
		System.out.println(user);
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
			System.out.println("Post["+i+"]"+allPosts.get(i));
		}
	}
	
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		// Is the index legal?neither too high nor negative
		if (index >=0 || index < allPosts.size()){
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
	
	/**
	 * Write the Blog object to the external file
	 * @param someone
	 */
	public void save(String filepath){
		// TODO

		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(filepath);
		} catch (IOException e){
			System.out.println("Wait! There is something wrong. I cannot find the file...");
		}
		try {
			ObjectOutputStream os = new ObjectOutputStream(fs);
			//os.writeObject(this);
			for (int i = 0; i < allPosts.size(); i++){
				os.writeObject(allPosts.get(i));
			}
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Read the Blog object from file
	 * @param someone
	 */
	public void load(String filepath){
		// TODO
		try {
			FileInputStream fis = new FileInputStream(filepath);
			ObjectInputStream is = new ObjectInputStream(fis);
			Object o;
			ArrayList<Post> p = new ArrayList<Post>();
			try {
				while ((o = is.readObject()) != null){
					p.add((Post)o);
				}
			}
			catch (EOFException exc)
			{
				is.close();
			}
			setPosts(p);
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Wait! There is something wrong. I cannot find the file.");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}
		

}
