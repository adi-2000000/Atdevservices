package com.example.atdev.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.atdev.Entity.Item;

@Repository
public interface Repos extends JpaRepository<Item, Long> {

}
