package com.ayd.aulas.config;

import com.ayd.aulas.entity.DocenteEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

/**
 * El filtro de inicio de sesión de usuario, en el filtro de inicio de sesión de usuario, verifica si el inicio de sesión del usuario es exitoso,
 * Si el inicio de sesión es exitoso, se generará un token y se devolverá al cliente, y si el inicio de sesión falla, se enviará un mensaje de error de inicio de sesión a la interfaz.
 **/
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {


    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
    }

    // Verificación automática
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        DocenteEntity user = new ObjectMapper().readValue(request.getInputStream(), DocenteEntity.class);
    // Extraiga el nombre de usuario y la contraseña de los parámetros de inicio de sesión y luego llame al método AuthenticationManager.authenticate () para la verificación automática.
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    // La verificación es exitosa
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        StringBuffer as = new StringBuffer();
        // Recorre los roles de los usuarios y los conecta con un,
        for (GrantedAuthority authority : authorities) {
            as.append(authority.getAuthority()).append(",");
        }
        // Luego usa Jwts para generar el token Según el orden del código, se configuran un total de cuatro parámetros en el proceso de generación.
        // Respectivamente rol de usuario, asunto, tiempo de vencimiento, algoritmo de cifrado y clave,
        String jwt = Jwts.builder()
                .claim("authorities",as)
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis()+10*60*1000))
                .signWith(SignatureAlgorithm.HS512,"wuweijie")
                .compact();
        // Luego escribe el token generado al cliente
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(jwt));
        writer.flush();
        writer.close();
    }

    //Fallo en la verificación
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("¡Error de inicio de sesion!");
        writer.flush();
        writer.close();
    }
}

