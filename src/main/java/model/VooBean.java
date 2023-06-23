package model;

public class VooBean {
	private String idvoo;
	private String origem;
	private String destino;
	private String data;
	
	public VooBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public VooBean(String idvoo, String origem, String destino, String data) {
		super();
		this.idvoo = idvoo;
		this.origem = origem;
		this.destino = destino;
		this.data = data;
	}
	
	public String getIdvoo() {
		return idvoo;
	}
	public void setIdvoo(String idvoo) {
		this.idvoo = idvoo;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "VooBean [idvoo=" + idvoo + ", origem=" + origem + ", destino=" + destino + ", data=" + data + "]";
	}
}
