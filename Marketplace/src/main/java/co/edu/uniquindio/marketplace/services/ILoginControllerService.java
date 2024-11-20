package co.edu.uniquindio.marketplace.services;

import co.edu.uniquindio.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.model.Usuario;

/**
 * Interfaz para el servicio de verificación de inicio de sesión.
 */
public interface ILoginControllerService {

    /**
     * Verifica las credenciales del usuario para el inicio de sesión.
     *
     * @param usuario El objeto que contiene los datos del usuario a verificar.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
    boolean verificarLogin(UsuarioDto usuario);
}
