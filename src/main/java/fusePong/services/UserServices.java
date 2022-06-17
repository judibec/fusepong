package fusePong.services;

public interface UserServices {

    public boolean isAdmin();

    public String getEmail() throws ServicesException;

    public void registrarUsuario(String name, String email, String password, int company);
}
