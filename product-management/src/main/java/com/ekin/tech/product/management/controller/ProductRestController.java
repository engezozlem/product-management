package com.ekin.tech.product.management.controller;

import com.ekin.tech.product.management.controller.constants.ProductRestControllerConstants;
import com.ekin.tech.product.management.dto.ProductDTO;
import com.ekin.tech.product.management.exceptions.types.*;
import com.ekin.tech.product.management.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO 6 : create other rest apis
 */
@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(path = ProductRestControllerConstants.GET_ALL_PRODUCTS_PATH)
    public List<ProductDTO> getAllProducts() throws GetException {
        return productService.getAllProducts();
    }

    @GetMapping(path = ProductRestControllerConstants.GET_PRODUCT_BY_ID_PATH)
    public ProductDTO getProductById(@PathVariable(ProductRestControllerConstants.PRODUCT_ID_PATH_VARIABLE) Long id) throws GetException {
        return productService.getProductById(id);
    }

    @GetMapping(path = ProductRestControllerConstants.GET_PRODUCT_BY_NAME_PATH)
    public List<ProductDTO> getProductByName(@PathVariable(ProductRestControllerConstants.PRODUCT_NAME_PATH_VARIABLE) String productName) throws GetException {
        return productService.getProductByName(productName);
    }

    @PostMapping(path = ProductRestControllerConstants.SAVE_PRODUCT_PATH)
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) throws SaveException, UniqueViolationException {
        return productService.saveProduct(productDTO);
    }

    @PutMapping(path = ProductRestControllerConstants.UPDATE_PRODUCT_PATH)
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) throws UpdateException, UniqueViolationException {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping(path = ProductRestControllerConstants.DELETE_PRODUCT_BY_ID_PATH)
    public void deleteProductById(@PathVariable(ProductRestControllerConstants.PRODUCT_ID_PATH_VARIABLE) Long id) throws DeleteException {
        productService.deleteProductById(id);
    }

    @DeleteMapping(path = ProductRestControllerConstants.DELETE_ALL_PRODUCTS)
    public void deleteAllProducts() throws DeleteException {
        productService.deleteAllProducts();
    }
}
