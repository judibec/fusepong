package fusePong.entities;

public class Stories {

    private int id;
    private String description;
    private int project;
    private String status;

    public Stories(){
        super();
    }

    public Stories(int id, String description, int project, String status){
        this.id = id;
        this.description = description;
        this.project = project;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
