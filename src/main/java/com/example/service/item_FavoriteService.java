package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberItemDAO;

@Service("item_FavoriteService")
public class item_FavoriteService {
	@Autowired
	MemberItemDAO memberItemDao;

}
