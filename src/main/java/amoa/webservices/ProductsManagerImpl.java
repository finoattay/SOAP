package amoa.webservices;

import java.util.ArrayList;

import amoa.domain.Product;
import amoa.domain.Products;
import amoa.exceptions.NoSuchProductException;
import jakarta.jws.WebService;

@WebService(endpointInterface = "amoa.webservices.ProductsManager")
public class ProductsManagerImpl implements ProductsManager {
    private static Products products = new Products(new ArrayList<>());

    @Override
    public long addProduct(Product product) {
        products.add(product);
        return product.getId();
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        Product product = products.get(id);
        if (product != null) {
            return product;
        } else {
            throw new NoSuchProductException("No such product");
        }
    }

    @Override
    public double getProductPrice(long id) throws NoSuchProductException {
        Product product = getProduct(id);
        return product.getPrice();
    }


    @Override
    public Product updateProduct(Product product){
        return null;
    }

    @Override
    public boolean deleteProduct(long id) {
        return products.remove(id);
    }

    @Override
    public boolean deleteAllProducts() {
        products.removeAll();
        return true;
    }

	@Override
	public Products getProducts() {
		// TODO Auto-generated method stub
		return products;
	}
}
