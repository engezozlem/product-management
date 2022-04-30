package com.ekin.tech.product.management;

import com.ekin.tech.product.management.controller.ProductRestController;
import com.ekin.tech.product.management.dto.ProductDTO;
import com.ekin.tech.product.management.exceptions.constants.ExceptionType;
import com.ekin.tech.product.management.exceptions.types.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductManagementIntegrationTests {

    private static final String PRODUCT_NAME = "Product 1";
    private static final String PRODUCT_DESCRIPTION = "Product 1 Description";
    private static final String PRODUCT_CODE = "PRO-CODE1";

    @Autowired
    private ProductRestController productRestController;

    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        productDTO = new ProductDTO(PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_CODE);
    }

    @Test
    void saveProduct() {
        try {
            productDTO = productRestController.saveProduct(productDTO);
            assertNotNull(productDTO);
        } catch (SaveException | UniqueViolationException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void getAllProducts() {
        try {
            List<ProductDTO> allProducts = null;
            allProducts = productRestController.getAllProducts();
            assertNotNull(allProducts);
        } catch (GetException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void updateProduct() {
        try {
            final String oldProductName = productDTO.getProductName();
            productDTO.setProductName("Chanel 1.1");
            ProductDTO updateProduct = null;
            updateProduct = productRestController.updateProduct(productDTO);
            assertNotEquals(oldProductName, updateProduct.getProductName());
        } catch (UpdateException | UniqueViolationException e) {
            Assertions.fail(e);
        }

    }

    @Test
    void deleteProductById() {
        try {
            saveProduct();
            productRestController.deleteProductById(productDTO.getId());
        } catch (DeleteException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void deleteAllProducts() {
        try {
            assertNotNull(productRestController.getAllProducts());
            productRestController.deleteAllProducts();
            assertEquals(0, productRestController.getAllProducts().size());
        } catch (GetException | DeleteException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void expectedUniqueViolationExceptionWithSaveProduct() {
        ProductDTO sameProduct = new ProductDTO(PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_CODE);

        UniqueViolationException uniqueViolationException = assertThrows(
                UniqueViolationException.class,
                () -> productRestController.saveProduct(sameProduct)
        );
        assertEquals(ExceptionType.UNIQUE_VIOLATION_EXCEPTION, uniqueViolationException.getErrorInformation().getExceptionType());
    }

    @Test
    void expectedUniqueViolationExceptionWithUpdateProduct() {
        saveProduct();
        ProductDTO sameProduct = new ProductDTO(PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_CODE);

        UniqueViolationException uniqueViolationException = assertThrows(
                UniqueViolationException.class,
                () -> productRestController.updateProduct(sameProduct)
        );
        assertEquals(ExceptionType.UNIQUE_VIOLATION_EXCEPTION, uniqueViolationException.getErrorInformation().getExceptionType());
    }

    @Test
    void expectedNullPointerExceptionWithSaveProduct() {
        deleteAllProducts();
        ProductDTO emptyProduct = new ProductDTO();
        SaveException saveException = assertThrows(
                SaveException.class,
                () -> productRestController.saveProduct(emptyProduct)
        );
        assertEquals(SaveException.class, saveException.getClass());
    }

    @Test
    void expectedNullPointerExceptionWithUpdateProduct() throws GetException {
        List<ProductDTO> allProducts = productRestController.getAllProducts();
        Optional<ProductDTO> optionalProductDTO = allProducts.stream().findAny();
        if (optionalProductDTO.isPresent()) {
            ProductDTO dto = optionalProductDTO.get();
            dto.setProductCode(null);
            dto.setProductName(null);
            dto.setProductDescription(null);
            UpdateException updateException = assertThrows(
                    UpdateException.class,
                    () -> productRestController.updateProduct(dto)
            );
            assertEquals(UpdateException.class, updateException.getClass());
        }
    }
}

