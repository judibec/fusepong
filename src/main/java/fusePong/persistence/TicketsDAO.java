package fusePong.persistence;

import fusePong.entities.Stories;
import fusePong.entities.Tickets;

import java.util.List;

public interface TicketsDAO {

    public List<Tickets> getStoriesTicket(int storyId);

    public void deletedTicket(int ticketId);

    public void editedTicket(int ticketId, String estado);

    public void registerTicket(String descripcion, int storyId, String estado, String comentario);
}
