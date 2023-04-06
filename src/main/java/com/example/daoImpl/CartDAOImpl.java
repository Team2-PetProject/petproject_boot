package com.example.daoImpl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dto.CartDTO;

@Repository
public class CartDAOImpl {
	@Autowired
	SqlSessionTemplate session;
	
	public int cartAdd(CartDTO cart) {
		return session.insert("CartMapper.cartAdd",cart);
	}

	public int cartDelete(int cart_cd) {
		return session.delete("CartMapper.cartDelete",cart_cd);
	}

	public int checkDelete(List<Integer> list) {
		return session.delete("CartMapper.checkDelete",list);
	}

	public int specUpdate(HashMap<String, Integer> map) {
		return session.update("cartMapper.specUpdate", map);
	}
	
	public int amountUpdate(HashMap<String, Integer> map) {
		return session.update("CartMapper.amountUpdate", map);
	}


	


}//end class
