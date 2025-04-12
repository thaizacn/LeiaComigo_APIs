package br.com.tcn.leiacomigo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "usuario", schema = "leiacomigo")
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long idUsuario;

	@Column(name = "email")
	private String email;

	@Column(name = "nomeCompleto")
	private String nomeCompleto;

	@Column(name = "nomeUsuario", unique = true)
	private String nomeUsuario;

	@Column(name = "senha")
	private String senha;

	@Column(name = "dataDeNascimento")
	private Date dataDeNascimento;

}
