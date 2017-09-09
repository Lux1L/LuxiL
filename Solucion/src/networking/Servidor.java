package networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

import modelo.Cliente;
import modelo.Datos;

public class Servidor {

	private int puerto;
	private boolean estado;
	private ServerSocket serverSocket;

	public Servidor(int puerto) throws IOException {
		this.puerto = puerto;
		this.serverSocket = new ServerSocket(puerto);
		System.err.println("Puerto : " + this.puerto);
	}

	public void IniciarServidor() {
		this.estado = true;

		while (this.estado) {
			try {

				Socket connecion = this.serverSocket.accept();
				InputStream flujoEntrada = connecion.getInputStream();

				ObjectInputStream lectorObject = new ObjectInputStream(flujoEntrada);

				Object objecdatos = lectorObject.readObject();

				Datos x = (Datos) objecdatos;

				String comillas = null;
				int cont1 = 0;
				int cont2 = 1;

				for (Cliente c : x.getClienteArray()) {

					cont1++;
				}

				System.err.println("Numero de Tansaciones recibidas " + (cont1++) + "\n");

				SimpleDateFormat smp = new SimpleDateFormat("dd-MM-yyyy");

				for (Cliente a : x.getClienteArray()) {

					if (a.getMonto() > 10 && a.getMonto() < 99) {
						comillas = "*";
					} else if (a.getMonto() > 100 && a.getMonto() < 999) {
						comillas = "**";
					} else if (a.getMonto() > 1000 && a.getMonto() < 9999) {
						comillas = "***";
					}

					System.err.println("Transaccion 00" + (cont2++) + "-" + a.getBanco() + ":" + a.getDescripcion()
							+ ":" + a.getMonto() + "soles :" + smp.format(a.getFecha()) + comillas);
				}

				lectorObject.close();
				flujoEntrada.close();
				connecion.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
