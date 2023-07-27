package br.com.dawal.dto;

public class ChamadaBEDTO {
	
	private String url;
	
	private String acao;
	
	private Object objetoPOST;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Object getObjetoPOST() {
		return objetoPOST;
	}

	public void setObjetoPOST(Object objetoPOST) {
		this.objetoPOST = objetoPOST;
	}
	

}
