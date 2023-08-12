package Evento;

import java.util.Date;

public interface VentaEntradas {
	void venderEntradas(int cantidadVendida);
	}

	abstract class Evento implements VentaEntradas {
	    private String nombre;
	    private Date fecha;
	    private int entradasDisponibles;
	    private double precioEntrada;
		private int entradasVendidas;

	    public Evento(String nombre, Date fecha, int entradasDisponibles, double precioEntrada) {
	        this.nombre = nombre;
	        this.fecha = fecha;
	        this.entradasDisponibles = entradasDisponibles;
	        this.precioEntrada = precioEntrada;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public Date getFecha() {
	        return fecha;
	    }

	    public int getEntradasDisponibles() {
	        return entradasDisponibles;
	    }

	    public void venderEntradas(int cantidadVendida) {
	    	if (cantidadVendida > 0 && cantidadVendida <= entradasDisponibles) {
	            entradasDisponibles -= cantidadVendida;
	            entradasVendidas += cantidadVendida; // Incrementamos las entradas vendidas
	        } else {
	            System.out.println("No hay suficientes entradas disponibles para el evento " + nombre);
	        }
	    }
	    
	    public double getPrecioEntrada() {
	        return precioEntrada;
	    }

	    public void setPrecioEntrada(double precioEntrada) {
	        this.precioEntrada = precioEntrada;
	    }

	    // Nuevo método para calcular las ganancias
	    public double calcularGanancias() {
	        return (entradasVendidas * precioEntrada);
	    }    
}