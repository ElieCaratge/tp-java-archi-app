package facade;

import jakarta.ejb.Stateless;
import model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "eMarketPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
}