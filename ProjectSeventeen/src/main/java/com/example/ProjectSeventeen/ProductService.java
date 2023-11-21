package com.example.ProjectSeventeen;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductRepository rep;
	
	public List<Fruit>listAll(){
		return rep.findAll();
	}
	
	public void save(Fruit fruit) {
		rep.save(fruit);
	}
	
	public Fruit get(long id) {
		return rep.findById(id).get();
	}
	
	public void delete(long id) {
		rep.deleteById(id);
	}
}
