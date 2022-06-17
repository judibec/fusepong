package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.persistence.TicketsDAO;
import fusePong.persistence.mybatis.mappers.TicketsMapper;

public class MyBatisTicketsDAO implements TicketsDAO {

    @Inject
    private TicketsMapper ticketsMapper;

}
