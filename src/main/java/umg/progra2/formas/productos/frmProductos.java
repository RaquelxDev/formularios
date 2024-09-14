package umg.progra2.formas.productos;

import umg.progra2.DataBase.Model.Product;
import umg.progra2.DataBase.Services.ProductService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmProductos {
    private JPanel JPanelPrincipal;
    private JLabel lblTitulo;
    private JLabel lblid;
    private JTextField textFieldidProducto;
    private JLabel lblNombre;
    private JTextField textFieldidNombreProducto;
    private JLabel lblOrigen;
    private JComboBox comboBoxOrigen;

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmProductos");
        frame.setContentPane(new frmProductos().JPanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton buttonGrabar;
    private JButton buttonBuscar;

    public frmProductos(){

    comboBoxOrigen.addItem("China");
    comboBoxOrigen.addItem("Japon");
    comboBoxOrigen.addItem("Corea");


        buttonGrabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //codigo que se ejecutara al dar click al boton

                Product product = new Product();
                product.setDescripcion(textFieldidProducto.getText());
                Product.setOrigen(comboBoxOrigen.getSelectedItem().toString());

                try {

                    new ProductService().createProduct(product);
                    JOptionPane.showMessageDialog(null, "El producto se ha guardado correctamente");
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al guardar el producto");
                }
            }
        });
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idProducto = textFieldidProducto.getText().isEmpty() ? 0 : Integer.parseInt(textFieldidProducto.getText());

                try {                           //? es en ingles?
                    Product productoEncontrado = ProductoEncontrado().obtenerProducto(idProducto);
                    textFieldidNombreProducto.setText(productoEncontrado.getDescripcion());
                    comboBoxOrigen.setSelectedItem(productoEncontrado.getOrigen());

                }else{

                    JOptionPane.showMessageDialog(null, "Código de producto no existe");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error de base de datos");


                }
                //FALTA CREAR BOTON BUSCARRRRRRRRR

            }
        });


        


    }
}
