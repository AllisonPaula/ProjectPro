package Reservacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.TitledBorder;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FacturaHuesped extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldHabitacion;
	private JTextField textFieldChekIn;
	private JTextField CheckOut;
	private JTextField textFieldReserve;
	private JTextField textFieldAdicional;
	private JTextField textFieldTotal;
	private JTextField textFieldNombre;
	private JTextField textFieldTarjeta;
	private JTextField textFieldApellido;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacturaHuesped frame = new FacturaHuesped();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FacturaHuesped() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\IconoPrincipal.png"));
		setTitle("Hotel ABC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(71, 169, 146));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hotel ABC");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(72, 33, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 142, 22);
		contentPane.add(lblNewLabel);
		
		JPanel panelReserva = new JPanel();
		panelReserva.setForeground(new Color(0, 0, 0));
		panelReserva.setBackground(new Color(122, 62, 62));
		panelReserva.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DETALLES DE RESERVA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelReserva.setBounds(10, 97, 232, 125);
		contentPane.add(panelReserva);
		panelReserva.setLayout(null);
		
		JLabel lblHabitacion = new JLabel("Tipo Habitacion");
		lblHabitacion.setForeground(new Color(0, 0, 0));
		lblHabitacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHabitacion.setBounds(10, 40, 94, 14);
		panelReserva.add(lblHabitacion);
		
		JLabel lblChecIn = new JLabel("CheckIn");
		lblChecIn.setForeground(new Color(0, 0, 0));
		lblChecIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChecIn.setBounds(10, 65, 80, 14);
		panelReserva.add(lblChecIn);
		
		JLabel lblCheckOut = new JLabel("ChekOut");
		lblCheckOut.setForeground(new Color(0, 0, 0));
		lblCheckOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCheckOut.setBounds(10, 90, 80, 14);
		panelReserva.add(lblCheckOut);
		
		textFieldHabitacion = new JTextField();
		textFieldHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldHabitacion.setEditable(false);
		textFieldHabitacion.setBounds(109, 37, 113, 20);
		panelReserva.add(textFieldHabitacion);
		textFieldHabitacion.setColumns(10);
		
		textFieldChekIn = new JTextField();
		textFieldChekIn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldChekIn.setEditable(false);
		textFieldChekIn.setColumns(10);
		textFieldChekIn.setBounds(109, 62, 113, 20);
		panelReserva.add(textFieldChekIn);
		
		CheckOut = new JTextField();
		CheckOut.setFont(new Font("Tahoma", Font.PLAIN, 10));
		CheckOut.setEditable(false);
		CheckOut.setColumns(10);
		CheckOut.setBounds(109, 87, 113, 20);
		panelReserva.add(CheckOut);
		
		JPanel panel_1Huesped = new JPanel();
		panel_1Huesped.setForeground(new Color(0, 0, 0));
		panel_1Huesped.setBackground(new Color(122, 62, 62));
		panel_1Huesped.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "HUESPED", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1Huesped.setBounds(280, 97, 273, 113);
		contentPane.add(panel_1Huesped);
		panel_1Huesped.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 22, 80, 14);
		panel_1Huesped.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellido.setBounds(10, 52, 80, 14);
		panel_1Huesped.add(lblApellido);
		
		JLabel lblDeTr = new JLabel("Numero de Tarjeta");
		lblDeTr.setForeground(new Color(0, 0, 0));
		lblDeTr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDeTr.setBounds(10, 83, 114, 14);
		panel_1Huesped.add(lblDeTr);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldNombre.setEditable(false);
		textFieldNombre.setBounds(131, 19, 132, 20);
		panel_1Huesped.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldTarjeta = new JTextField();
		textFieldTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldTarjeta.setEditable(false);
		textFieldTarjeta.setColumns(10);
		textFieldTarjeta.setBounds(131, 80, 132, 20);
		panel_1Huesped.add(textFieldTarjeta);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(131, 49, 132, 20);
		panel_1Huesped.add(textFieldApellido);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(122, 62, 62));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "FACTURA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(138, 233, 228, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setForeground(new Color(0, 0, 0));
		lblReserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReserva.setBounds(10, 34, 69, 14);
		panel.add(lblReserva);
		
		textFieldReserve = new JTextField();
		textFieldReserve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldReserve.setEditable(false);
		textFieldReserve.setBounds(149, 31, 69, 20);
		panel.add(textFieldReserve);
		textFieldReserve.setColumns(10);
		
		JLabel lblServiciosAdicionales = new JLabel("Servicios Adicionales");
		lblServiciosAdicionales.setForeground(new Color(0, 0, 0));
		lblServiciosAdicionales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblServiciosAdicionales.setBounds(10, 59, 129, 14);
		panel.add(lblServiciosAdicionales);
		
		textFieldAdicional = new JTextField();
		textFieldAdicional.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldAdicional.setEditable(false);
		textFieldAdicional.setColumns(10);
		textFieldAdicional.setBounds(149, 56, 69, 20);
		panel.add(textFieldAdicional);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(new Color(0, 0, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(10, 93, 109, 14);
		panel.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTotal.setBounds(132, 90, 86, 20);
		panel.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JLabel lblTelHo = new JLabel("Tel: 809-321-4567");
		lblTelHo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelHo.setForeground(new Color(72, 33, 33));
		lblTelHo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelHo.setBounds(399, 31, 117, 14);
		contentPane.add(lblTelHo);
		
		JLabel lblEmaHot = new JLabel("HotelABC@gmail.com");
		lblEmaHot.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmaHot.setForeground(new Color(72, 33, 33));
		lblEmaHot.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmaHot.setBounds(370, 37, 154, 29);
		contentPane.add(lblEmaHot);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\email.png"));
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setForeground(new Color(238, 238, 238));
		btnEnviar.setBackground(new Color(72, 33, 33));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(FacturaHuesped.this, "¡La factura se ha enviado exitosamente!", "Envío Exitoso", JOptionPane.INFORMATION_MESSAGE);
		        dispose();
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	Reservar frame = new Reservar();
						frame.setVisible(true);
		            }
		        });
		        }
		});
		btnEnviar.setBounds(416, 295, 116, 29);
		contentPane.add(btnEnviar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        PrinterJob job = PrinterJob.getPrinterJob();
		        job.setJobName("Imprimir Factura");

		        job.setPrintable(new Printable() {
		            public int print(Graphics pg, PageFormat pf, int pageNum) {
		                if (pageNum > 0) {
		                    return Printable.NO_SUCH_PAGE;
		                }
		                
		                Graphics2D g2 = (Graphics2D) pg;
		                g2.translate(pf.getImageableX(), pf.getImageableY());

		                contentPane.printAll(g2);

		                return Printable.PAGE_EXISTS;
		            }
		        });

		        if (job.printDialog()) {
		            try {
		                job.print();
		            } catch (PrinterException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});

		btnImprimir.setIcon(new ImageIcon("C:\\Users\\hp\\Documents\\ProgramacionIProyectoFinal\\ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\imprimir.png"));
		btnImprimir.setForeground(new Color(238, 238, 238));
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImprimir.setBackground(new Color(72, 33, 33));
		btnImprimir.setBounds(416, 329, 116, 29);
		contentPane.add(btnImprimir);
	}
	 public void setHuespedData(String nombre, String apellido, Date checkIn, int extrasHos, Date checkOutDate, String tipoHabitacion, int nocheCosto,String tarjeta, int costoTotal) {
        textFieldNombre.setText(nombre);
        textFieldApellido.setText(apellido);
        textFieldChekIn.setText(checkIn.toString());
        textFieldReserve.setText(Integer.toString(nocheCosto));
        textFieldAdicional.setText(Integer.toString(extrasHos));
        CheckOut.setText(checkOutDate.toString());
        textFieldTarjeta.setText(tarjeta);
        textFieldTotal.setText(Integer.toString(costoTotal));
        textFieldHabitacion.setText(tipoHabitacion);


        
    }
}
