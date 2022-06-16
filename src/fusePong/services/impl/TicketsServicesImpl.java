package fusePong.services.impl;

import com.google.inject.Inject;
import fusePong.persistence.*;
import fusePong.services.TicketsServices;

public class TicketsServicesImpl implements TicketsServices {

    @Inject
    private CompanyDAO companyDAO;

    @Inject
    private ProjectDAO projectDAO;

    @Inject
    private StoriesDAO storiesDAO;

    @Inject
    private TicketsDAO ticketsDAO;

    @Inject
    private UserDAO userDAO;
}
