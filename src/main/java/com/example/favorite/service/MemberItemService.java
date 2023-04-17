package com.example.favorite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.favorite.dao.MemberItemDAO;

@Service
public class MemberItemService {
	@Autowired
	MemberItemDAO memberItemDao;

}
