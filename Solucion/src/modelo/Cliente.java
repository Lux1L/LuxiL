package modelo;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable{

	private int codigo;
	private String descripcion;
	private double monto;
	private String banco;
	private Date fecha;

	public Cliente(int codigo, String descripcion, double monto, String banco, Date fecha) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.monto = monto;
		this.banco = banco;
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}