package step8;

import java.io.Serializable;

public class Admin extends User implements Serializable {
	Admin() {
		super("admin", "0000", 0);
		super.setOnline(true);
	}
}// end Admin
