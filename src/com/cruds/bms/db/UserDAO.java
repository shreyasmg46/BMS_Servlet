package com.cruds.bms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cruds.bms.entity.User;

public class UserDAO {
	
	public User authenticate(String userName, String pwd)
	{
		String sql = "Select role from users where userName = ? and password = ?";
		User user = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,userName);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			if (rs != null & rs.next())
			{
				user = new User(userName, rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean addUser(User u)
	{
		String sql = "insert into users(userName,password,phoneNo,email,role) values(?,?,?,?,?)";
		int row = 0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getPhoneNo());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getRole());

			row = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return row > 0;
	}


}
