import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductUtil {

    private ProductUtil() {

    }

    private static final String CREATE_TABLE = "CREATE TABLE PRODUCTS(" +
            "PRODUCT_ID INTEGER AUTO_INCREMENT NOT NULL," +
            "PRODUCT_NAME VARCHAR(255)," +
            "PRODUCT_CATEGORY VARCHAR(255)," +
            "PRODUCT_PRICE INTEGER," +
            "PRIMARY KEY(PRODUCT_ID))";



    public static void createTable() throws SQLException {
        try {
            JDBCConfig.getStatement().executeUpdate(CREATE_TABLE);
            System.out.println("Create table in given database");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Integer> selectAllProduct() throws SQLException {
        String select = "SELECT * FROM PRODUCTS";

        List<Product> products = new ArrayList<>();
        Product product  = new Product();

        try{
            ResultSet result = JDBCConfig.getStatement().executeQuery(select);

            while (result.next()){
                product.setProductID(result.getInt("PRODUCT_ID"));
                product.setProductName(result.getString("PRODUCT_NAME"));
                product.setProductCategory(result.getString("PRODUCT_CATEGORY"));
                product.setProductPrice(result.getInt("PRODUCT_PRICE"));

                products.add(product);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        Map<String, Integer> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductName, Product::getProductQuantity));

        return productMap;
    }

    public static Map<String, Integer> findDuplicate(List<Product> list) {

        return list.stream().filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toMap(Product::getProductName, Product::getProductQuantity));
    }

    private static void insert(Product product){
        String INSET_TABLE = "INSERT INTO PRODUCTS(FIRST_NAME, lAST_NAME, SALARY)" +
                "VALUES(" + product.getProductName() +"," + product.getProductCategory() +"," + product.getProductPrice() + ")";

        try{
            JDBCConfig.getStatement().executeUpdate(INSET_TABLE);
            System.out.println("Table updated");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateTable(long id, String newName){

        String update ="UPDATE PRODUCTS SET PRODUCT_NAME = " + newName + " WHERE PRODUCT_ID =" + id;

        try {
            JDBCConfig.getStatement().executeUpdate(update);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteEmployee(long id){
        String delete = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = " + id;

        try {
            JDBCConfig.getStatement().executeUpdate(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
