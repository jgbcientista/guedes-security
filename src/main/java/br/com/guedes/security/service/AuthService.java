package br.com.guedes.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.guedes.security.dto.TokenDto;
import br.com.guedes.security.dto.LoginRequestDto;
import br.com.guedes.security.dto.RegisterRequestDto;
import br.com.guedes.security.model.Role;
import br.com.guedes.security.model.Usuario;
import br.com.guedes.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UsuarioRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public TokenDto login(LoginRequestDto request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getSenha()));

		var user = userRepository.findByLogin(request.getLogin()).orElseThrow();

		var jwt = jwtService.generateToken(user);

		return TokenDto.builder().token(jwt).build();
	}

	public TokenDto register(RegisterRequestDto request) {
		var user = Usuario
				.builder()
				.nome(request.getNome())
				.senha(passwordEncoder.encode(request.getSenha()))
				.login(request.getLogin())
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		var jwt = jwtService.generateToken(user);
		
		return TokenDto.builder().token(jwt).build();
	}
}
