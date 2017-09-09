package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Datos implements Serializable{

	private int id;
	private ArrayList<Cliente> ClienteArray;

	public Datos(int id, ArrayList<Cliente> clienteArray) {
		super();
		this.id = id;
		ClienteArray = clienteArray;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Cliente> getClienteArray() {
		return ClienteArray;
	}

	public void setClienteArray(ArrayList<Cliente> clienteArray) {
		ClienteArray = clienteArray;
	}
}