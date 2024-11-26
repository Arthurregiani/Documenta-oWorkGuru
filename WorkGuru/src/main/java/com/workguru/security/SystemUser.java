package com.workguru.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.workguru.domain.model.Usuario;



public class SystemUser extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public SystemUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUser() {
		return usuario;
	}
	
}
