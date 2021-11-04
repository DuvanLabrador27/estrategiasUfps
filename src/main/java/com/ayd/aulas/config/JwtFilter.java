package com.ayd.aulas.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Cuando se envían otras solicitudes, verifique el filtro de token, si la verificación es exitosa, deje que la solicitud continúe
 **/

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // Primero extrae el campo de autorización del encabezado de la solicitud. El valor correspondiente a este campo es el token del usuario.
        String jwtToken = request.getHeader("authorization");
        System.out.println("authorities:"+jwtToken);
        // Convierta la cadena de token extraída en un objeto Claims,
        Claims claims = Jwts.parser()
                .setSigningKey("wuweijie")
                .parseClaimsJws(jwtToken.replace("Bearer",""))
                .getBody();
        // Extraiga el nombre de usuario actual y el rol de usuario del objeto Claims,
        String username = claims.getSubject();
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
        // Cree un UsernamePasswordAuthenticationToken y colóquelo en el contexto actual,
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(token);
        // Luego ejecuta la cadena de filtros para continuar con la solicitud
        filterChain.doFilter(request,servletResponse);

    }
}

