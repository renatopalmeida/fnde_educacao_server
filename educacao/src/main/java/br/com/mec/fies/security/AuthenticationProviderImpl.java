package br.com.mec.fies.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.annotation.Transactional;

import br.com.fnde.educacao.dao.UsuarioDAO;
import br.com.fnde.educacao.domain.Usuario;

public class AuthenticationProviderImpl implements AuthenticationProvider  {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Transactional
	public Authentication authenticate(Authentication auth)	throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
		String username = token.getName();
		String senha    = token.getCredentials() != null ? token.getCredentials().toString() : null;
		
		Usuario usuario = getUsuarioDAO().getUsuario(username, senha);
		
		if (usuario == null) {
			return null;
		}
		
//		TODO
//		List<PermissaoUsuario> permissoes = getDaoPermissao().getPermissoesUsuario(usuario);
//		SFAuthentication resultado = new SFAuthentication(usuario, permissoes);
		
		List<PermissaoUsuario> permissoes = new ArrayList<PermissaoUsuario>();
		PermissaoUsuario permissaoUsuario = new PermissaoUsuario();
		permissaoUsuario.setId(1);
		permissaoUsuario.setRole("ROLE_MEMBRO");
		permissoes.add(permissaoUsuario);
		
		AuthenticationOutline resultado = new AuthenticationOutline(usuario, permissoes);
		resultado.setAuthenticated(usuario != null);
		
		return resultado;
	}

	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
}
