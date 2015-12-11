package es.iesvelazquez.prospegto.participantes.consumidor;

import es.iesvelazquez.prospegto.monitor.MuroImpl;
import es.iesvelazquez.prospegto.participantes.Pintor;

public class Grafitero extends Pintor {
	
	
	//Properties
	private String apodo;
	private boolean vivo;

	
	//Constructors
	public Grafitero(MuroImpl m) {
		super(m);
		apodo = "Graffitero";
		vivo = true;
	}
	
	public Grafitero(MuroImpl m, String apodo) {
		super(m);
		if(apodo!=null && !apodo.equals("")){
			this.apodo = apodo;
		}else{
			this.apodo = "Graffitero";
		}
		vivo = true;
	}
	
	public Grafitero(MuroImpl m, String nombre, String apellidos, String apodo) {
		super(m);
		super.nombre = nombre;
		super.apellidos = apellidos;
		if(apodo!=null && !apodo.equals("")){
			this.apodo = apodo;
		}else{
			this.apodo = "Graffitero";
		}
		vivo = true;
	}
	
	@Override
	public void run() {
		int iteraciones = 5000;
		for(int j=0; j<iteraciones; j++){
			boolean pinta = false;
			for(int i=0; i<this.getMuro().getPaneles().length;i++){
				synchronized (this.getMuro()) {
					if(this.getMuro().estadoPanel(i)){
						this.getMuro().pintarraquearPanel(i);
						System.out.println("El pintor '"+this.getNombre()+" "+this.getApellidos()+"' ('"+this.getApodo()+"') " 
						+"ha pintado el panel numero: "+i);
						pinta = true;
						break;
					}	
				}				
			}
			if(!pinta){
				System.out.println("El graffitero '"+this.getNombre()+" "+this.getApellidos()+"' " +
						"se sorprendió "+"¡Estaba todo pintarraqueado!");
			}
			try {
				System.out.println("El graffitero '"+this.getNombre()+" "+this.getApellidos()+"' ('"+this.getApodo()+"')" +
						" se va dormir.");
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	
	
	

}
