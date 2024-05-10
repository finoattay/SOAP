package amoa.webservices;

import amoa.domain.Product;
import amoa.domain.Products;
import amoa.exceptions.NoSuchProductException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProductsManager {

    @WebMethod
    @WebResult(name = "productId")
    public long addProduct(@WebParam(name = "product") Product product);

    @WebMethod
    @WebResult(name = "product")
    public Product getProduct(@WebParam(name = "productId") long id) throws NoSuchProductException;

    @WebMethod
    @WebResult(name = "price")
    public double getProductPrice(@WebParam(name = "productId") long id) throws NoSuchProductException;

    @WebMethod
    @WebResult(name = "products")
    public Products getProducts();

    @WebMethod
    @WebResult(name = "product")
    public Product updateProduct(@WebParam(name = "product") Product product);

    @WebMethod
    public boolean deleteProduct(@WebParam(name = "productId") long id);

    @WebMethod
    public boolean deleteAllProducts();
}
