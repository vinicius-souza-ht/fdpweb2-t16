package br.com.fabricadeprogramador.controller;


import br.com.fabricadeprogramador.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.model.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by viniciuspodi on 20/10/17.
 */
@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
    private UsuarioService usuarioService;

	@PostMapping
    public void autenticar(@RequestBody Usuario usuario, HttpServletResponse response) throws ServiceException{
		Usuario usuarioAutenticado = usuarioService.autenticar(usuario).get(0);
        
		
        if(usuarioAutenticado != null) {
        	System.out.println("USUARIO AUTENTICADO");
            String token = TokenUtils.criarToken(usuario);

            try {
				response.getWriter().print(token);
			} catch (IOException e) {
				e.printStackTrace();
			}

        }else {
        	System.out.println("USUARIO NAO AUTENTICADO");
        	response.setStatus(401);
        }
    }
    
}
