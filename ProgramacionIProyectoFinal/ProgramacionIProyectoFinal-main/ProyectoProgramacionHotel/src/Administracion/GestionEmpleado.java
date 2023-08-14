package Administracion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.JTextField;


import ConectarBaseDeDatos.DatabaseConnection;

public class GestionEmpleado {
    private Connection connection;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreo;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JTextField textFieldSueldo;
    private JComboBox<String> comboBox;

    public GestionEmpleado(JTextField textFieldNombre, JTextField textFieldApellido, JTextField textFieldCorreo,
                           JTextField textFieldUsuario, JPasswordField passwordField, JTextField textFieldSueldo,
                           JComboBox<String> comboBox) {
        this.textFieldNombre = textFieldNombre;
        this.textFieldApellido = textFieldApellido;
        this.textFieldCorreo = textFieldCorreo;
        this.textFieldUsuario = textFieldUsuario;
        this.passwordField = passwordField;
        this.textFieldSueldo = textFieldSueldo;
        this.comboBox = comboBox;

        try {
			connectToDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void connectToDatabase() throws SQLException {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
		connection = dbConnection.getConnection();
    }

    public void agregarEmpleado() {
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String correo = textFieldCorreo.getText();
        String usuario = textFieldUsuario.getText();
        String tipoUsuario = (String) comboBox.getSelectedItem();
        String contrasena = new String(passwordField.getPassword());
        double sueldo = Double.parseDouble(textFieldSueldo.getText());

        String insertQuery = "INSERT INTO usuarios (nombre, apellido, correo, usuario, tipo_usuario, contrasena, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, correo);
            preparedStatement.setString(4, usuario);
            preparedStatement.setString(5, tipoUsuario);
            preparedStatement.setString(6, contrasena);
            preparedStatement.setDouble(7, sueldo);

            preparedStatement.executeUpdate();

            textFieldNombre.setText("");
            textFieldApellido.setText("");
            textFieldCorreo.setText("");
            textFieldUsuario.setText("");
            passwordField.setText("");
            textFieldSueldo.setText("");

            JOptionPane.showMessageDialog(null, "Empleado agregado exitosamente.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar empleado.");
        }
    }
    
}