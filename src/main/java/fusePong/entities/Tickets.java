package fusePong.entities;

public class Tickets {

    private int id;
    private String description;
    private int story;
    private String status;
    private String comments;
    private Stories stories;

    public Tickets(){
        super();
    }

    public Tickets(int id, String description, int story, String status, String comments){
        this.id = id;
        this.description = description;
        this.story = story;
        this.status = status;
        this.comments = comments;
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

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }
}
