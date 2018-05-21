package com.example.socketdemo.repository;

import com.example.socketdemo.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuDao extends JpaRepository<Sku,String> {
    List<Sku> findByStoreId(String storeId);
}
