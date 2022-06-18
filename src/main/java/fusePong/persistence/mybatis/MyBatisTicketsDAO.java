package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.entities.Tickets;
import fusePong.persistence.TicketsDAO;
import fusePong.persistence.mybatis.mappers.TicketsMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisTicketsDAO implements TicketsDAO {

    @Inject
    private TicketsMapper ticketsMapper;

    @Override
    public List<Tickets> getStoriesTicket(int storyId) {
        try{
            return ticketsMapper.getStoriesTicket(storyId);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void deletedTicket(int ticketId) {
        try{
            ticketsMapper.deletedTicket(ticketId);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void editedTicket(int ticketId, String estado) {
        try{
            ticketsMapper.editedTicket(ticketId,estado);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void registerTicket(String descripcion, int storyId, String estado, String comentario) {
        try{
            ticketsMapper.registerTicket( descripcion, storyId, estado, comentario);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
