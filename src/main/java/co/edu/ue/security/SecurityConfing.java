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

@EnableWebSecurity
@Configuration
public class SecurityConfing {
	
	@Bean
	public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users = List.of(
				User
				.withUsername("client")
				.password("{noop}123456")
				.roles("USERS")
				.build(),
				User
				.withUsername("admin")
				.password("{noop}654321")
				.roles("ADMINS")
				.build()
				);
		return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
			aut.requestMatchers(HttpMethod.POST, "/Usuario/crear", "/Peticion/crear-Peticion", "/Donacion/crear-Donacion", "/Envio/crear-Envio", "/Estado/crear-Estado", "/Categoria/crear-Estado").hasAnyRole("USERS", "ADMINS")
			//.requestMatchers(HttpMethod.DELETE,"/datos/").hasAnyRole("ADMINS","OTHER")
			.requestMatchers(HttpMethod.GET, "/Usuario/todos", "/Peticion/todos", "/Donacion/todos", "/Envio/todos", "/Estado/todos", "/Categoria/todos").authenticated()
			.requestMatchers(HttpMethod.GET, "/Usuario/id", "/Peticion/id", "/Donacion/id", "/Envio/id", "/Estado/id", "/Categoria/id").hasAnyRole("USERS", "ADMINS")	
			.requestMatchers(HttpMethod.GET, "/Usuario/correo").hasAnyRole("USERS","ADMINS")
			.requestMatchers(HttpMethod.GET, "/Peticion/idUsuario", "/Donacion/idUsuario",
			"/Donacion/idPeticion", "Envio/idUsuario", "Envio/idDonacion", "Envio/idPeticion").hasAnyRole("ADMINS")
			.requestMatchers(HttpMethod.PUT, "/Usuario/actualizar", "/Peticion/actualizar", 
			"/Donacion/actualizar", "/Envio/actualizar", "/Estado/actualizar", "/Categoria/actualizar").hasAnyRole("ADMINS")
			)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
	

		/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	http.csrf(cus->cus.disable()).authorizeHttpRequests(aut->
		aut.requestMatchers(HttpMethod.POST, "/datos").hasAnyRole("ADMINS")
		.requestMatchers(HttpMethod.GET,"/datos/*").authenticated()
		.requestMatchers(HttpMethod.GET,"/datos/*").authenticated()
		)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	//hello
	 * 
	 */
