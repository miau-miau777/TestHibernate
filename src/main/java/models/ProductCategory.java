package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
public class ProductCategory extends Model {
    @Column(name = "title")
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prodCat", referencedColumnName = "id")
    private ProductCategory parentProductCategory;
    private Set<Product> products = new HashSet<Product>();

    public ProductCategory(Integer id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductCategory getParentProductCategory() {
        return parentProductCategory;
    }

    public void setParentProductCategory(ProductCategory parentProductCategory) {
        this.parentProductCategory = parentProductCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
