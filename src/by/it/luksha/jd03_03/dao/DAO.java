package by.it.luksha.jd03_03.dao;

public class DAO {
    //Экземпляр singleton
    private static DAO dao;

    //DAO для user
    private UserDAO userDAO;

    private DAO() {
    }

    /**
     * Возвращает экземпяр DAO или создает и возвращает экземпляр DAO
     * @return DAO
     */
    public static DAO getDAO() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.userDAO = new UserDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //...
                }
            }
        }
        return dao;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
