package Clases.ito.poo;

import interfaces.ito.poo.Arreglo;



public class Composiciones implements Arreglo<Composicion> {
	private Composicion Compo[]=null;
	private  int ultimo=0;
	private final int INC=5;
	
	public Composiciones() {
		super();
		this.Compo = new Composicion[INC];
		this.ultimo = -1;
	}
	private void crecerArreglo() {
		Composicion temporal[]=new Composicion[this.Compo.length+INC];
    for(int i=0;i<this.Compo.length;i++)	
    Compo=temporal;
    }
	
	public boolean addItem(Composicion item) {
		
		boolean bandera=false;
		if(!existeIte(item)) {
			if(isFull())
				crecerArreglo();
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(Compo[i])<0) {
					break;
				}
			for(int j=this.ultimo;j>=i;j--)
				Compo[j+1]=Compo[j];
			Compo[i]=item;
			this.ultimo++;
			bandera=true;
			}
		return bandera;
	}


	
	public boolean existeIte(Composicion item) {
		
		boolean existe=false;
		for(int i=0;i<=this.ultimo;i++)
			if(item.compareTo(Compo[i])==0) {
				existe=true;
				break;
			}
		return existe;
	}

	
	public Composicion getItem(int pos) {
		
		Composicion cb=null;
		if(!this.isFree()&& pos<=this.ultimo)
			cb=Compo[pos];
		return cb;
	}

	
	public int getSize() {
		return this.ultimo+1;
	}

	
	public boolean delete(Composicion item) {
		
		boolean delete=false;
		if(this.existeIte(item)) {
			int i=0;
			for(;i<=this.ultimo;i++)
				if(item.compareTo(Compo[i])==0)
					break;
			for(;i<this.ultimo;i++)
				Compo[i]=Compo[i+1];
			this.ultimo--;
			delete=true;
		}
		return delete;
	}

	
	public boolean isFree() {
		
		return this.ultimo==-1;
	}

	
	public boolean isFull() {
		
		return this.ultimo+1==this.Compo.length;
	}
	public Composicion[] getTitulo() {
		return Compo;
	}
	public void setTitulo(Composicion[] titulo) {
		this.Compo = titulo;
	}
	public int getUltimo() {
		return ultimo;
	}
	public void setUltimo(int ultimo) {
		this.ultimo = ultimo;
	}
	public int getINC() {
		return INC;
	}
	
	public boolean existeItem(Composicion item) {
		
		return false;
	}
	
	public boolean clear(Composicion item) {
	
		return false;
	}
}

	