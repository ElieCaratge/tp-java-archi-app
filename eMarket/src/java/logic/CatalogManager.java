package logic;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Product;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {
    private List<Product> products;
    private Integer newProductId;
    private String newProductName;
    private Double newProductPrice;

    public CatalogManager() {
    }

    @PostConstruct
    public void initCatalog() {
        products = new ArrayList<>();
        products.add(new Product() {
            {
                setId(1);
                setName("Produit 1");
                setPrice(10.0);
            }
        });
        products.add(new Product() {
            {
                setId(2);
                setName("Produit 2");
                setPrice(20.0);
            }
        });
        products.add(new Product() {
            {
                setId(3);
                setName("Produit 3");
                setPrice(30.0);
            }
        });
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getNewProductId() {
        return newProductId;
    }

    public void setNewProductId(Integer newProductId) {
        this.newProductId = newProductId;
    }

    public String getNewProductName() {
        return newProductName;
    }

    public void setNewProductName(String newProductName) {
        this.newProductName = newProductName;
    }

    public Double getNewProductPrice() {
        return newProductPrice;
    }

    public void setNewProductPrice(Double newProductPrice) {
        this.newProductPrice = newProductPrice;
    }

    public String createProduct() {
        Product newProduct = new Product();
        newProduct.setId(newProductId);
        newProduct.setName(newProductName);
        newProduct.setPrice(newProductPrice);
        products.add(newProduct);
        newProductId = null;
        newProductName = null;
        newProductPrice = null;
        return "tocatalog";
    }
}
