package Administracion;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Random;
import javax.swing.border.TitledBorder;

import Ingresar.LoginWindow;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Habitaciones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String imagePath = "C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Cama.png";
    private Color[] buttonColors = {new Color(0, 145, 72), new Color(138, 0, 0), new Color(111, 111, 255), new Color(240, 198, 98)};
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Habitaciones frame = new Habitaciones();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Habitaciones() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 998, 553);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(71, 169, 146));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelHabitaciones = new JPanel();
        panelHabitaciones.setBackground(new Color(238, 238, 238));
        panelHabitaciones.setBounds(254, 95, 553, 372);
        contentPane.add(panelHabitaciones);
        panelHabitaciones.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(122, 62, 62));
        panel.setBounds(0, 0, 232, 514);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Hotel ABC");
        panelHabitaciones.setBackground(new Color(238, 238, 238));
        lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD, 25));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(47, 193, 148, 22);
        panel.add(lblNewLabel_1);
        
        JButton btnSalir = new JButton("   Salir");
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
        btnSalir.setForeground(new Color(238, 238, 238));
        btnSalir.setBackground(new Color(72, 33, 33));
        btnSalir.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Salir.png"));
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSalir.setBounds(47, 359, 126, 33);
        panel.add(btnSalir);
        
        JButton btnAtrs = new JButton("Atrás");
        btnAtrs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
		        EventQueue.invokeLater(new Runnable() {
		        public void run() {
        		 ventanaAdministrador frame = new ventanaAdministrador();
                 frame.setVisible(true);
        	}
        	
        });
        	 }
		});
        btnAtrs.setForeground(new Color(238, 238, 238));
        btnAtrs.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\back.png"));
        btnAtrs.setBackground(new Color(72, 33, 33));
        btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAtrs.setBounds(47, 313, 122, 33);
        panel.add(btnAtrs);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(238, 238, 238));
        panel_1.setBorder(new TitledBorder(null, "Leyenda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 33, 33)));
        panel_1.setBounds(817, 240, 155, 126);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        textField = new JTextField();
        textField.setBackground(new Color(138, 0, 0));
        textField.setBounds(10, 34, 16, 11);
        panel_1.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBackground(new Color(111, 111, 255));
        textField_1.setBounds(10, 56, 16, 11);
        panel_1.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBackground(new Color(0, 145, 72));
        textField_2.setBounds(10, 78, 16, 11);
        panel_1.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBackground(new Color(240, 198, 98));
        textField_3.setBounds(10, 100, 16, 11);
        panel_1.add(textField_3);
        
        JLabel lblNewLabel_2 = new JLabel("En Mantenimiento");
        lblNewLabel_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(36, 33, 109, 14);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Ocupada");
        lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_1.setBounds(36, 53, 109, 14);
        panel_1.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Disponible");
        lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_2.setBounds(36, 77, 109, 14);
        panel_1.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("Reservada");
        lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2_3.setBounds(36, 99, 109, 14);
        panel_1.add(lblNewLabel_2_3);
        
        JLabel lblNewLabel = new JLabel("Estado de Habitaciones");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblNewLabel.setBounds(254, 54, 553, 30);
        contentPane.add(lblNewLabel);

        int buttonWidth = 55;
        int buttonHeight = 34;
        int x = 21;
        int y = 11;
        Random random = new Random();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JButton button = new JButton("");
                button.setIcon(new ImageIcon(imagePath));
                Color randomColor = buttonColors[random.nextInt(buttonColors.length)];
                button.setBackground(randomColor);
                button.setBounds(x, y, buttonWidth, buttonHeight);
                panelHabitaciones.add(button);
                x += buttonWidth + 10; 
            }
            x = 21;
            y += buttonHeight + 10; 
        }
    }
}
