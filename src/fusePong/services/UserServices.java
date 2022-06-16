package fusePong.services;

public interface UserServices {

    public boolean isAdmin();

    public String getEmail() throws ServicesException;
}
