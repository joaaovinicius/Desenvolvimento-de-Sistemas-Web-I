package org.libertas.bd;

public class Jogos {
	private int id;
	private String nome;
	private String plataforma;
	private String lancamento;
	private String modoonline;
	private String quantidadejogadores;

	
	
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLancamento() {
		return lancamento;
	}
	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}
	
	public String getModoonline() {
		return modoonline;
	}
	public void setModoonline(String modoonline) {
		this.modoonline = modoonline;
	}
	public String getQuantidadejogadores() {
		return quantidadejogadores;
	}
	public void setQuantidadejogadores(String quantidadejogadores) {
		this.quantidadejogadores = quantidadejogadores;
	}
	
	

}
