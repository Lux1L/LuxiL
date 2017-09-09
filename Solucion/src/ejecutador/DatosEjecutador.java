package ejecutador;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import modelo.Cliente;
import modelo.Datos;

public class DatosEjecutador {
	
	public static void main(String[] args) {
		
		String host = "localhost";
		int puerto = 12;
		
		ArrayList<Cliente> list = new ArrayList<>();
		
		list.add(new Cliente(1, "Deposito1", 110, "BCP", new Date()));
		list.add(new Cliente(2, "Deposito2", 1010, "interbank", new Date()));
		list.add(new Cliente(3, "Deposito3", 11, "BCP", new Date()));
		list.add(new Cliente(4, "Deposito4", 50, "continnetal", new Date()));
		list.add(new Cliente(5, "Deposito5", 1112, "BCP", new Date()));
		
		try {
			
			Socket socket = new Socket(host, puerto);
			
			ObjectOutputStream escritorObject = new ObjectOutputStream(socket.getOutputStream());
			
			escritorObject.writeObject(new Datos(1, list));
			
			escritorObject.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
