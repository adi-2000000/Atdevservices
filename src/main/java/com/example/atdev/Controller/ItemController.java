package com.example.atdev.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atdev.Entity.Item;
import com.example.atdev.Service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    
	
	
	@Autowired
	
	private ItemService itemService;
	
	
	 @GetMapping
	    public List<Item> getAllItems() {
	        return itemService.findAll();
	    }
	 
	   @GetMapping("/{id}")
	    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
	        Item item = itemService.findById(id);
	        if (item != null) {
	            return ResponseEntity.ok(item);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   
	   @PostMapping
	    public Item createItem(@RequestBody Item item) {
	        return itemService.save(item);
	    }
	   
	   
	   @PutMapping("/{id}")
	    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
	        Item item = itemService.findById(id);
	        if (item != null) {
	            item.setName(itemDetails.getName());
	            item.setDescription(itemDetails.getDescription());
	            return ResponseEntity.ok(itemService.save(item));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	   
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
	        itemService.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
