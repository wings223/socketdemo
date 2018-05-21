package com.example.socketdemo.repository;

import com.example.socketdemo.model.PriceTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceTagDao extends JpaRepository<PriceTag,Long>{
    @Query(value = "select store_id from price_tag where barcode=?1",nativeQuery = true)
    public String getStoreId(String barcode);
}
