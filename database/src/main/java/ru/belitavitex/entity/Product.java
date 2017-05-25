package ru.belitavitex.entity;

/**
 * Created by Dzianis on 28.03.2017.
 */
public class Product extends BaseEntity {
    private Category category;
    private String productName;
    private String description;
    private int price;
    private int residue;

    public Product(Category category, String productName, String description, int price, int residue) {
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.residue = residue;
    }

    public Product(Long id, Category category, String productName, String description, int price, int residue) {
        super(id);
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.residue = residue;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", residue=" + residue +
                '}';
    }
}
