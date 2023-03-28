package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.item_FavoriteDAO;

public class item_FavoriteService {
	@Autowired
	item_FavoriteDAO dao;
	@Autowired
	SqlSessionTemplate session;

}
