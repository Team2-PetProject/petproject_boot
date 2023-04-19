package com.example.Item.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Item.dao.ItemDAO;
import com.example.Item.dao.OptionDAO;
import com.example.Item.dao.OptionTypeDAO;
import com.example.Item.dto.ItemDTO;
import com.example.Item.dto.ItemListDTO;
import com.example.Item.dto.ItemRetrieveDTO;
import com.example.Item.dto.JoinItemDTO;
import com.example.Item.dto.TypeDTO;
import com.example.common.SessionAttributeManager;
import com.example.favorite.dto.MemberItemDTO;

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
		Integer perPage = 16;
		Integer totalCount = itemDao.totalCount(cat);
		Integer totalPage = (int)Math.ceil(totalCount / perPage);
		if(totalPage==0) {totalPage=1;}
		Integer startIdx = ((curPage-1)*perPage)+1;
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
		System.out.println(itemDTO);
		itemRetrieveDTO.setItemDTO(itemDTO);
		if(itemDTO.getOptCd()!=null) {
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
		String mbId = SessionAttributeManager.getMemberId();
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

	@Transactional
	public void deleteItem(Integer itCd) {
		Integer optCd = itemDao.selectOptCd(itCd);
		if(optCd !=null) {
			Integer tyCd = optionDao.selectTyCd(optCd);
			optionDao.deleteOption(tyCd);
			optionTypeDao.deleteType(tyCd);
		}
		itemDao.deleteItem(itCd);
	}




}// end class