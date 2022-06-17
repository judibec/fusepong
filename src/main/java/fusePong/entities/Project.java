package fusePong.entities;

public class Project {

    private int id;
    private String name;
    private int company;
    private Company companyName;

    public Project(){
        super();
    }

    public Project(int id, String name, int company){
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString(){
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company + '\'' +
                '}';
    }
}
