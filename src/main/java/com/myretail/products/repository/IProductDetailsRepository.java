package com.myretail.products.repository;

import com.myretail.products.entity.ProductDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDetailsRepository extends CrudRepository<ProductDetailsEntity, String> {
}
