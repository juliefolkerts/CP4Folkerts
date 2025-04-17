package pl.folkerts.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final UUID uuid;
    private final String name;
    private final String description;
    private BigDecimal price;

    public Product(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return uuid.toString();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void changePrice(BigDecimal price) {
        this.price = price;
    }

    public void setImage(String url) {
        this.url;
    }

    public String getImage() {
        return url;
    }
}
