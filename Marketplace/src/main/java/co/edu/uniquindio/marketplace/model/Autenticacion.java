package co.edu.uniquindio.marketplace.model;

import co.edu.uniquindio.marketplace.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplace.services.IAutenticacionProxy;

import java.util.ArrayList;
import java.util.List;

public class Autenticacion implements IAutenticacionProxy {
    private List<Vendedor> vendedores;

    public Autenticacion(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    @Override
    public boolean autenticar(UsuarioDto usuarioDto) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getUsuario().getUsuario().equals(usuarioDto.usuario()) &&
                    vendedor.getUsuario().getContrasenia().equals(usuarioDto.contrasenia())){
                return true;
            }
        }
        return false;
    }
}
