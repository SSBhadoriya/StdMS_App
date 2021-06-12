package com.stdms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stdms.model.StudentBin;




public class SMSDao {
	private Connection startConnection()
	{
		Connection con=null;
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		 }catch(ClassNotFoundException | SQLException e)
			 {
				 e.printStackTrace();
				 //System.out.println(e+" Error");
			 }
		return con;
	}
	
	
	//LOGIN DAO
	public boolean loginCheck(String uid,String pass,String user)
	{
		boolean isMatched=false;
	
				try(Connection con=startConnection()){
				PreparedStatement ps=con.prepareStatement("select uid,password,user from login2 where uid=? and password=? and user=? ");
			   ps.setString(1, uid);
			   ps.setString(2, pass);
			   ps.setString(3,user);
			   ResultSet rs=ps.executeQuery();
			   if(rs.next())
				   isMatched=true;
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
				
		return isMatched;
	}


//INSERT DAO
	public int insertRecord(StudentBin sb) {
		int x=0;
		try(Connection con=startConnection())
		{
			PreparedStatement ps=con.prepareStatement("insert into students(sname,fname,email,password,address) values(?,?,?,?,?)");
			ps.setString(1, sb.getSname());
			ps.setString(2, sb.getFname());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getPassword());
			ps.setString(5, sb.getAddress());
			x=ps.executeUpdate();
		}
		catch(SQLException se)
		{se.printStackTrace();}

		return x;
	}


	
//VIEW DAO	
	public List<StudentBin> getStudents()
	{
		List<StudentBin> list=new ArrayList<>();
		try(Connection con=startConnection()){
			PreparedStatement ps=con.prepareStatement("select roll_no,sname,fname,email,password,address from students");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				StudentBin sb=new StudentBin();
				sb.setId(rs.getString("roll_no"));
				sb.setSname(rs.getString("sname"));
				sb.setFname(rs.getString("fname"));
				sb.setEmail(rs.getString("email"));
				sb.setPassword(rs.getString("password"));
				sb.setAddress(rs.getString("address"));			
			 list.add(sb);
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return list;
	}
	


	//DELETE DAO
			public int deleteRecord(int roll_no) {
				int flag=0;
				try(Connection con=startConnection()){
					PreparedStatement ps=con.prepareStatement("delete from students where roll_no=?");
					ps.setInt(1, roll_no);
					flag=ps.executeUpdate();
					
				}
				catch(SQLException se)
				{se.printStackTrace();}
				
				return flag;
			}	
			
			
	//UPDATE DAO
//	Part I	
	public StudentBin updateRecord(String roll_no) {
			StudentBin sb=new StudentBin();
			try(Connection con=startConnection())
			{
				PreparedStatement ps=con.prepareStatement("select roll_no,sname,fname,email,password,address,address from students where roll_no=?");
				ps.setInt(1, Integer.parseInt(roll_no));
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					
					sb.setId(rs.getString("roll_no"));
					sb.setSname(rs.getString("sname"));
					sb.setFname(rs.getString("fname"));
					sb.setEmail(rs.getString("email"));
					sb.setPassword(rs.getString("password"));
					sb.setAddress(rs.getString("address"));
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			return sb;
		}


	
//Part II
	public int updateFormRecord(StudentBin sb) {
		int x=0;
		try(Connection con=startConnection())
		{
			PreparedStatement ps=con.prepareStatement("update students set sname=?,fname=?,email=?,password=?,address=? where roll_no=? ");
			ps.setString(1, sb.getSname());
			ps.setString(2, sb.getFname());
			ps.setString(3, sb.getEmail());
			ps.setString(4, sb.getPassword());
			ps.setString(5, sb.getAddress());
			ps.setString(6, sb.getId());
			x=ps.executeUpdate();
		}
		catch(SQLException se)
		{se.printStackTrace();}

		return x;
	}
	
}
