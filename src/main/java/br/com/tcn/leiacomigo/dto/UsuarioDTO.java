package br.com.tcn.leiacomigo.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioDTO {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "nomeCompleto")
	private String nomeCompleto;

	@Column(name = "nomeUsuario")
	private String nomeUsuario;

	@Column(name = "senha")
	private String senha;

	@Column(name = "dataDeNascimento")
	private Date dataDeNascimento;
}
