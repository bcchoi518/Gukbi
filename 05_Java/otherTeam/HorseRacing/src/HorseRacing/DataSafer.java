package HorseRacing;

public class DataSafer extends Thread {

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10000);
				Saver.saveAccounts();
				Saver.saveHorse();
				Saver.saveSeat();
			}
			catch(Exception e) {e.printStackTrace();}
		}
	}

}
