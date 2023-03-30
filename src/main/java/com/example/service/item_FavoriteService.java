package com.example.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.item_FavoriteDAO;
import com.example.dto.ItemFavoriteDTO;

@Service("item_FavoriteService")
public class item_FavoriteService {
	@Autowired
	item_FavoriteDAO dao;
	@Autowired
	SqlSessionTemplate session;
	
	public int favoriteAdd(ItemFavoriteDTO i_dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
