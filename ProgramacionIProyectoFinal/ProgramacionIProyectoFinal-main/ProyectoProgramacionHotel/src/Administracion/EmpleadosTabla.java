package Administracion;

import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import ConectarBaseDeDatos.DatabaseConnection;

public class EmpleadosTabla extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaEmpleados;
    private DefaultTableModel model;

    public EmpleadosTabla() {
        setTitle("Lista de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        model = new DefaultTableModel();
        tablaEmpleados = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Usuario");
        model.addColumn("Tipo");
        model.addColumn("Sueldo");

        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane);

        cargarDatosDesdeBaseDeDatos(); 
    }

    private void cargarDatosDesdeBaseDeDatos() {
        try {
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String usuario= resultSet.getString("usuario");
                String tipousuario= resultSet.getString("tipo_usuario");
                String sueldo= resultSet.getString("sueldo");

                model.addRow(new Object[]{id, nombre, apellido, usuario, tipousuario, sueldo});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpleadosTabla ventana = new EmpleadosTabla();
            ventana.setVisible(true);
        });
    }

    public JTable getTablaEmpleados() {
        return tablaEmpleados;
    }
}
