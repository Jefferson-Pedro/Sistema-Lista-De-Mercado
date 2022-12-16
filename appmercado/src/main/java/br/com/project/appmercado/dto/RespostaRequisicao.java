package br.com.project.appmercado.dto;

public class RespostaRequisicao {
	private String eventMessage;
	

	public RespostaRequisicao(String eventMessage) {
		this.eventMessage = eventMessage;
	}

	public String getEventMessage() {
		return eventMessage;
	}

	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}
	
	
}
