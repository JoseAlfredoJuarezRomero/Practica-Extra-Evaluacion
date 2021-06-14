package MyApp.ito.clases;

import java.awt.HeadlessException;



import java.io.FileNotFoundException;

import Clases.ito.poo.EscritorArchivoTXT;
import Clases.ito.poo.LectorArchivoTXT;
import Clases.ito.poo.Composicion;

import java.util.ArrayList;


public class MyApp {
	
	static Composicion c=new Composicion(null, null, null, null, null);
	static EscritorArchivoTXT archivo;
	static LectorArchivoTXT archivo2;
	
	static void run() throws Exception {
		
		Aplicacion.menu();
		   
			
    }
	
	
	static void crearArchivo() throws FileNotFoundException {
		archivo = new EscritorArchivoTXT("composiciones.txt");
	}


	
	public static void main(String[] args) throws Exception{
	
			run();
			
			
	}
	
}
	