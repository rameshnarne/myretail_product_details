package com.myretail.products.repository;

import com.myretail.products.entity.ProductDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDetailsRepository extends JpaRepository<ProductDetailsEntity, String> {
}
