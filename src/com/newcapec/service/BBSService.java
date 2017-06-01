package com.newcapec.service;

import java.util.List;

import com.newcapec.dao.UserDao;
import com.newcapec.entity.Post;
import com.newcapec.entity.Reply;
import com.newcapec.entity.User;

public class BBSService {
	
	public boolean login(User user){
		UserDao userDao = new UserDao();
		return userDao.login(user);
		
	}
	
	public boolean register(User user){
		UserDao userDao = new UserDao();
		return userDao.register(user);
		
	}
	
	public boolean post(Post post){
		UserDao userDao = new UserDao();
		return userDao.post(post);
		
	}
	public List<Reply> getRep(int id){
		UserDao userDao = new UserDao();
		return userDao.getRe(id);
	
	}
	public boolean reply(Reply reply){
		UserDao userDao = new UserDao();
		return userDao.reply(reply);
		
	}
	public List<Post> posts(){
		UserDao userDao = new UserDao();
		return userDao.posts();
	}
	public Post getFirst(int id){
		UserDao userDao = new UserDao();
		return userDao.getDetail(id);
		
	}
	public int getId(String name){
		UserDao userDao = new UserDao();
		return userDao.getId(name);
	}
	public User user(String name){
		UserDao userDao = new UserDao();
		return userDao.getUser(name);
		
	}
	public boolean delPost(int id){
		UserDao userDao = new UserDao();
		return userDao.delPost(id);
	}

}
