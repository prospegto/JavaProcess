package es.iesvelazquez.prospegto.test;

import es.iesvelazquez.prospegto.monitor.MuroImpl;
import es.iesvelazquez.prospegto.participantes.consumidor.Grafitero;
import es.iesvelazquez.prospegto.participantes.productor.PintorBrochaGorda;

public class Conductor {

	public static void main(String[] args) {
		
		//Create the wall
		MuroImpl muro = new MuroImpl(20, 5);
		
		//Create the painter
		PintorBrochaGorda pintorBueno = new PintorBrochaGorda(muro, "Pepe", "de los Palotes", 15);
		
		//Create graffity
		Grafitero grafitero1 = new Grafitero(muro, "Ramón", "García", "Grand Prix");
		Grafitero grafitero2 = new Grafitero(muro, "María", "de la Concepción", "Jamona");
		
		//Run threads
		pintorBueno.start();
		grafitero1.start();
		grafitero2.start();
		
		//Stop painter
		// pintorBueno.stop();

	}

}
