package com.newcapec.dao;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.newcapec.entity.Page;
import com.newcapec.entity.Post;
import com.newcapec.entity.Reply;
import com.newcapec.entity.User;
import com.newcapec.util.DBUtil;

public class UserDao {
	
	public static void main(String []args){
		UserDao userDao = new UserDao();
		User user = new User();
		System.out.println(userDao.getNums());
	
		
	}
	public User getUser(String name){
		Connection conn = null;
		PreparedStatement pstm = null;
		User user = new User();
		try{
			conn  = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select regtime,qq,phone,address from users where uname = ?");
			pstm.setString(1, name);
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next()){
				user.setName(name);
				user.setDate(ts.getString(1));
				user.setQq(ts.getInt(2));
				user.setPhone(ts.getInt(3));
				user.setAddress(ts.getString(4));
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return user;
	}
	
	public boolean register(User user){
		Connection conn =null;
		PreparedStatement pstm = null;
		boolean re =false;
		if(!hadReg(user)){
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("insert into users values(0,?,?,now(),?,?,?)");
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			pstm.setInt(3, user.getQq());
			pstm.setInt(4, user.getPhone());
			pstm.setString(5, user.getAddress());
			int result = pstm.executeUpdate();
			if(result==1){
				re = true;
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		}else{
			re = false;
		}
		return re;
	}
	public boolean hadReg(User user){
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean re = false;
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select * from users where uname =?");
			pstm .setString(1, user.getName());
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next())
				re =true;
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return re;
	}
	public boolean login(User user){
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean re = false;
		try{
			conn =DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select * from users where uname=? and upassword=?");
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getPassword());
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next()){
				re = true;
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return re;
	}
	
	public boolean post(Post post){
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean re = false;
		try{
			conn  = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("insert into post values(0,?,?,now(),?)");
			pstm.setString(1, post.getTitle());
			pstm.setString(2, post.getDetail());
			pstm.setInt(3, post.getUid());
			int result = pstm.executeUpdate();
			if(result ==1){
				re = true;
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return re;
	}
	
	public boolean hadPost(Post post){
		Connection conn =null;
		PreparedStatement pstm = null;
		boolean re = false;
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select * from post where title =?");
			pstm.setString(1, post.getTitle());
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next())
				re  = true ;
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return re;
	}
	
	public boolean reply(Reply reply){
		Connection conn = null;
		PreparedStatement pstm =null;
		boolean re = false;
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("insert into re values(0,?,?,?,now())");
			pstm.setInt(1, reply.getUid());
			pstm.setInt(2, reply.getPostid());
			pstm.setString(3, reply.getContent());
			int result = pstm.executeUpdate();
			if(result == 1)
				re = true;
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return re;
	}
	public int getId(String name){
		Connection conn = null;
		PreparedStatement pstm = null;
		int id = 0;
		try{
			conn  = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select id from users where uname = ?");
			pstm.setString(1, name);
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next()){
				id = ts.getInt(1);
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return id;
	}
	
	public List<Post> posts(){
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Post> posts = new ArrayList<Post>();
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select uid,title,detail,daate,id from post");
			ResultSet ts = (ResultSet) pstm.executeQuery();
			while(ts.next()){
				int uid = ts.getInt(1);
				String title = ts.getString(2);
				String detail = ts.getString(3);
				String date = ts.getString(4);
				int id = ts.getInt(5);
			    pstm = (PreparedStatement) conn.prepareStatement("select uname from users where id = ?");
			    pstm.setInt(1, uid);
				ResultSet ur= (ResultSet) pstm.executeQuery();
				String name = "";
				if(ur.next()){
					 name =  ur.getString(1);
				}
				Post p = new Post();
				p.setName(name);
				p.setTitle(title);
				p.setDetail(detail);
				p.setDate(date);
				p.setId(id);
				System.out.println(id);
				posts.add(p);
			}	
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return posts;
	}
	
	public Post getDetail(int id){
		Connection conn =null;
		PreparedStatement pstm =null;
		Post post = new Post();
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select title,detail,daate,uid from post where id =?");
			pstm.setInt(1, id);
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next()){
				String title = ts.getString(1);
				String detail = ts.getString(2);
				String date = ts.getString(3);
				int uid = ts.getInt(4);
				pstm = (PreparedStatement) conn.prepareStatement("select uname from users where id =?");
				pstm.setInt(1, uid);
				ResultSet un = (ResultSet) pstm.executeQuery();
				String uname ="";
				if(un.next()){
					uname = un.getString(1);
				}
				post.setId(id);
				post.setName(uname);
				post.setTitle(title);
				post.setDetail(detail);
				post.setDate(date);
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return post;
	}
	
	public List<Reply> getRe(int id){
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Reply> replys = new ArrayList<Reply>();
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select uid,content,rdate from re where postid=?");
			pstm.setInt(1, id);
			ResultSet ts = (ResultSet) pstm.executeQuery();
			while(ts.next()){
				int uid = ts.getInt(1);
				String content = ts.getString(2);
				String rdate = ts.getString(3);
				Reply reply=new Reply();
				reply.setContent(content);
				reply.setReDate(rdate);
				pstm=(PreparedStatement) conn.prepareStatement("select uname from users where id =?");
				pstm.setInt(1, uid);
				ResultSet nn  = (ResultSet) pstm.executeQuery();
				String rname = "";
				if(nn.next()){
					 rname = nn.getString(1);
				}
				reply.setRname(rname);
				replys.add(reply);
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return replys;
	}
	
	public boolean delPost(int id){
		Connection conn = null;
		PreparedStatement pstm =null;
		boolean result = false;
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("delete from post where id = ?");
			pstm.setInt(1, id);
			int re = pstm.executeUpdate();
			pstm.close();
			pstm = (PreparedStatement) conn.prepareStatement("delete from re where postid = ?");
			int re1 = pstm.executeUpdate();
			if(re==1&&re1==1){
				result = true;
			}
			
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return result;
	}
	public int getNum(){
		return (int)Math.random()*5;
	}
	
	public Page getPage(int pageSize,int pageNo){
		Page page = new Page();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		Connection conn = null;
		PreparedStatement pstm = null;
		List<Post> posts = new ArrayList<Post>();
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select uid,title,detail,daate,id from post limit ?,?");
			pstm.setInt(1, pageNo-1);
			pstm.setInt(2, pageSize);
			ResultSet ts = (ResultSet) pstm.executeQuery();
			while(ts.next()){
				int uid = ts.getInt(1);
				String title = ts.getString(2);
				String detail = ts.getString(3);
				String date = ts.getString(4);
				int id = ts.getInt(5);
			    pstm = (PreparedStatement) conn.prepareStatement("select uname from users where id = ?");
			    pstm.setInt(1, uid);
				ResultSet ur= (ResultSet) pstm.executeQuery();
				String name = "";
				if(ur.next()){
					 name =  ur.getString(1);
				}
				Post p = new Post();
				p.setName(name);
				p.setTitle(title);
				p.setDetail(detail);
				p.setDate(date);
				p.setId(id);
				System.out.println(id);
				posts.add(p);
			}	
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		int totalPage = getNums()%pageSize==0?getNums()/pageSize:getNums()/pageSize+1;
		System.out.println(totalPage);
		page.setTotalCount(getNums());
		page.setTotalPage(totalPage);
		page.posts=posts;
		return page;
	}
	
	public int getNums(){
		Connection conn = null;
		PreparedStatement pstm = null;
		int num=0;
		try{
			conn = DBUtil.conn();
			pstm = (PreparedStatement) conn.prepareStatement("select count(*) from post");
			ResultSet ts = (ResultSet) pstm.executeQuery();
			if(ts.next()){
				num = ts.getInt(1);
			}
		}catch(Exception e){
			
		}finally{
			DBUtil.close(pstm, conn);
		}
		return num;
	}
	
}
