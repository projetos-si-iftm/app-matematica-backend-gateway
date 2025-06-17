// package br.edu.iftm.gateway_matematica.config;

// import java.util.Collection;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// public class DetalhesUsuarioPersonalizado implements UserDetails{
//     private final String nomeUsuario;
//     private final String senha;
//     private final String usuarioId;
//     private final String tipoUsuario;
//     private final Collection<? extends GrantedAuthority> authorities;   
    
//     public DetalhesUsuarioPersonalizado(String nomeUsuario, String senha, String usuarioId, String tipoUsuario, Collection<? extends GrantedAuthority> authorities) {
//         this.nomeUsuario = nomeUsuario;
//         this.senha = senha;
//         this.usuarioId = usuarioId;
//         this.tipoUsuario = tipoUsuario;
//         this.authorities = authorities;
//     }

    
//     public String getUsuarioId() {
//         return usuarioId;
//     }

//     public String getTipoUsuario() {
//         return tipoUsuario;
//     }
    
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return authorities;
//     }

    
//     @Override
//     public String getPassword() {
//         return senha;
//     }

//     @Override
//     public String getUsername() {
//         return nomeUsuario;
//     }

//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }

//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }

//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }
