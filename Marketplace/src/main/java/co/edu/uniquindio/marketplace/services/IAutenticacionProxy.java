package co.edu.uniquindio.marketplace.services;


import co.edu.uniquindio.marketplace.mapping.dto.UsuarioDto;

public interface IAutenticacionProxy {
    boolean autenticar(UsuarioDto usuarioDto);
}
