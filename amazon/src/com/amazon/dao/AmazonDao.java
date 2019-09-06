package com.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.amazon.entity.AmazonEmployee;

public class AmazonDao implements AmazonDAOInterafce
{

	public static AmazonDAOInterafce createDAOObject() {
		// TODO Auto-generated method stub
		return new AmazonDao();
	}

	@Override
	public int createProfileDAO(AmazonEmployee aa) 
	{
		int i =0;
	try
	{
		InitialContext ctx = new InitialContext();
		DataSource ds;
		ds = (DataSource)ctx.lookup( "java:/oracleDS");
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into amazon values(?,?)");
		ps.setString(1,aa.getEmail());
		ps.setString(2, aa.getPassword());
		i=ps.executeUpdate();
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
		return i;
	}

}
