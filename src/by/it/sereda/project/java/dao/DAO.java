package by.it.sereda.project.java.dao;

public class DAO {

    private static DAO dao; //синглтон для DAO

    public UserDAO user;    //DAO для пользователей
    public RoleDAO role;    //DAO для ролей
    public RentDAO rent;        //DAO для объявлений
    //...

    public static DAO getDAO() {   //метод, который создает DAO или возвращает существующий экземпляр
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();
                    dao.role = new RoleDAO();
                    dao.rent = new RentDAO();
                    //новые куски DAO добавляются аналогично при расширении DAO
                    //dao.ad = new RentDAO();
                    //...
                }
            }
        }
        return dao;
    }
}
