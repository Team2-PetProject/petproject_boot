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
import com.example.Item.dto.OptionCdNmDTO;
import com.example.Item.dto.TypeDTO;
import com.example.admin.dto.AdminItemDTO;
import com.example.admin.dto.ItemCdNmDTO;
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
		Integer totalPage = (int) Math.ceil((int) totalCount / (double) perPage);
		if (totalPage == 0) {
			totalPage = 1;
		}
		Integer startIdx = ((curPage - 1) * perPage) + 1;
		Integer endIdx = curPage * perPage;
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
		Integer itInfoCd = itemDao.selectitInfoCd(itCd);
		itemRetrieveDTO.setItemDTO(itemDTO);
		if (itemDTO.getOptCd() != null) {
			TypeDTO typeDto = optionTypeDao.selectType(itCd);
			List<OptionCdNmDTO> optionList = optionDao.selectOption(typeDto.getTyCd());
			itemRetrieveDTO.setOptionName(typeDto.getTyNm());
			itemRetrieveDTO.setOptionCdList(optionList);
		}
		itemRetrieveDTO.setItInfoCd(itInfoCd);
		return itemRetrieveDTO;
	}

	public Integer favoriteDelete(MemberItemDTO memberItemDTO) {
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
		if (optCd != null) {
			Integer tyCd = optionDao.selectTyCd(optCd);
			optionDao.deleteOption(tyCd);
			optionTypeDao.deleteType(tyCd);
		}
		itemDao.deleteItem(itCd);
	}

	public AdminItemDTO adminList(Integer curPage) {
		Integer perPage = 8;
		Integer totalCount = itemDao.totalItem();
		Integer totalPage = (int) Math.ceil((int) totalCount / (double) perPage);
		Integer startIdx = ((curPage - 1) * perPage);
		Integer endIdx = curPage * perPage;
		ItemListDTO itemList = new ItemListDTO();
		itemList.setStartIdx(startIdx);
		itemList.setEndIdx(endIdx);
		List<ItemCdNmDTO> itemLists = itemDao.adminList(itemList);
		AdminItemDTO adminItemDTO = new AdminItemDTO();
		adminItemDTO.setCurPage(curPage);
		adminItemDTO.setList(itemLists);
		adminItemDTO.setTotalPage(totalPage);
		return adminItemDTO;
	}

}// end class