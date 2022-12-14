import java.util.List;

public class Product {
    private int productID;
    private String productName;

    private String productCategory;
    private int productPrice;

    private int productQuantity;

    public Product() {

    }

    public Product(int productID, String productName, String productCategory, int productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public  int getProductID() { return productID; }

    public void setProductID(int productID) { this.productID = productID; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public String getProductCategory() { return productCategory; }

    public void setProductCategory(String productCategory) { this.productCategory = productCategory; }

    public int getProductPrice() { return productPrice; }

    public void setProductPrice(int productPrice) { this.productPrice = productPrice; }

    public int getProductQuantity() { return productQuantity; }

    public void setProductQuantity(int productQuantity) { this.productQuantity = productQuantity; }


}