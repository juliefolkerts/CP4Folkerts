package pl.folkerts.productcatalog;

import
import org.junit.jupiter.api.Test;

import java.util.UUID; ...

public class HashMapProductRepositoryTest {
    @Test
    void itStoresAndLoadProduct() {
        //Arrange
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();
        //Act
        repository.save(product);
        Product loaded = repository.loadProductById(product.getId());
        //Assert
        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getName(), loaded.getDescription());
    }

    @Test
    void itLoadsAllProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        List<Product> products = repository.allProducts();

        assertEquals(1, products.size());
    }

    private ProductRepository thereIsProductRepository() {
        return new ArrayListProductStorage();
    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID(), "test", "desc");
    }

}
