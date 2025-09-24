package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

import model.Hotel;

public class Main implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Hotel libr;

	public static void main(String[] args) {
		try {
			Hotel lib = loadingLibr();
			if (lib == null) {
				System.out.print("Null");
				lib = Hotel.getInstance();
			}
			System.out.println(lib);

			libr = lib;
			LoginPage login = new LoginPage();
			login.showWindow();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		} catch (IOException eio) {
			JOptionPane.showMessageDialog(null, eio.getMessage());
		}

	}

	public static void save() throws IOException {
		String fileName = "Hotel.ser";
		try (FileOutputStream fileOut = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(libr);
			System.out.println("Hotel object has been serialized and saved to " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static Hotel loadingLibr() throws IOException {
		String fileName = "Hotel.ser";
		Hotel hotel = null;

		try (FileInputStream fileIn = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			hotel = (Hotel) in.readObject();
			System.out.println("Hotel object has been deserialized from " + fileName);
		} catch (FileNotFoundException e) {
			// File not found. It's okay, we'll create a new instance of Hotel later.
			return null;
		} catch (IOException | ClassNotFoundException e) {
			// File not found. It's okay, we'll create a new instance of Hotel later.
			return null;
		}

		return hotel;
	}

}
