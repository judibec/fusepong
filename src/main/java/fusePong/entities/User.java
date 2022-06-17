package fusePong.entities;

public class User {
    private String name;
    private String email;
    private String password;
    private char role;
    private int id;
    private Integer company;

    public User() {
        super();
    }

    public User(int id, String name, String email, String password, char role, Integer company) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.id = id;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }
}
