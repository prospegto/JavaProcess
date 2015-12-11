package es.iesvelazquez.prospegto.test;

class TestThread implements Runnable{

	private Thread t;

	private static int n = 0;
	private int n1, r;

	public Prueba2(int r){
		n++;
		n1 = n;
		this.r = r;
	}

	public void start(){
		if(t==null){
			t=new Thread(this);
			t.start();
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			t.sleep(r);
			System.out.println("corre"+n1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}

