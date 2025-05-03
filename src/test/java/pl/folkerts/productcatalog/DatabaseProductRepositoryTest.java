package pl.folkerts.productcatalog;

import
import org.junit.jupiter.api.Test;

import java.util.UUID; ...
public class DatabaseProductRepositoryTest {

    @Test
    void itStoresAndLoadProduct() {
        Product product = therIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        Product loaded = repository.loadProductById(product.getId());

        assertEquals(product.getId(), loaded.getId());
        assertEquals(product.getName(), loaded.getDescription());

    }

    private ProductRepository thereIsProductRepository() {
        return new ArrayListProductStorage();
    }

    private Product therIsProduct() {
        return new Product(UUID.randomUUID(), "test", "desc");
    }

    @Test
    void itLoadsAllProducts() {
        Product product = thereIsProduct();
        ProductRepository repository = thereIsProductRepository();

        repository.save(product);
        List<Product> products = repository.allProducts();

        assertEquals(1, products.size());

    }
}
