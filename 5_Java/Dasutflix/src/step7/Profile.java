package step7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Profile implements Serializable {
	final int FAVORITE_MAX = 3;
	private String nickname;
	private boolean isActive;
	Configuration config;
	HashSet<String> favorite = new HashSet<String>(FAVORITE_MAX);
	ArrayList<Movie> myList = new ArrayList<Movie>();

	public Profile() {
	}

	public Profile(String nickname) {
		this.nickname = nickname;
		config = new Configuration();
	}

	public String getNickname() {
		return nickname;
	}// end getNickname

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}// end setNickname

	public boolean isActive() {
		return isActive;
	}// end isActive

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}// end setActive

	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}// end hashCode

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profile) {
			Profile pf = (Profile) obj;
			return nickname.equals(pf.nickname);
		} // end equals
		return false;
	}// end equals

	@Override
	public String toString() {
		return "Nickname: " + nickname + "(" + (isActive ? "Activate" : "Deactivate") + ")" + "  Favorite: " + favorite
				+ "  MyList: " + myList;
	}// end toString
	
	void loadMyList() {
		File dataFile = new File(getNickname()+"_myList.dat");
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end if
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(getNickname()+"_myList.dat");
			in = new ObjectInputStream(fis);
			myList = (ArrayList<Movie>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				} // end if
				if (fis != null) {
					fis.close();
				} // end if
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end loadMyList
	
	void saveMyList() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(getNickname()+"_myList.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(myList);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				} // end if
				if (fos != null) {
					fos.close();
				} // end if
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end saveMyList
	
	void loadFavorite() {
		File dataFile = new File(getNickname()+"_favorite.dat");
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end if
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(getNickname()+"_favorite.dat");
			in = new ObjectInputStream(fis);
			favorite = (HashSet<String>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				} // end if
				if (fis != null) {
					fis.close();
				} // end if
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end loadFavorite
	
	void saveFavorite() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(getNickname()+"_favorite.dat");
			out = new ObjectOutputStream(fos);
			out.writeObject(favorite);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				} // end if
				if (fos != null) {
					fos.close();
				} // end if
			} catch (IOException e) {
				e.printStackTrace();
			} // end try-catch
		} // end try-catch-finally
	}// end saveFavorite
}// end Profile
