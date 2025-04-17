package pl.folkerts.productcatalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.list;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {

    @Test
    void itAllowsToListAllProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assertTrue(products.isEmpty());
    }

    @Test
    void itAllowsToCreateProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        catalog.createProduct("Lego set 8083", "lego set small");
        List<Product> products = catalog.allProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    void createProductAreUniquelyIdentifiable() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId1 = catalog.createProduct("Lego set 8083", "lego set small");
        String productId2 = catalog.createProduct("Lego set 6285", "lego set small");

        assertEquals(productId1, productId2);
    }

    @Test
    void itLoadsProductById() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId1 = catalog.createProduct("Lego set 6285", "lego set small");

        Product loaded = catalog.loadProductById(productId1);

        assertEquals(productId1, loaded.getId());
        assertEquals("Lego set 8083", loaded.getName());
        assertEquals("lego set small", loaded.getDescription());
    }

    @Test
    void allowsToApplyPrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String ProductId = catalog.createProduct("Lego set 8083", "lego set small");

        catalog.changePrice(ProductId, BigDecimal.valueOf(100.10));

        Product loaded = catalog.loadProductById(ProductId);
        assertEquals(BigDecimal.valueOf(100.10), loaded.getPrice());
    }

    @Test
    void denyToApplyPriceThatViolateMinimumRange() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct("https://picsum.photos/id/237/200/300", "lego set small");

        assertThrows(
                InvalidPriceException.class,
                () ->catalog.changePrice(productId, BigDecimal.valueOf(-10))
        );
    }

    @Test
    void allowsToApplyImage() {
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.createProduct( "Lego set 8083", "lego set small");
        catalog.changeImage(productId, "https://picsum.photos/id/237/200/300");

        Product loaded = catalog.loadProductById(productId);
        assertEquals("https://picsum.photos/id/237/200/300", loaded.getImage());

    }

    private ProductCatalog thereIsProductCatalog() { return new ProductCatalog();
    }
}
