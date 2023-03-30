package com.example.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ItemDAO;

@Service("itemService")
public class ItemService {
	@Autowired
	ItemDAO dao;
	@Autowired
	SqlSessionTemplate session;

	
}//end class

