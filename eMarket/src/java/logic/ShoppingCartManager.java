package logic;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.ShoppingCartItem;

@Named
@SessionScoped
public class ShoppingCartManager implements Serializable {
    private List<ShoppingCartItem> items;
    private Product prodToAdd; // Produit à ajouter au panier

    public ShoppingCartManager() {
        items = new ArrayList<>();
    }

    // Accesseurs pour prodToAdd
    public Product getProdToAdd() {
        return prodToAdd;
    }

    public void setProdToAdd(Product prodToAdd) {
        this.prodToAdd = prodToAdd;
    }

    // Accesseurs pour items
    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    // Méthode pour ajouter un produit au panier
    public String addToCart() {
        // Créer un nouvel item avec le produit sélectionné et une quantité de 1
        ShoppingCartItem newItem = new ShoppingCartItem(prodToAdd, 1);
        items.add(newItem);

        // Rediriger vers la page du panier
        return "toshoppingcart";
    }
}