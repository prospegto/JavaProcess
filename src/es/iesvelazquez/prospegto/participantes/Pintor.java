package es.iesvelazquez.prospegto.participantes;

import es.iesvelazquez.prospegto.monitor.*;

public abstract class Pintor implements Runnable {

	//Properties
	Thread t;

	protected String nombre, apellidos;
	protected MuroImpl muro;

	public Pintor(MuroImpl m){
		muro = m;
		nombre = "Nombre";
		apellidos = "Apellidos";
	}


	public void start(){
		if(t==null){
			t=new Thread(this);
			t.start();
		}
	}

	public void stop(){
		if(t!=null){
			t.stop();
			t=null;
		}
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public MuroImpl getMuro() {
		return muro;
	}

	public void setMuro(MuroImpl muro) {
		this.muro = muro;
	}




}
