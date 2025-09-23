package co.edu.ue.security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfing {

	@Bean
	public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users = List.of(
				User
						.withUsername("client")
						.password("{noop}123456")
						.roles("USER")
						.build(),
				User
						.withUsername("admin")
						.password("{noop}654321")
						.roles("ADMIN")
						.build());
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{		
		http.csrf(cus->cus.disable())
		.cors(Customizer.withDefaults())
		.authorizeHttpRequests(aut->
			aut.requestMatchers(HttpMethod.POST, "/Usuario/crear", "/Peticion/crear-Peticion", "/Donacion/crear-Donacion", "/Envio/crear-Envio", "/Estado/crear-Estado", "/Categoria/crear-Estado").hasAnyRole("USER", "ADMIN")
			//.requestMatchers(HttpMethod.DELETE,"/datos/").hasAnyRole("ADMINS","OTHER")
			.requestMatchers(HttpMethod.GET, "/Usuario/todos", "/Peticion/todos", "/Donacion/todos", "/Envio/todos", "/Estado/todos", "/Categoria/todos").permitAll()
			.requestMatchers(HttpMethod.GET, "/Usuario/id", "/Peticion/id", "/Donacion/id", "/Envio/id", "/Estado/id", "/Categoria/id").hasAnyRole("USER", "ADMIN")	
			.requestMatchers(HttpMethod.GET, "/Usuario/correo").hasAnyRole("USER","ADMIN")
			.requestMatchers(HttpMethod.GET, "/Peticion/idUsuario", "/Donacion/idUsuario",
			"/Donacion/idPeticion", "Envio/idUsuario", "Envio/idDonacion", "Envio/idPeticion").hasAnyRole("USER", "ADMIN")
			.requestMatchers(HttpMethod.PUT, "/Usuario/actualizar", "/Peticion/actualizar", 
			"/Donacion/actualizar", "/Envio/actualizar", "/Estado/actualizar", "/Categoria/actualizar").permitAll()
		)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:5500"));
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
