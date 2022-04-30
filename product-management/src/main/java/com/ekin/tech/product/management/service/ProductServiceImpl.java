package com.ekin.tech.product.management.service;

import com.ekin.tech.product.management.dto.ProductDTO;
import com.ekin.tech.product.management.exceptions.types.*;
import com.ekin.tech.product.management.model.ProductEntity;
import com.ekin.tech.product.management.repository.ProductRepository;
import com.ekin.tech.product.management.service.converter.BaseCommonConverter;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDTO> getAllProducts() throws GetException {
        try {
            return BaseCommonConverter.convert(productRepository.findAll(), new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new GetException(e);
        }
    }

    @Override
    public ProductDTO getProductById(Long id) throws GetException {
        try {
            ProductEntity productEntity = productRepository.getById(id);
            return BaseCommonConverter.convert(productEntity, ProductDTO.class);
        } catch (Exception e) {
            throw new GetException(e);
        }
    }

    @Override
    public List<ProductDTO> getProductByName(String productName) throws GetException {
        try {
            List<ProductEntity> productEntities = productRepository.getByProductName(productName);
            return BaseCommonConverter.convert(productEntities, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new GetException(e);
        }
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) throws SaveException, UniqueViolationException {
        try {
            ProductEntity productEntity = productRepository.save(BaseCommonConverter.convert(productDTO, ProductEntity.class));
            return BaseCommonConverter.convert(productEntity, ProductDTO.class);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueViolationException(e);
        } catch (Exception e) {
            throw new SaveException(e);
        }
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) throws UpdateException, UniqueViolationException {
        try {
            ProductEntity productEntity = productRepository.saveAndFlush(BaseCommonConverter.convert(productDTO, ProductEntity.class));
            return BaseCommonConverter.convert(productEntity, ProductDTO.class);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueViolationException(e);
        } catch (Exception e) {
            throw new UpdateException(e);
        }
    }

    @Override
    public void deleteProductById(Long id) throws DeleteException {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new DeleteException(e);
        }
    }


    @Override
    public void deleteAllProducts() throws DeleteException {
        try {
            productRepository.deleteAll();
        } catch (Exception e) {
            throw new DeleteException(e);
        }
    }

}
