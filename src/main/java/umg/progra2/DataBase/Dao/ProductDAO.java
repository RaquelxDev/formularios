package umg.progra2.DataBase.Dao;

import umg.progra2.DataBase.Model.Product;
import umg.progra2.DataBase.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void insert(Product product) throws SQLException {
        String sql = "INSERT INTO tb_producto (descripcion, origen) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, product.getDescripcion());
            pstmt.setString(2, product.getOrigen());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    product.setIdProducto(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Product findById(int id) throws SQLException {
        String sql = "SELECT * FROM tb_producto WHERE id_producto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getInt("id_producto"),
                            rs.getString("descripcion"),
                            rs.getString("origen")
                    );
                }
            }
        }
        return null;
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM tb_producto";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id_producto"),
                        rs.getString("descripcion"),
                        rs.getString("origen")
                ));
            }
        }
        return products;
    }

    public void update(Product product) throws SQLException {
        String sql = "UPDATE tb_producto SET descripcion = ?, origen = ? WHERE id_producto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getDescripcion());
            pstmt.setString(2, product.getOrigen());
            pstmt.setInt(3, product.getIdProducto());
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM tb_producto WHERE id_producto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}