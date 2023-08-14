package Administracion; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import Ingresar.LoginWindow;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;

public class ventanaAdministrador extends JFrame {

    private static final long serialVersionUID = 1L;
	private JTable reportsTable;
    private JButton generateButton;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreo;
    private JTextField textFieldUsuario;
    private JTextField textFieldSueldo;
    private JPasswordField passwordField;
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
		getContentPane().setBackground(new Color(122, 62, 62));
		setTitle("Hotel ABC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\IconoPrincipal.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1116, 633);
		getContentPane().setLayout(null);
		
		JPanel panelMene = new JPanel();
		panelMene.setBounds(0, 0, 241, 552);
		panelMene.setBackground(new Color(122, 62, 62));
		getContentPane().add(panelMene);
		panelMene.setLayout(null);
		
		JLabel lblHotel = new JLabel("Hotel ABC");
		lblHotel.setForeground(new Color(238, 238, 238));
		lblHotel.setBackground(new Color(238, 238, 238));
		lblHotel.setFont(new Font("Segoe Script", Font.BOLD, 25));
		lblHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotel.setBounds(44, 216, 152, 25);
		panelMene.add(lblHotel);
		
		JButton btnSalir = new JButton("    Salir");
		btnSalir.setForeground(new Color(238, 238, 238));
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
		btnSalir.setBackground(new Color(72, 33, 33));
		btnSalir.setBounds(59, 406, 122, 33);
		panelMene.add(btnSalir);
		
		JButton btnHabitaciones = new JButton("   Habitaciones");
		btnHabitaciones.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\bed.png"));
		btnHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	Habitaciones frame = new Habitaciones();
	                    frame.setVisible(true);		    }
        });
    }
});
		btnHabitaciones.setForeground(new Color(238, 238, 238));
		btnHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHabitaciones.setBackground(new Color(72, 33, 33));
		btnHabitaciones.setBounds(44, 450, 152, 33);
		panelMene.add(btnHabitaciones);
	
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setBounds(242, 0, 829, 569);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBackground(new Color(71, 169, 146));
		tabbedPane.setBorder(null);
		getContentPane().add(tabbedPane);
		
		
		
		//////////////////////////Empleados////////////////////////////////////////////////////////////////////
		
		JPanel panel_Empleado = new JPanel();
		panel_Empleado.setBackground(new Color(71, 169, 146));
		tabbedPane.addTab("Empleados", null, panel_Empleado, null);
		panel_Empleado.setLayout(null);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(new Color(72, 33, 33));
		panelRegistro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registro de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(71, 169, 146)));
		panelRegistro.setBounds(41, 74, 264, 293);
		panel_Empleado.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(238, 238, 238));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 46, 55, 14);
		panelRegistro.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(238, 238, 238));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(10, 79, 55, 14);
		panelRegistro.add(lblApellido);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(new Color(238, 238, 238));
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorreo.setBounds(10, 114, 55, 14);
		panelRegistro.add(lblCorreo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(238, 238, 238));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(10, 189, 55, 14);
		panelRegistro.add(lblUsuario);
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setForeground(new Color(238, 238, 238));
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuario.setBounds(10, 151, 76, 14);
		panelRegistro.add(lblTipoUsuario);
		
		JLabel lblContras = new JLabel("Contraseña");
		lblContras.setForeground(new Color(238, 238, 238));
		lblContras.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContras.setBounds(10, 221, 76, 14);
		panelRegistro.add(lblContras);
		
		JLabel lblSueldo = new JLabel("Sueldo");
		lblSueldo.setForeground(new Color(238, 238, 238));
		lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSueldo.setBounds(10, 257, 76, 14);
		panelRegistro.add(lblSueldo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(101, 43, 153, 20);
		panelRegistro.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(101, 76, 153, 20);
		panelRegistro.add(textFieldApellido);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(101, 111, 153, 20);
		panelRegistro.add(textFieldCorreo);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(101, 186, 153, 20);
		panelRegistro.add(textFieldUsuario);
		
		textFieldSueldo = new JTextField();
		textFieldSueldo.setColumns(10);
		textFieldSueldo.setBounds(101, 251, 153, 20);
		panelRegistro.add(textFieldSueldo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 218, 153, 20);
		panelRegistro.add(passwordField);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Corriente", "Administrador"}));
		comboBox.setBounds(101, 147, 153, 22);
		panelRegistro.add(comboBox);
	
    	
    	JButton btnAgrega = new JButton("Agregar");
    	btnAgrega.setBackground(new Color(72, 33, 33));
    	btnAgrega.setForeground(new Color(238, 238, 238));
    	btnAgrega.setFont(new Font("Tahoma", Font.BOLD, 12));
    	btnAgrega.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\añadir.png"));
    	btnAgrega.setBounds(108, 378, 114, 33);
    	panel_Empleado.add(btnAgrega);
    	btnAgrega.addActionListener(new ActionListener() {
        	GestionEmpleado gestionEmpleado = new GestionEmpleado(textFieldNombre, textFieldApellido, textFieldCorreo,
                    textFieldUsuario, passwordField, textFieldSueldo,
                    comboBox);
            public void actionPerformed(ActionEvent e) {
            	 gestionEmpleado.agregarEmpleado();
            }
  
        });
	
    	
    	EmpleadosTabla empleadosTabla = new EmpleadosTabla();

    	JPanel panelVerEmpleados = new JPanel();
    	panelVerEmpleados.setBounds(348, 74, 466, 347);
    	panelVerEmpleados.setLayout(new BorderLayout());

    	JScrollPane scrollPane1 = new JScrollPane(empleadosTabla.getTablaEmpleados());
    	panelVerEmpleados.add(scrollPane1, BorderLayout.CENTER);

    	panel_Empleado.add(panelVerEmpleados);
    	
    	JLabel lblNewLabel = new JLabel("Listado de Empleados");
    	lblNewLabel.setForeground(new Color(72, 33, 33));
    	lblNewLabel.setBackground(new Color(71, 169, 146));
    	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    	lblNewLabel.setBounds(350, 60, 143, 14);
    	panel_Empleado.add(lblNewLabel);
    	
///////////////////////////////Reportes//////////////////////////////////////////////////////////////////
		JPanel panel_Reports = new JPanel();
        panel_Reports.setBackground(new Color(71, 169, 146));
        tabbedPane.addTab("Reports", null, panel_Reports, null);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID Reservacion");
        tableModel.addColumn("ID Huesped");
        tableModel.addColumn("Tipo Habitacion");
        tableModel.addColumn("Check-in");
        tableModel.addColumn("Check-out");
        tableModel.addColumn("Costo");
        panel_Reports.setLayout(null);

        reportsTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reportsTable);
        scrollPane.setBounds(195, 11, 619, 519);
        panel_Reports.add(scrollPane);

        generateButton = new JButton("Generar Reports");
        generateButton.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\report.png"));
        generateButton.setBackground(new Color(72, 33, 33));
        generateButton.setForeground(new Color(238, 238, 238));
        generateButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        generateButton.setBounds(20, 238, 165, 32);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports reports = new Reports();
                reports.generateReports(tableModel); 
            }
        });
        panel_Reports.add(generateButton);
    }
}