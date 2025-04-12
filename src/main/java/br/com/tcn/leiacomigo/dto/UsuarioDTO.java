package br.com.tcn.leiacomigo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String email;
	private String nomeCompleto;
	private String nomeUsuario;
	private String senha;
	private Date dataDeNascimento;
}
