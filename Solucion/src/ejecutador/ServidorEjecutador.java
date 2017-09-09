package ejecutador;

import java.io.IOException;

import networking.Servidor;

public class ServidorEjecutador {

	public static void main(String[] args) {

		try {
			Servidor servidor = new Servidor(12);
			servidor.IniciarServidor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
