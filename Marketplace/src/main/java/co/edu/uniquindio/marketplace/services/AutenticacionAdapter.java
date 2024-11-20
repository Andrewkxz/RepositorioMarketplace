package co.edu.uniquindio.marketplace.services;


public class AutenticacionBaseDeDatosAdapter implements AutenticacionAdapter {

    private BaseDeDatos baseDeDatos; // Representa el sistema de base de datos

    public AutenticacionBaseDeDatosAdapter(BaseDeDatos baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    @Override
    public boolean autenticar(String usuario, String contrasenia) {
        // Verifica las credenciales en la base de datos
        return baseDeDatos.verificarCredenciales(usuario, contrasenia);
    }
}
