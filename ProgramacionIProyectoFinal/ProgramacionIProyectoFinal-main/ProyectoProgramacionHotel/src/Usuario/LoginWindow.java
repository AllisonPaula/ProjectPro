package Usuario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

import Reservacion.Reservar;

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frmHotel;
	private JTextField textField;
	private JPasswordField passwordField;
	JPanel panel_1,panel_2;
	JLabel lblUser, lblUsuario, lblContrasea, lblTipoUsuario;
	JButton btnIngresar;
	private JLabel lblBienvenida;
	private JLabel lblNombreHotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginWindow() {
		initialize();
	}
	private void initialize() {
		frmHotel = new JFrame();
		frmHotel.setResizable(false);
		frmHotel.setTitle("Hotel ABC");
		frmHotel.setIconImage(Toolkit.getDefaultToolkit().getImage("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\IconoPrincipal.png"));
		frmHotel.getContentPane().setEnabled(false);
		frmHotel.getContentPane().setBackground(new Color(72, 33, 33));
		frmHotel.setBounds(100, 100, 689, 472);
		frmHotel.getContentPane().setLayout(null);
		
		////////Panel 1
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(122, 62, 62));
		panel_1.setBounds(0, 0, 252, 433);
		frmHotel.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblBienvenida = new JLabel("Bienvenido al ");
		lblBienvenida.setForeground(new Color(238, 238, 238));
		lblBienvenida.setFont(new Font("Kristen ITC", Font.BOLD, 25));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(22, 161, 203, 31);
		panel_1.add(lblBienvenida);
		
		lblNombreHotel = new JLabel("Hotel ABC");
		lblNombreHotel.setForeground(new Color(238, 238, 238));
		lblNombreHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreHotel.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNombreHotel.setBounds(22, 223, 203, 31);
		panel_1.add(lblNombreHotel);
		
		////Panel 2
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(71, 169, 146));
		panel_2.setBounds(251, 0, 422, 433);
        frmHotel.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\LoginUser.png"));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(142, 39, 166, 153);
		panel_2.add(lblUser);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(94, 269, 59, 20);
		panel_2.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setFont(new Font("Arial", Font.BOLD, 12));
		textField.setBounds(163, 270, 167, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(0, 0, 0));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(65, 312, 88, 20);
		panel_2.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setFont(new Font("Arial", Font.BOLD, 12));
		passwordField.setBounds(163, 313, 167, 20);
		panel_2.add(passwordField);
		
		lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setForeground(new Color(0, 0, 0));
		lblTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoUsuario.setBounds(65, 222, 88, 20);
		panel_2.add(lblTipoUsuario);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(238, 238, 238));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccionar", "Administrador", "Corriente"}));
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox.setBounds(163, 222, 167, 22);
		panel_2.add(comboBox);
		
		btnIngresar = new JButton("Iniciar Sección");
		
		btnIngresar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String usuario = textField.getText();
		        String contrasena = new String(passwordField.getPassword());
		        String tipoUsuario = comboBox.getSelectedItem().toString();

		        if (verificarCredenciales(usuario, contrasena, tipoUsuario)) {
		            dispose(); // Cierra la ventana actual
		            EventQueue.invokeLater(new Runnable() {
		                public void run() {
		                    if (tipoUsuario.equals("Administrador")) {
		                        // Open the administrator window
		                    	ventanaAdministrador frame = new ventanaAdministrador();
		    					frame.setVisible(true);
		                    } else if (tipoUsuario.equals("Corriente")) {
		                        // Open the regular user window
		                        Reservar reservarWindow = new Reservar();
		                        reservarWindow.setVisible(true);
		                    }
		                }
		            });
		        } else {
		            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		
		btnIngresar.setForeground(new Color(238, 238, 238));
		btnIngresar.setBackground(new Color(72, 33, 33));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setBounds(175, 357, 133, 23);
		panel_2.add(btnIngresar);
		
    }

    private boolean verificarCredenciales(String usuario, String contrasena, String tipoUsuario) {
        String url = "jdbc:mysql://localhost/hotel_db";
        String user = "root";
        String password = "Allison.031";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ? AND tipo_usuario = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            statement.setString(3, tipoUsuario);

            ResultSet resultSet = statement.executeQuery();
            boolean isValid = resultSet.next();

            resultSet.close();
            statement.close();
            connection.close();

            return isValid;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
       
    }
	}
