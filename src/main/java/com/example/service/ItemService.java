package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ItemDAO;
import com.example.dao.OptionDAO;
import com.example.dao.OptionTypeDAO;
import com.example.dto.ItemDTO;
import com.example.dto.ItemListDTO;
import com.example.dto.ItemRetrieveDTO;
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
	
	public ItemListDTO itemList(String cat) {
		ItemListDTO itemListDTO = new ItemListDTO();
		System.out.println(cat);
		List<ItemDTO> list = itemDao.itemList(cat);
		itemListDTO.setList(list);
		return itemListDTO;
	}
	
	@Transactional
	public ItemRetrieveDTO selectItemRetrieve(Integer itCd) {
		ItemRetrieveDTO itemRetrieveDTO = new ItemRetrieveDTO();
		ItemDTO itemDTO = itemDao.selectItem(itCd);
		itemRetrieveDTO.setItemDTO(itemDTO);
		if("T".equals(itemDTO.getOptAdd())) {
			TypeDTO typeDto = optionTypeDao.selectType(itCd);
			List<String> option = optionDao.selectOption(typeDto.getTyCd());
			itemRetrieveDTO.setOptionName(typeDto.getTyNm());
			itemRetrieveDTO.setOption(option);
		}
		return itemRetrieveDTO;
	}

//	public int favoriteAdd(MemberItemDTO i_dto) {
//		return itemDao.favoriteAdd(i_dto);
//	}
//
//	public int favoriteDelete(String member_cd, int item_cd) {
//		return itemDao.favoriteDelete(member_cd,item_cd);
//	}




	
}//end class