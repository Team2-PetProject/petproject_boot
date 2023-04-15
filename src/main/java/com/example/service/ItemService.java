package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.SessionAttributeManager;
import com.example.dao.ItemDAO;
import com.example.dao.OptionDAO;
import com.example.dao.OptionTypeDAO;
import com.example.dto.ItemDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.ItemRetrieveDTO;
import com.example.dto.JoinItemDTO;
import com.example.dto.MemberItemDTO;
import com.example.dto.OptionDTO;
import com.example.dto.TypeDTO;

@Service
public class ItemService {

	@Autowired
	ItemDAO itemDao;
	@Autowired
	OptionTypeDAO optionTypeDao;
	@Autowired
	OptionDAO optionDao;

	@Transactional
	public JoinItemDTO itemList(String cat, Integer curPage) {
		Integer perPage = 12;
		Integer totalCount = itemDao.totalCount(cat);
		Integer totalPage = (int)Math.ceil(totalCount / perPage);
		if(totalPage==0) {totalPage=1;}
		Integer startIdx = ((curPage-1)*perPage);
		Integer endIdx = curPage*perPage;
		System.err.println(cat);
		System.err.println(startIdx);
		System.err.println(endIdx);
		ItemListDTO itemList = new ItemListDTO();
		itemList.setCat(cat);
		itemList.setStartIdx(startIdx);
		itemList.setEndIdx(endIdx);
		List<ItemDTO> itemLists = itemDao.itemList(itemList);
		JoinItemDTO joinItemDTO = new JoinItemDTO();
		joinItemDTO.setTotalPage(totalPage);
		joinItemDTO.setCurPage(curPage);
		joinItemDTO.setList(itemLists);
		return joinItemDTO;
	}


	@Transactional
	public ItemRetrieveDTO selectItemRetrieve(Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = new ItemRetrieveDTO();
		ItemDTO itemDTO = itemDao.selectItem(itCd);
		itemRetrieveDTO.setItemDTO(itemDTO);
		if (itemDTO.getTyCd() != null) {
			TypeDTO typeDto = optionTypeDao.selectType(itCd);
			List<String> option = optionDao.selectOption(typeDto.getTyCd());
			itemRetrieveDTO.setOptionName(typeDto.getTyNm());
			itemRetrieveDTO.setOption(option);
		}
		return itemRetrieveDTO;
	}


	public int favoriteDelete(MemberItemDTO memberItemDTO) {
		return itemDao.favoriteDelete(memberItemDTO);
	}


	public List<ItemDTO> favoriteList(List<Integer> itemCd) {
		MemberItemDTO memberItemDTO = new MemberItemDTO();
//		String mbId = SessionAttributeManager.getMemberId();
		String mbId = "1";
		memberItemDTO.setMbId(mbId);
		List<ItemDTO> favoriteLists = new ArrayList<ItemDTO>();
		for (Integer itCd : itemCd) {
			memberItemDTO.setItCd(itCd);
			List<ItemDTO> favoriteList = itemDao.favoriteList(memberItemDTO);
			favoriteLists.addAll(favoriteList);
		}
		return favoriteLists;
	}

	public Integer favoriteAdd(MemberItemDTO memberItemDTO) {
		return itemDao.favoriteAdd(memberItemDTO);
	}




}// end class
