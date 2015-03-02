package test;

import java.io.*;
import java.util.Date;

import base.*;
import blog.*;

public class TestBlog {
	
	/**
	 * Get user's input
	 * @return String
	 */
	public String getInput() {
		String line ="";
		System.out.print("Enter the prompt:");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}

	public static void main(String[] args) {
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021", "COMP3021@stu.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			// String prompt has already stores the input, now deal with it
			
			if(prompt.startsWith("list")){
				myblog.list();
			}
			else if(prompt.startsWith("post")){
				// TODO How to get content from the prompt?
				String input = prompt;
				String content = input.substring(5, input.length());
				Date date = new Date();
				Post post = new Post(date, content);
				myblog.post(post);
			}
			else if(prompt.startsWith("delete")){
				// Delete the post at the index parameter
				// TODO How to get the index from the prompt?
				String temp = prompt.substring(7, prompt.length());
				int index = Integer.parseInt(temp);
				
				myblog.delete(index);
			}
		}

	}

}
