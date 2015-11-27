package cn.zucc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.zucc.entity.Dvd;

public class DvdDao {
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Connection conn=null;
	
	//关闭数据库
	public void myClose(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(psmt!=null){
				psmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e2) {
			System.out.println("关闭失败");
		}
	}
	
	//加载驱动
	public DvdDao(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("无法找到驱动类");
			e.printStackTrace();
		}
	}
	//添加DVD
	public void addDvd(String  name){
		
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "insert into dvd(name)values(?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
			psmt.execute();
			System.out.println("添加成功");
			
			
		}catch(SQLException e){
			System.out.println("添加失败");
			e.printStackTrace();
		}
		finally{
			myClose();
			
		}	
	}
	//删除DVD
	public void deleteDvd(int i){
		
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "delete from dvd where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,i);
			
			psmt.execute();
			System.out.println("删除成功");
			
			
		}catch(SQLException e){
			System.out.println("删除失败");
			e.printStackTrace();
		}
		finally{
			
		myClose();
		}	
	}
	//找到数据库中所有的DVD
	public List<Dvd> findallDvd(){
		
		List<Dvd> list = new ArrayList<Dvd>();
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "select * from dvd";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()){
			Dvd dvd  = new Dvd();
			dvd.setName(rs.getString("name"));
			dvd.setId(rs.getInt("id"));
			dvd.setState(rs.getInt("state"));
			dvd.setBorrowdate(rs.getDate("borrowdate"));
			dvd.setReturndate(rs.getDate("returndate"));
			dvd.setBorrowcount(rs.getInt("borrowcount"));
			list.add(dvd);
			}
		}catch(SQLException e){
			System.out.println("查找失败");
			e.printStackTrace();
		}finally{
			myClose();
		}	
		return list;
	}
	
	//连接数据库并用于修改
	public void updateDvd(Dvd newdvd){
		
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String st = new String("update dvd set name=?,state=?,borrowdate=?,returndate=?,borrowcount=? where id=?");
			psmt = conn.prepareStatement(st);
			psmt.setString(1, newdvd.getName());
			psmt.setInt(2, newdvd.getState());
			java.sql.Date sqlborrow = newdvd.getBorrowdate()==null? null: new java.sql.Date(newdvd.getBorrowdate().getTime());
			psmt.setDate(3, sqlborrow);
			
			java.sql.Date sqlreturn = newdvd.getReturndate()==null? null:new java.sql.Date(newdvd.getReturndate().getTime());
			psmt.setDate(4, sqlreturn);
			psmt.setInt(5, newdvd.getBorrowcount());
			psmt.setInt(6, newdvd.getId());
			psmt.execute();
		
		}catch (Exception e) {
				System.out.println("修改失败");
			}
		finally{
				myClose();
			}
	}
	//通过DVD的名字来查找DVD
	public List<Dvd> findbyname(String name){
		
		List<Dvd> list = new ArrayList<Dvd>();
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "select * from dvd where name=?";
		
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			
			while(rs.next()){
				Dvd dvd  = new Dvd();
				dvd.setName(rs.getString("name"));
				dvd.setId(rs.getInt("id"));
				dvd.setState(rs.getInt("state"));
				dvd.setBorrowdate(rs.getDate("borrowdate"));
				dvd.setReturndate(rs.getDate("returndate"));
				dvd.setBorrowcount(rs.getInt("borrowcount"));
				list.add(dvd);
				}
		
		}catch(SQLException e){
			System.out.println("查找失败");
			e.printStackTrace();
		}finally{
			
			myClose();
		}	
		return list;
		}
	
	//通过DVD的ID来查找DVD
	public Dvd findDvd(int id){
		Dvd dvd = new Dvd();
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/minidvd", "root", "root");
			String sql = "select * from dvd where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()){
			dvd.setName(rs.getString("name"));
			dvd.setId(rs.getInt("id"));
			dvd.setState(rs.getInt("state"));
			dvd.setBorrowdate(rs.getDate("borrowdate"));
			dvd.setReturndate(rs.getDate("returndate"));
			
			}
		}catch(SQLException e){
			System.out.println("查找失败");
			e.printStackTrace();
		}finally{
			
			myClose();
		}
		return dvd;	
		
	}
	
}
