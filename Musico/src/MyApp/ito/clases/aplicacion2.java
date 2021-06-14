package MyApp.ito.clases;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.Component;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import Clases.ito.poo.LectorArchivoTXT;
import Clases.ito.poo.EscritorArchivoTXT;
import Clases.ito.poo.EscritorObjetos;
import Clases.ito.poo.LectorObjetos;
import exepsiones.ito.poo.ExcepcionBaja;
import exepsiones.ito.poo.ExcepcionComposicion;
import interfaces.ito.poo.Arreglo;
import Clases.ito.poo.Composicion;
import Clases.ito.poo.Composiciones;

import java.util.Scanner;

import javax.swing.JOptionPane;
public class aplicacion2 {
	
	static Composiciones m=new Composiciones();
	static EscritorArchivoTXT info01;//n
	static LectorArchivoTXT info02;//n
	static RandomAccessFile info03;
	private static Scanner e;
	private static Scanner r;
	private static String respuesta;
	private static int a;
	private static Composicion we;
	static void menu() throws Exception {
		inicio();
		Scanner e=new Scanner(System.in);
		//boolean ciclo=true;//
		
		int respuesta;
		while(true) {
		String opciones="Elija la opción que desee:\n 1)AgregarComposicion\n 2)Listado\n 3)AgregarInterprete\n 4)EliminarInterprete\n 5)ElimarComposicion\n"
				+ "6)Salir";
		respuesta=Integer.parseInt(JOptionPane.showInputDialog(opciones));
		switch(respuesta) {
		case 1:agregarComposicion();break;
		case 2:listado();break;
		case 3:AgregaInterprete();break;
		case 4:eliminarInterprete();break;
		case 5:eliminarComposicion();break;
		  }
		if(respuesta==6)break;
		}
	}
	
	private static void inicio() {
		
		
	}
     
 
	 static Composicion altas()throws Exception{ 
		Scanner e=new Scanner(System.in);
		Composicion pp=new Composicion (null, null, null, null, null);
		System.out.print("Proporciona el nombre de la cansion");
		pp.setTitulo(e.nextLine());
		System.out.println("proporciona la fecha de registro aaaa-dia-mes:");
		String fecha=e.nextLine();
		pp.setFechaDeRegistro(LocalDate.parse(fecha));
		System.out.print("Proporciona fecha de estreno aaaa-dia-mes:");
		String fechaDeEstreno=e.nextLine();
		System.out.println("Ingrese duracion de la pista");
		pp.setDuracionPista(e.nextFloat());e.nextLine();
		System.out.println("Ingrese el genero musical");
		pp.setGeneroMusical(e.nextLine());
		System.out.println("Ingrese los interpretes que le han solicitado interpretarla");
		pp.setInterpretes(e.nextLine());
		pp.setFechaDeEstreno(LocalDate.parse(fechaDeEstreno));
		
		return pp; 
		
		
		
	}
	 static void agregarComposicion() throws Exception,ExcepcionComposicion {
		 Composicion nueva;
		 nueva= altas();
		 if(m.addItem(nueva))
			 System.out.println("Exito:se agrego la composicion sin problema");
	 else
		  throw new ExcepcionComposicion("Error:la composicion existe por lo que no se pudo agregar");  
      		     
}



	 @SuppressWarnings("null")
	static Composicion seleccionar(String seleccionar) {
		 Composicion p=null; int i=0;
		    for (;i <p.getSize();i++) {
		      we = p.getItem(i);
		      System.out.println(p.getItem(i)+" Es la composicion a "+seleccionar);
		      String respuesta=e.nextLine();
		      if(respuesta.equalsIgnoreCase("Si"))
		    	 break;
		      we=null;
		    }
			return we;
	 }
	  
	 
	 static void AgregaInterprete() {
		 if(!m.isFree()) {
			 Composicion t=seleccionar("Añadir..");
			 System.out.println("Añade el nombre del interprete");
			 t.agregarInterpretes(e.nextLine());
		 }else
			 System.out.println("No existe composicion");
	 }
	
	 
	 static void eliminarInterprete() {
		 if(!m.isFree()) {
			 Composicion aa=seleccionar("Se esta elimando");
			 System.out.println("Ingresa el nombre de interprete para proceder a elimanar por favor");
			 aa.EliminaInterprete(r.nextLine());
		 }else
			 System.out.println("No existe composicion");
	 }
	 
	 static void listado(){
			if(!m.isFree()) {
				System.out.println("-----Lista de Composiciones----");
				for(int i=0;i<m.getSize();i++)
					System.out.println(m.getItem(i));
			}	
			else
				System.out.println("No existen composiciones ");
	 }
	 
	 static void eliminarComposicion() throws ExcepcionBaja{
		 if(!m.isFree()) {
			 Composicion f=seleccionar("Borrando composicion....");
			 if(f.getInterpretes().equals(null)||f.getInterpretes().equals("")) {
				 if(m!=null) {
					 m.delete(f);
					 	System.out.println("Composicion elinada");
				 }else
					  throw new ExcepcionBaja ("Solo se pueden eliminar composiciones sin interpretes");
			 }
		 }
	 }
	 
	 static void grabaregistro() throws FileNotFoundException {
		  if(!m.isFree()) {
			  info01 = new EscritorArchivoTXT("Composiciones.txt");
			  for(int i=0;i<m.getSize();i++) {
				  info01.writeString(m.getItem(i).getTitulo());
				  info01.writeFloat(m.getItem(i).getDuracionmusic());
				  System.out.println("Nombre de la composicion"+m.getItem(i).getTitulo());
				  info01.writeString(m.getItem(i).getInterpretes());
				  info01.writeString(m.getItem(i).getGeneroMusical());
				  info01.writeString(m.getItem(i).getFechaDeRegistro().toString());
				  if(m.getItem(i).getFechaDeEstreno()==null)
					  info01.writeStringLn("Sin fecha de estreno");
				  else
				  info01.writeStringLn(m.getItem(i).getFechaDeEstreno().toString());
			  }
			  info01.close();
		  }
		  
	  }
	    
	 static void grabaregistroDat() throws IOException {
		  if(!m.isFree()) {
			  info03 = new RandomAccessFile("Composiciones.dat","rw");
			  for(int i=0;i<m.getSize();i++) {
				  info03.writeUTF(m.getItem(i).getTitulo());
				  info03.writeFloat(m.getItem(i).getDuracionmusic());
				  System.out.println("Nombre de la composicion"+m.getItem(i).getTitulo());
				  info03.writeUTF(m.getItem(i).getInterpretes());
				  info03.writeUTF(m.getItem(i).getFechaDeRegistro().toString());
				  if(m.getItem(i).getFechaDeEstreno()==null)
					  info03.writeUTF("Sin fecha de estreno \n");
				  else
				  info03.writeUTF(m.getItem(i).getFechaDeEstreno().toString()+"\n");
			  }
			}
	  }
	 
	 static void abrirArchivo() throws FileNotFoundException{
			info02= new LectorArchivoTXT("Composiciones.txt");
		}
	 
	
	

	private static void bajas()throws Exception{ 
		
	}

	private static void consultas()throws Exception{
		
		
	}
}