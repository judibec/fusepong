package fusePong.entities;

public class Company {
    private String name;
    private int nit;
    private int number;
    private String address;
    private String email;

    public Company(){
        super();
    }

    public Company(String name, int nit, int number, String address, String email){
        this.name=name;
        this.nit=nit;
        this.number=number;
        this.address=address;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
