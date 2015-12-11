package es.iesvelazquez.prospegto.test;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prueba2 p = new Prueba2((int) (Math.random()*10000));
		Prueba2 p2 = new Prueba2((int) (Math.random()*1000));
		Prueba2 p3 = new Prueba2((int) (Math.random()*10));
		Prueba2 p4 = new Prueba2((int) (Math.random()*10000));
		
		p.start();
		p2.start();
		p3.start();
		p4.start();

		
	}

	



}
