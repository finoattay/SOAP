package amoa.domain;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
    @XmlElement(name = "product")
    private List<Product> products;

    public Products() {
        this.products = new ArrayList<>();
    }

    public Products(List<Product> products) {
        this.products = products;
    }

    public long add(Product product) {
        products.add(product);
        return product.getId();
    }

    public Product get(long id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public boolean remove(long id) {
        for (Product product : products) {
            if (id == product.getId()) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll() {
        products.clear();
        return true;
    }

}
