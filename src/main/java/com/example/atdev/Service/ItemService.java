package com.example.atdev.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atdev.Entity.Item;
import com.example.atdev.Repo.Repos;

@Service
public class ItemService {
	
	
	@Autowired
	private Repos repos;
	
	public List<Item> findAll() {
        return repos.findAll();
    }
	 public Item findById(Long id) {
	        return repos.findById(id).orElse(null);
	    }
	 
	 public Item save(Item item) {
	        return repos.save(item);
	        
	    }
	 
	 public void deleteById(Long id) {
	        repos.deleteById(id);
	    }
}
