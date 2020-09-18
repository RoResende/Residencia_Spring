package org.serratec.javabackend.projetofinal.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 5, max = 30)
	@Column(name="nome_completo", nullable = false, length=15)
	private String nomeCompleto;
	
	@NotNull
	@Size(min = 5, max = 15)
	@Column(name="nome_usuario", nullable = false, length=30)
	private String nomeUsuario;
	
	@NotNull
	@Size(min = 5, max = 11)
	@Column(name="cpf", nullable = false, length=11)
	private String cpf;
	
	@NotNull
	@Size(min = 10, max = 30)
	@Column(name="email", nullable = false, length=30)
	private String email;
	
	@NotNull
	@Size(min = 10, max = 30)
	@Column(name="endereco", nullable = false, length=30)
	private String endereco;
	
	/*@NotNull
	@Size(min = 10, max = 30)
	@Column(name="cidade", nullable = false, length=30)
	private String cidade;*/
	
	/*@NotNull
	@Size(min = 2, max = 2)
	@Column(name="uf", nullable = false, length=2)
	private String uf;*/
	
	@NotNull
	@Min(8)
	@Column(name="cep", nullable = false)
	private Integer cep;
	
	@NotNull
	@Column(name="data_nascimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/*public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}*/

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
