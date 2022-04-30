package com.ekin.tech.product.management.service;

import com.ekin.tech.product.management.dto.ProductDTO;
import com.ekin.tech.product.management.exceptions.types.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {

    List<ProductDTO> getAllProducts() throws GetException;

    ProductDTO getProductById(Long id) throws GetException;

    List<ProductDTO> getProductByName(String productName) throws GetException;

// TODO 1:    List<ProductEntity> getProducts(ProductQueryModel productQueryModel);

    ProductDTO saveProduct(ProductDTO productDTO) throws SaveException, UniqueViolationException;

    ProductDTO updateProduct(ProductDTO productDTO) throws UpdateException, UniqueViolationException;

    void deleteProductById(Long id) throws DeleteException;

    void deleteAllProducts() throws DeleteException;

}
