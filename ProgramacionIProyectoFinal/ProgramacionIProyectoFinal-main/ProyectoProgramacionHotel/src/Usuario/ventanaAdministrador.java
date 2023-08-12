package Usuario; // Asegúrate de tener el paquete correcto

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.ImageIcon;

import Reservacion.DatabaseConnection;

public class ventanaAdministrador extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldNom;
    private JTextField textFieldApe;
    private JTextField textFieldCorreo;
    private JPasswordField passwordFieldContra;
    private JTextField textFieldBuscar;
    private JTextField textField;
    private JTextField textField_Sueldo;
    private JTextField textFieldUsuario;
    private DefaultTableModel tableModel;
    private JTable table_1Empleados;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventanaAdministrador frame = new ventanaAdministrador();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	public ventanaAdministrador() {
		getContentPane().setBackground(new Color(72, 33, 33));
		setTitle("Hotel ABC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\IconoPrincipal.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1116, 591);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(72, 33, 33));
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(248, 25, 836, 509);
		getContentPane().add(tabbedPane);
		
		JPanel panel_1Empleados = new JPanel();
		panel_1Empleados.setBackground(new Color(238, 238, 238));
		panel_1Empleados.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, panel_1Empleados, null);
		panel_1Empleados.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setForeground(new Color(0, 0, 0));
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setBounds(78, 22, 123, 37);
		panel_1Empleados.add(lblEmpleados);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(238, 238, 238));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registro de Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(71, 169, 146)));
		panel.setBounds(31, 89, 275, 263);
		panel_1Empleados.add(panel);
		panel.setLayout(null);
		
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setBounds(10, 190, 74, 15);
		panel.add(lblContra);
		lblContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContra.setForeground(new Color(0, 0, 0));
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(83, 34, 171, 20);
		panel.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		passwordFieldContra = new JPasswordField();
		passwordFieldContra.setBounds(94, 188, 160, 20);
		panel.add(passwordFieldContra);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
		lblTipoDeUsuario.setBounds(10, 163, 98, 14);
		panel.add(lblTipoDeUsuario);
		lblTipoDeUsuario.setForeground(Color.BLACK);
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox<String> comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setBounds(120, 155, 134, 22);
		panel.add(comboBoxTipo);
		comboBoxTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Corriente", "Administrador"}));
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 98, 47, 14);
		panel.add(lblCorreo);
		lblCorreo.setForeground(new Color(0, 0, 0));
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(83, 96, 171, 20);
		panel.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JLabel lblApe = new JLabel("Apellido:");
		lblApe.setBounds(10, 67, 57, 14);
		panel.add(lblApe);
		lblApe.setHorizontalAlignment(SwingConstants.CENTER);
		lblApe.setForeground(Color.BLACK);
		lblApe.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldApe = new JTextField();
		textFieldApe.setBounds(83, 65, 171, 20);
		panel.add(textFieldApe);
		textFieldApe.setColumns(10);
		
		JLabel lblNom = new JLabel("Nombre:");
		lblNom.setBounds(10, 36, 57, 14);
		panel.add(lblNom);
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setForeground(new Color(0, 0, 0));
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setForeground(Color.BLACK);
		lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSueldo.setBounds(10, 221, 74, 15);
		panel.add(lblSueldo);
		
		textField_Sueldo = new JTextField();
		textField_Sueldo.setBounds(94, 219, 160, 20);
		panel.add(textField_Sueldo);
		textField_Sueldo.setColumns(10);
		
		JLabel lblUsername = new JLabel("Usuario:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 129, 57, 14);
		panel.add(lblUsername);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(83, 127, 171, 20);
		panel.add(textFieldUsuario);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nombre = textFieldNom.getText();
		        String apellido = textFieldApe.getText();
		        String correo = textFieldCorreo.getText();
		        String usuario = textFieldUsuario.getText();
		        String tipoUsuario = comboBoxTipo.getSelectedItem().toString();
		        String contrasena = new String(passwordFieldContra.getPassword());
		        String sueldo = textField_Sueldo.getText();
		        
		        try {
		        	DatabaseConnection dbConnection = DatabaseConnection.getInstance();
		            Connection connection = dbConnection.getConnection();
			        Statement statement = connection.createStatement();

			        String query = "INSERT INTO usuarios (nombre, apellido, correo, usuario, tipo_usuario, contrasena, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
			        PreparedStatement preparedStatement = connection.prepareStatement(query);
		            preparedStatement.setString(1, nombre);
		            preparedStatement.setString(2, apellido);
		            preparedStatement.setString(3, correo);
		            preparedStatement.setString(4, usuario);
		            preparedStatement.setString(5, tipoUsuario);
		            preparedStatement.setString(6, contrasena);
		            preparedStatement.setString(7, sueldo);
		            preparedStatement.executeUpdate();
		            
		            String[] rowData = {nombre, apellido, correo, usuario, tipoUsuario, contrasena, sueldo};
		            tableModel.addRow(rowData);
		            		            		            
		            statement.close();
		            connection.close();

		           	} catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		btnAgregar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\addUser.png"));
		btnAgregar.setBackground(new Color(72, 33, 33));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setForeground(new Color(238, 238, 238));
		btnAgregar.setBounds(31, 363, 123, 37);
		panel_1Empleados.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\editUser.png"));
		btnEditar.setForeground(new Color(238, 238, 238));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBackground(new Color(72, 33, 33));
		btnEditar.setBounds(191, 363, 123, 37);
		panel_1Empleados.add(btnEditar);
		
		JPanel panel_1ListaEmpleados = new JPanel();
		panel_1ListaEmpleados.setBackground(new Color(238, 238, 238));
		panel_1ListaEmpleados.setForeground(new Color(0, 0, 0));
		panel_1ListaEmpleados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listado de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(71, 169, 146)));
		panel_1ListaEmpleados.setBounds(324, 70, 497, 388);
		panel_1Empleados.add(panel_1ListaEmpleados);
		panel_1ListaEmpleados.setLayout(null);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(319, 22, 46, 40);
		panel_1ListaEmpleados.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\deleteUser.png"));
		btnEliminar.setBackground(new Color(72, 33, 33));
		btnEliminar.setForeground(new Color(238, 238, 238));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		

		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\buscar.png"));
		btnBuscar.setForeground(new Color(238, 238, 238));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBackground(new Color(72, 33, 33));
		btnBuscar.setBounds(263, 22, 46, 40);
		panel_1ListaEmpleados.add(btnBuscar);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	// Dentro del evento btnBuscarActionPerformed
		    	String searchTerm = textFieldBuscar.getText();
		    	String query = "SELECT * FROM usuarios WHERE nombre LIKE ?";
		    	try {
		    	    DatabaseConnection dbConnection = DatabaseConnection.getInstance();
		    	    Connection connection = dbConnection.getConnection();
		    	    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    	    preparedStatement.setString(1, "%" + searchTerm + "%");
		    	    ResultSet resultSet = preparedStatement.executeQuery();

		    	    tableModel.setRowCount(0);

		    	    while (resultSet.next()) {
		    	        Object[] rowData = {
		    	            resultSet.getString("id"),
		    	            resultSet.getString("nombre"),
		    	            resultSet.getString("apellido"),
		    	            resultSet.getString("correo"),
		    	            resultSet.getString("usuario"),
		    	            resultSet.getString("tipo_usuario"),
		    	            resultSet.getString("contrasena"),
		    	            resultSet.getString("sueldo")
		    	        };
		    	        tableModel.addRow(rowData); // Agrega los resultados a la tabla
		    	    }
		    	
		    	    resultSet.close();
		    	    preparedStatement.close();
		    	} catch (SQLException ex) {
		    	    ex.printStackTrace();
		    	}

		lblBuscar.setForeground(new Color(0, 0, 0));
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuscar.setBounds(10, 36, 46, 14);
		panel_1ListaEmpleados.add(lblBuscar);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(66, 34, 181, 20);
		panel_1ListaEmpleados.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total de Empleados:");
		lblTotal.setForeground(new Color(0, 0, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTotal.setBounds(307, 357, 129, 14);
		panel_1ListaEmpleados.add(lblTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(425, 354, 22, 20);
		panel_1ListaEmpleados.add(textField);
		textField.setColumns(10);
		
		table_1Empleados = new JTable(tableModel);
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Apellido");
		tableModel.addColumn("Correo");
		tableModel.addColumn("Usuario");
		tableModel.addColumn("Tipo_Usuario");
		tableModel.addColumn("Contrasena");
		tableModel.addColumn("Sueldo");

		table_1Empleados.setModel(tableModel);
		panel_1ListaEmpleados.add(table_1Empleados);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\cancel.png"));
		btnCancelar.setForeground(new Color(238, 238, 238));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(72, 33, 33));
		btnCancelar.setBounds(101, 411, 123, 47);
		panel_1Empleados.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(71, 169, 146));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Reports");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(214, 26, 63, 22);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(71, 169, 146));
		tabbedPane.addTab("New tab", null, panel_3, null);
		
		JPanel panelMene = new JPanel();
		panelMene.setBackground(new Color(72, 33, 33));
		panelMene.setBounds(0, 0, 249, 552);
		getContentPane().add(panelMene);
		panelMene.setLayout(null);
		
		JLabel lblHotel = new JLabel("Hotel ABC");
		lblHotel.setForeground(new Color(238, 238, 238));
		lblHotel.setBackground(new Color(238, 238, 238));
		lblHotel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setBounds(44, 216, 152, 25);
		panelMene.add(lblHotel);
		
		JButton btnSalir = new JButton("    Salir");
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalir.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Salir.png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    dispose(); 
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	LoginWindow window = new LoginWindow();
						window.frmHotel.setVisible(true);
		            }
		        });
		    }
		});
		btnSalir.setBackground(new Color(122, 62, 62));
		btnSalir.setBounds(59, 406, 106, 33);
		panelMene.add(btnSalir);
	}
}
