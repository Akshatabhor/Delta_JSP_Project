package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.Emp;

public class SqlQueries {

	public static int insert(Emp ob)
	{
		Connection con=getconnection.connect1();
		String sql="insert into emp(id,name,city,mobile) values (?,?,?,?)";
		int status=0;
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, ob.getId());
			ps.setString(2, ob.getName());
			ps.setString(3,ob.getCity());
			ps.setString(4,ob.getMobile());
			
			status=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}

	public static List<Emp> datafetch()
	{
		List<Emp> al= new ArrayList<>();
		Connection con=getconnection.connect1();
		String sql="select * from emp";
		try
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{
				Emp ob=new Emp();
				
				ob.setId(rs.getInt("id"));
				ob.setName(rs.getString(2));
				ob.setCity(rs.getString(3));
				ob.setMobile(rs.getString(4));
				
				al.add(ob);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return al;
		
	}
	public static int Delete(int id)
	{
		Connection con=getconnection.connect1();
		String sql="delete from Emp where id=?";
		int status=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	public static Emp update(int id)
	{
		Connection con=getconnection.connect1();
		Emp ob=new Emp();
		String sql="select * from emp where id =?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setCity(rs.getString(3));
				ob.setMobile(rs.getString(4));

			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return ob;
		
	}
	public static int edit(Emp ob)
	{
		Connection con=getconnection.connect1();
		String sql="update emp set name=?,city=?,mobile=? where id=?";
		int status=0;
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ob.getName());
			ps.setString(2, ob.getCity());
			ps.setString(3, ob.getMobile());
			ps.setInt(4, ob.getId());
			
			status=ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}
	

}
