package Evento;

import javax.swing.*;

import Reservacion.Reservar;
import Usuario.LoginWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionEventosApp extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Evento> listaEventos;
    private JTextArea eventosTextAreaInformacion;
    private JList<String> eventosList;
    private DefaultListModel<String> eventosListModel;
    private JButton venderEntradasButton;
    private JTextField nombreField;
    private JTextField fechaField;
    private JTextField entradasField;
    private JPanel panel;
    private JLabel nombreLabel, fechaLabel, entradasLabel, lblHotelAbc ;
    private JButton agregarButton, verButton, eliminarButton;
    private JScrollPane eventosScrollPane, eventosTextAreaEliminarScrollPane;
    private String nombre, fechaStr,entradasStr, precioStr, nombreArtista ;
    private Date fecha;
    private Evento nuevoEvento, eventoSeleccionado;
    private JLabel lblNewLabel;
    private JPanel panel_1;
    private JMenuBar menuBar;
    private JButton btnReservar;
    private JButton btnSalir;
    private JButton btnMenuReservar;
    private JButton btnMenuSalir;
    
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEventosApp frame = new GestionEventosApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    }

  
    public GestionEventosApp() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Oculta la ventana en lugar de cerrarla
        setBackground(new Color(71, 169, 146));
        setIconImage(Toolkit.getDefaultToolkit().getImage("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\IconoPrincipal.png"));
        listaEventos = new ArrayList<>();
        setTitle("Hotel ABC");
        setSize(997, 564);
        setLocationRelativeTo(null);
        setResizable(false);

        initializeUI();
    }
    
    
    private void initializeUI() {

    	panel = new JPanel();
    	panel.setBackground(new Color(71, 169, 146));
        panel.setPreferredSize(new Dimension(600, 400));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        
        panel_1 = new JPanel();
        panel_1.setBounds(0, 34, 221, 491);
        panel_1.setBackground(new Color(122, 62, 62));
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        //MenuDeBotones
        menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 981, 35);
        menuBar.setBackground(new Color(122, 62, 62));
        panel.add(menuBar);
        
        btnMenuReservar = new JButton("");
        btnMenuReservar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		       		    }
		});
        btnMenuReservar.setBackground(new Color(122, 62, 62));
        btnMenuReservar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Reservacion.png"));
        menuBar.add(btnMenuReservar);
        
        btnMenuSalir = new JButton("");
        btnMenuSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
		        dispose(); // Cierra la ventana actual
		        EventQueue.invokeLater(new Runnable() {
		            public void run() {
		            	LoginWindow window = new LoginWindow();
						window.frmHotel.setVisible(true);
		            }
		        });
		    }
		});
        btnMenuSalir.setBackground(new Color(122, 62, 62));
        btnMenuSalir.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Salir.png"));
        menuBar.add(btnMenuSalir);
        
        lblHotelAbc = new JLabel("Hotel ABC");
        lblHotelAbc.setBackground(new Color(122, 62, 62));
        lblHotelAbc.setBounds(21, 183, 179, 35);
        lblHotelAbc.setHorizontalAlignment(SwingConstants.CENTER);
        lblHotelAbc.setForeground(new Color(238, 238, 238));
        lblHotelAbc.setFont(new Font("Arial Black", Font.BOLD, 22));
        panel_1.add(lblHotelAbc);
        
        btnReservar = new JButton("         Reservar");
        btnReservar.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Reservacion.png"));
        btnReservar.setBackground(new Color(72, 33, 33));
        btnReservar.setForeground(new Color(255, 255, 255));
        btnReservar.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
			        dispose(); // Cierra la ventana actual
			        EventQueue.invokeLater(new Runnable() {
			            public void run() {
			            	Reservar frame = new Reservar();
							frame.setVisible(true);
			            }
			        });
			    }
			});
        btnReservar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnReservar.setBounds(34, 401, 152, 33);
        panel_1.add(btnReservar);
        
        btnSalir = new JButton(" Cerrar Sección");
        btnSalir .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        dispose(); // Cierra la ventana actual
				        EventQueue.invokeLater(new Runnable() {
				            public void run() {
				            	LoginWindow window = new LoginWindow();
								window.frmHotel.setVisible(true);
				            }
				        });
				    }
				});
        btnSalir.setForeground(new Color(255, 255, 255));
        btnSalir.setBackground(new Color(72, 33, 33));
        btnSalir.setIcon(new ImageIcon("ProgramacionIProyectoFinal-main\\ProyectoProgramacionHotel\\Imagen\\Salir.png"));
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSalir.setBounds(34, 445, 152, 35);
       
        panel_1.add(btnSalir);

     // Crear componentes
        
        lblNewLabel = new JLabel("Gestión de Eventos");
        lblNewLabel.setBounds(481, 73, 278, 30);
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel);
        
        nombreLabel = new JLabel("Nombre del evento:");
        nombreLabel.setBounds(329, 139, 120, 25);
        nombreLabel.setForeground(new Color(0, 0, 0));
        nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(nombreLabel);
        
        nombreField = new JTextField(20);
        nombreField.setBounds(459, 139, 200, 25);
        nombreField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(nombreField);
        
        fechaLabel = new JLabel("Fecha (yyyy-MM-dd):");
        fechaLabel.setBounds(319, 175, 130, 25);
        fechaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        fechaLabel.setForeground(new Color(0, 0, 0));
        fechaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(fechaLabel);
        
        fechaField = new JTextField(10);
        fechaField.setBounds(459, 175, 200, 25);
        fechaField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(fechaField);
        
        entradasLabel = new JLabel("Entradas disponibles:");
        entradasLabel.setBounds(319, 211, 130, 25);
        entradasLabel.setForeground(new Color(0, 0, 0));
        entradasLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        entradasLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(entradasLabel);
        
        entradasField = new JTextField(5);
        entradasField.setBounds(459, 211, 50, 25);
        entradasField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.add(entradasField);

        
        //BotonAgregar
        agregarButton = new JButton("Agregar Evento");
        agregarButton.setBounds(713, 136, 152, 30);
        agregarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        agregarButton.setBackground(new Color(72, 33, 33));
        agregarButton.setForeground(new Color(255, 255, 255));
        panel.add(agregarButton);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarEvento();
            }
        });
        
        
        //BotonVerEventos
        verButton = new JButton("Ver Eventos");
        verButton.setBounds(713, 183, 152, 30);
        verButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        verButton.setBackground(new Color(72, 33, 33));
        verButton.setForeground(new Color(255, 255, 255));
        panel.add(verButton);
        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verEventos();
            }
        });

        
        //BotonEliminarEventos
        eliminarButton = new JButton("Eliminar Evento");
        eliminarButton.setBounds(713, 224, 152, 30);
        eliminarButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        eliminarButton.setBackground(new Color(72, 33, 33));
        eliminarButton.setForeground(new Color(255, 255, 255));
        panel.add(eliminarButton);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEventosPasados();
            }
        });

        //VenderEntradas
        venderEntradasButton = new JButton("Vender Entradas");
        venderEntradasButton.setBounds(323, 446, 140, 30);
        venderEntradasButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        venderEntradasButton.setForeground(new Color(255, 255, 255));
        venderEntradasButton.setBackground(new Color(72, 33, 33));
        panel.add(venderEntradasButton);
        venderEntradasButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		venderEntradas();
        	}
        });
        
        eventosListModel = new DefaultListModel<>(); 
        eventosScrollPane = new JScrollPane();
        eventosScrollPane.setBounds(231, 268, 330, 167);
        panel.add(eventosScrollPane);
        eventosList = new JList<>(eventosListModel);
        eventosList.setFont(new Font("Tahoma", Font.BOLD, 12));
        eventosScrollPane.setViewportView(eventosList);
        eventosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        eventosTextAreaEliminarScrollPane = new JScrollPane();
        eventosTextAreaEliminarScrollPane.setBounds(571, 297, 400, 217);
        panel.add(eventosTextAreaEliminarScrollPane);
        
                eventosTextAreaInformacion = new JTextArea(10, 40);
                eventosTextAreaInformacion.setFont(new Font("Tahoma", Font.BOLD, 13));
                eventosTextAreaEliminarScrollPane.setViewportView(eventosTextAreaInformacion);
                eventosTextAreaInformacion.setEditable(false);
        
       }

    private void agregarEvento() {
        nombre = nombreField.getText();
        fechaStr = fechaField.getText();
        entradasStr = entradasField.getText();
        precioStr = JOptionPane.showInputDialog(this, "Ingrese el precio por entrada:");

        if (nombre.isEmpty() || fechaStr.isEmpty() || entradasStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        fecha = parseFecha(fechaStr);
        if (fecha == null) {
            return;
        }

        int entradasDisponibles = 0;
        double precioEntrada = 0.0;
        try {
            entradasDisponibles = Integer.parseInt(entradasStr);
            precioEntrada = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos para las entradas y el precio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nombreArtista = JOptionPane.showInputDialog(this, "Ingrese el nombre del artista o grupo musical:");
        nuevoEvento = new EventoConcierto(nombre, fecha, entradasDisponibles, precioEntrada, nombreArtista);
        listaEventos.add(nuevoEvento);
        nombreField.setText("");
        fechaField.setText("");
        entradasField.setText("");
        eventosTextAreaInformacion.append("Evento agregado: " + nombre + " (Fecha: " + fechaStr + ", Entradas: " + entradasDisponibles + ", Precio por entrada: $" + precioEntrada + ")\n");
        
        eventosListModel.addElement(nombre); 
        eventosList.setSelectedIndex(eventosListModel.getSize() - 1);
    }

    private void verEventos() {
    	eventosTextAreaInformacion.setText("");
        for (Evento evento : listaEventos) {
        	eventosTextAreaInformacion.append("Nombre: " + evento.getNombre() + ", Fecha: " + evento.getFecha()
                    + ", Entradas disponibles: " + evento.getEntradasDisponibles()
                    + ", Precio por entrada: $" + evento.getPrecioEntrada()
                    + ", Ganancias: $" + evento.calcularGanancias() + "\n");
        }
    }

    private void eliminarEventosPasados() {
    	int selectedIndex = eventosList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un evento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el evento seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            listaEventos.remove(selectedIndex);
            actualizarListaEventos();
        }
    }

    private void actualizarListaEventos() {
        eventosListModel.clear();
        for (Evento evento : listaEventos) {
            eventosListModel.addElement(evento.getNombre());
        }
    }
    
    private Date parseFecha(String fechaStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error al parsear la fecha. Asegúrate de usar el formato 'yyyy-MM-dd'.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    
    private void venderEntradas() {
    	int selectedIndex = eventosList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un evento.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        entradasStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad de entradas a vender:");
        if (entradasStr == null) {
            // User canceled the input dialog
            return;
        }

        int cantidadEntradas;
        try {
            cantidadEntradas = Integer.parseInt(entradasStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para las entradas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        eventoSeleccionado = listaEventos.get(selectedIndex);

        if (cantidadEntradas <= 0) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida de entradas a vender.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidadEntradas > eventoSeleccionado.getEntradasDisponibles()) {
            JOptionPane.showMessageDialog(this, "No hay suficientes entradas disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        eventoSeleccionado.venderEntradas(cantidadEntradas);

        actualizarListaEventos();

    }


class EventoConcierto extends Evento {
    private String nombreArtista;

    public EventoConcierto(String nombre, Date fecha, int entradasDisponibles, double precioEntrada, String nombreArtista) {
        super(nombre, fecha, entradasDisponibles, precioEntrada);
        this.nombreArtista = nombreArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }
}
}
 


