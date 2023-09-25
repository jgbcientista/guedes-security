package br.com.guedes.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

	@NotBlank
	@Size(min = 6, max = 100)
	private String nome;

	@NotBlank
	@Size(min = 4, max = 20)
	private String login;

	@NotBlank
	@Size(min = 6, max = 100)
	private String senha;
}
