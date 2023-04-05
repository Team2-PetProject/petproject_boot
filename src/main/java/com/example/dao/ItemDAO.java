<<<<<<< HEAD
package com.example.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.ItemDTO;
import com.example.dto.MemberItemDTO;

@Mapper
public interface ItemDAO {

	public int favoriteAdd(MemberItemDTO i_dto);

	public int favoriteDelete(String member_cd, int item_cd);

	public void insertItem(ItemDTO itemDTO);
	
}
=======
package com.example.dao;


import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {

}//end class
>>>>>>> branch 'main' of https://github.com/Team2-PetProject/petproject_boot.git
