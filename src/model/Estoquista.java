package model;

import controller.Help;

public class Estoquista {

	private int privilegio;
	private String cpf;
	private String nome;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	private String senha;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}

	public void adicionarProduto(Produto p) {
		Help.lista_produtos.add(p);
	}

	public void excluirProduto(String cod_barras) {
		for(Produto p : Help.lista_produtos) {
			if(p.getCod_barras().equals(cod_barras)) {
				Help.lista_produtos.remove(p);
				return;
			}
		}
	}

	public void alterarProduto(Produto p) {

	}

	public void visualizarEstoque() {

	}
}
