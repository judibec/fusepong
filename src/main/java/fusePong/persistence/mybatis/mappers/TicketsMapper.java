package fusePong.persistence.mybatis.mappers;

import fusePong.entities.Tickets;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TicketsMapper {

    public List<Tickets> getStoriesTicket(@Param("storyId") int storyId);

    public void deletedTicket(@Param("ticketId") int ticketId);

    public void editedTicket(@Param("ticketId") int ticketId, @Param("estado") String estado);

    public void registerTicket(@Param("descripcion") String descripcion, @Param("storyId") int storyId, @Param("estado") String estado, @Param("comentario") String comentario);
}
