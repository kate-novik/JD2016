package by.it.sinkevich.jd03_03.dao;

/**
 * DAO fabric class. Contains all DAO for our entities. Singleton
 *
 * @author Sinkevich Denis
 */
public class DAO {

    private static DAO dao;

    private RoleDAO roleDAO;
    private RaceDAO raceDAO;
    private UserDAO userDAO;
    private BetDAO betDAO;

    private DAO() {

    }

    public static DAO getDao() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.roleDAO = new RoleDAO();
                    dao.raceDAO = new RaceDAO();
                    dao.userDAO = new UserDAO();
                    dao.betDAO = new BetDAO();
                }
            }
        }
        return dao;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public RaceDAO getRaceDAO() {
        return raceDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public BetDAO getBetDAO() {
        return betDAO;
    }
}
