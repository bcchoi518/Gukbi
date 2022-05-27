package step01;


public class Screen extends Thread{
	public void run() {
		try {
		  System.out.println("          //////////     ///////     ////////////   ////////////  ");
		  sleep(200);
		  System.out.println("         ///                ///          ///                ///  ");
		  sleep(200);
		  System.out.println("        ///                ///          ///                ///");
		  sleep(200);
		  System.out.println("       //////////         ///          ///        ///////////");
		  sleep(200);
		  System.out.println("      ///                ///          ///                ///");
		  sleep(200);
		  System.out.println("     ///                ///          ///                ///");
		  sleep(200);
		  System.out.println("    //////////     ///////////  ////////////   ///////////");
		  System.out.println("\t\t  =================");
		  sleep(200);
			System.out.println("\t\t     ♬ WELCOME ♬");
			sleep(200);
			System.out.println("\t\t   영화관 E1I3 입니다.");
			sleep(200);
			System.out.println("\t\t  =================");
		}catch(InterruptedException e) {}
		
		
		}

}

