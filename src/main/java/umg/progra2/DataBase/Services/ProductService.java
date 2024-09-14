package umg.progra2.DataBase.Services;


import umg.progra2.DataBase.Dao.ProductDAO;
import umg.progra2.DataBase.Model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public void createProduct(Product product) throws SQLException {
        productDAO.insert(product);
    }

    public Product getProductById(int id) throws SQLException {
        return productDAO.findById(id);
    }

    public List<Product> getAllProducts() throws SQLException {
        return productDAO.findAll();
    }

    public void updateProduct(Product product) throws SQLException {
        productDAO.update(product);
    }

    public void deleteProduct(int id) throws SQLException {
        productDAO.delete(id);
    }
}