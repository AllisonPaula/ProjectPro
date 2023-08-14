package Administracion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import ConectarBaseDeDatos.DatabaseConnection;

public class Reports {
	void generateReports(DefaultTableModel tableModel) {
	    // Realiza la conexión a la base de datos y ejecuta la consulta
	    try {
	    	   
        	DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT * FROM Reserva");

	        // Limpia la tabla existente
	        tableModel.setRowCount(0);

	        // Agrega los datos de la base de datos a la tabla
	        while (resultSet.next()) {
	            int id = resultSet.getInt("ID");
	            String nombre = resultSet.getString("HuespedID");
	            String tipoHabitacion = resultSet.getString("TipoHabitacion");
	            String checkIn = resultSet.getString("CheckIn");
	            String checkOut = resultSet.getString("CheckOut");
	            int costo = resultSet.getInt("Costo");
	            Object[] reservation = {id, nombre, tipoHabitacion, checkIn, checkOut, costo};
	            tableModel.addRow(reservation);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
