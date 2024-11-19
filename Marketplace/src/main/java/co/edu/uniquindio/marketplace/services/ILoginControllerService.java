package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.model.Usuario;

public interface ILoginControllerService {
    boolean verificarLogin(UsuarioDto usuario);
}
