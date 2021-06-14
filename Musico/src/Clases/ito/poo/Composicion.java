
package Clases.ito.poo;

import java.io.Serializable;
import java.sql.Date;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
// Start of user code (user defined imports)

// End of user code

public class Composicion implements Comparable <Composicion> {
	private String titulo;
	private Float duracionmusic;
    private static Serializable interpretes= new ArrayList<String>();
    private static java.util.List<String> musico= new ArrayList<String>();
	private String generoMusical;
	private java.time.LocalDate fechaDeRegistro = null;
	private java.time.LocalDate fechaDeEstreno = null;

	
	public Composicion(String titulo, Float duracionmusic, String generoMusical,LocalDate fechaDeRegistro, LocalDate fechaDeEstreno) {
		super();
		this.titulo = titulo;
		this.duracionmusic= duracionmusic;
		this.interpretes = interpretes;
		this.musico = musico;
		this.generoMusical = generoMusical;
		this.fechaDeRegistro =fechaDeRegistro ;
		this.fechaDeEstreno = fechaDeEstreno;
	}
	public  String solicitarInterprete(String nuevoInterprete) {
		((ArrayList<String>) interpretes).add(nuevoInterprete);
	    return nuevoInterprete;
	}
	public  String musicoOri(String nuevomusico) {
		musico.add(nuevomusico);
	    return nuevomusico ;
	}

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Float getDuracionmusic() {
		return duracionmusic;
	}


	public void setDuracionmusic(Float duracionmusic) {
		this.duracionmusic = duracionmusic;
	}


	public static String getInterpretes() {
		return (String) interpretes;
	}


	public static void setInterpretes(List<String> Interpretes) {
		Composicion.interpretes = (Serializable) Interpretes;
	}


	public String getGeneroMusical() {
		return generoMusical;
	}


	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}


	public java.time.LocalDate getFechaDeRegistro() {
		return fechaDeRegistro;
	}


	public void setFechaDeRegistro(java.time.LocalDate fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}


	public java.time.LocalDate getFechaDeEstreno() {
		return fechaDeEstreno;
	}


	public void setFechaDeEstreno(java.time.LocalDate fechaDeEstreno) {
		this.fechaDeEstreno = fechaDeEstreno;
	}

	
	public void setDuracionPista(float nextFloat) {
		// TODO Auto-generated method stub
		
	}
	public void setInterpretes(String nextLine) {
		// TODO Auto-generated method stub
		
	}
	public boolean agregarInterpretes(String h){
		boolean agregar = false;
		if (h!= null&&!h.equalsIgnoreCase("")) {
			this.interpretes=h;
				agregar = true;
		}else
			agregar=false;
		return agregar;
	}
	
	public boolean EliminaInterprete (String h) {
		boolean eliminar=false;
		if(h.equals(this.interpretes)) {
			this.interpretes=null;
			eliminar=true;
		}else
			eliminar=false;
		return eliminar;
		
	}
	public String toString() {
		return "Composicion [titulo=" + titulo + ", duracionmusic=" + duracionmusic + ", generoMusical=" + generoMusical
				+ ", fechaDeRegistro=" + fechaDeRegistro + ", fechaDeEstreno=" + fechaDeEstreno + "]";
		
	}
	public int compareTo(Composicion o) {
		int compare=0;
		if(this.titulo.equals(o.getTitulo()))
		compare=-1;
		else if(!this.titulo.equalsIgnoreCase(o.getTitulo()));
			compare=1;
		return compare;
}
	public Composicion getComposicion(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Composicion getItem(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
