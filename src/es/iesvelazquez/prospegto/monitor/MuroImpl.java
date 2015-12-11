package es.iesvelazquez.prospegto.monitor;

public class MuroImpl implements Muro{
	
	
	//Propperties
	private int longitud;
	private boolean[] paneles;
	private int pinturaPorPanel;
	
	
	//Empty constructor
	public MuroImpl(){
		longitud = 10;
		paneles = new boolean[this.longitud];
		for(int i=0; i<paneles.length;i++){
			paneles[i] = false;
		}
		pinturaPorPanel = 5;
		
	}
	
	
	public MuroImpl(int longitud, int pinturaPorPanel){
		if(longitud>0){
			this.longitud = longitud;
		}else{			
			this.longitud = 10;
			System.out.println("Longitud inválida, establecida a "+this.longitud+" por defecto");
		}
		this.paneles = new boolean[this.longitud];
		for(int i=0; i<this.paneles.length;i++){
			this.paneles[i] = false;
		}
		if(pinturaPorPanel>0){
			this.pinturaPorPanel = pinturaPorPanel;
		}else{			
			this.pinturaPorPanel = 5;
			System.out.println("Pintura por panel inválida, establecida a "+this.pinturaPorPanel+" por defecto");
		}
	}
	
	
	@Override
	public boolean estadoPanel(int n) {
		return paneles[n];
	}

	@Override
	public void pintarraquearPanel(int n) {
		paneles[n] = false;
		
	}

	@Override
	public void pintaPanel(int n) {
		paneles[n] = true;		
	}
	

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public boolean[] getPaneles() {
		return paneles;
	}

	public void setPaneles(boolean[] paneles) {
		this.paneles = paneles;
	}

	public int getPinturaPorPanel() {
		return pinturaPorPanel;
	}

	public void setPinturaPorPanel(int pinturaPorPanel) {
		this.pinturaPorPanel = pinturaPorPanel;
	}
	
	
	
	
	

}
