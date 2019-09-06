package com.amazon.service;

import com.amazon.dao.AmazonDAOInterafce;
import com.amazon.dao.AmazonDao;
import com.amazon.entity.AmazonEmployee;

public class AmazonService implements AmazonServiceInterface
{

	public static AmazonServiceInterface createServiceObject() 
	{
		// TODO Auto-generated method stub
		return new AmazonService();
	}

	@Override
	public int createProfile(AmazonEmployee aa) 
	{
       AmazonDAOInterafce ad = AmazonDao.createDAOObject();
       
		return ad.createProfileDAO(aa);
	}

}
