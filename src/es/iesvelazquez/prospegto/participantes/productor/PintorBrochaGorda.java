package es.iesvelazquez.prospegto.participantes.productor;

import es.iesvelazquez.prospegto.monitor.MuroImpl;
import es.iesvelazquez.prospegto.participantes.Pintor;

public class PintorBrochaGorda extends Pintor {
	
	private int gramosPintura;
	private int gramosPinturaRestante;
	private boolean vivo;

	public PintorBrochaGorda(MuroImpl m) {
		super(m);
		gramosPintura = 15;
		gramosPinturaRestante = gramosPintura;
		vivo = true;
	}
	
	public PintorBrochaGorda(MuroImpl m, int gramosPintura) {
		super(m);
		if(gramosPintura>0){
			this.gramosPintura = gramosPintura;
		}else{
			this.gramosPintura = 15;
			System.out.println("Gramos de pintura inválido. Cambiado a "+ this.gramosPintura +" por defecto.");
		}
		gramosPinturaRestante = this.gramosPintura;
		vivo = true;
	}

	public PintorBrochaGorda(MuroImpl m, String nombre, String apellidos, int gramosPintura) {
		super(m);
		super.nombre = nombre;
		super.apellidos = apellidos;
		if(gramosPintura>0){
			this.gramosPintura = gramosPintura;
		}else{
			this.gramosPintura = 15;
			System.out.println("Gramos de pintura inválido. Cambiado a "+ this.gramosPintura +" por defecto.");
		}
		gramosPinturaRestante = this.gramosPintura;
		vivo = true;
	}
	

	@Override
	public void run() {
		
		while(this.isVivo()){
			if(gramosPinturaRestante>this.getMuro().getPinturaPorPanel()){
				boolean pinta = false;
				for(int i=0; i<this.getMuro().getPaneles().length;i++){
					synchronized (this.getMuro()) {
						if(!this.getMuro().estadoPanel(i)){
							this.getMuro().pintaPanel(i);
							gramosPinturaRestante = (gramosPinturaRestante-this.getMuro().getPinturaPorPanel());
							System.out.println("El pintor '"+this.getNombre()+" "+this.getApellidos()+"' " +
									"ha pintado el panel numero: "+i);
							pinta = true;
							break;
						}
					}					
				}
				if(!pinta){
					System.out.println("El pintor '"+this.getNombre()+" "+this.getApellidos()+"' " +
							"se sorprendió "+"¡Estaba todo bien!");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				try {
					gramosPinturaRestante = this.getGramosPintura();
					System.out.println("El pintor '"+this.getNombre()+" "+this.getApellidos()+"' " +
							"se ha quedado sin pintura, necesita recargar.");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public int getGramosPintura() {
		return gramosPintura;
	}

	public void setGramosPintura(int gramosPintura) {
		this.gramosPintura = gramosPintura;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

}
