package logic;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.ejb.EJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import facade.ProductFacade;

@Named
@ApplicationScoped
public class CatalogManager implements Serializable {
    private List<Product> products;
    private String newProductName;
    private Double newProductPrice;

    @EJB
    private ProductFacade productFacade;

    public CatalogManager() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    @PostConstruct
    public void initCatalog() {
        products = productFacade.findAll();
    }

    public String addToCart() {
        Product entity = new Product(products.size() + 1, this.newProductName, this.newProductPrice);
        products.add(entity);
        productFacade.create(entity);
        return "tocatalog";
    }
}
