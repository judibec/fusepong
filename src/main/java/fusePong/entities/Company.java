package fusePong.entities;

public class Company {
    private String name;
    private Integer nit;
    private int number;
    private String address;
    private String email;

    public Company(){
        super();
    }

    public Company(String name, Integer nit, int number, String address, String email){
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

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
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

    @Override
    public String toString(){
        return "Company{" +
                "name=" + name +
                ", nit='" + nit + '\'' +
                ", number=" + number + '\'' +
                ", address='" + address + '\'' +
                ", email=" + email + '\'' +
                '}';
    }
}
