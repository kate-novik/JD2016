package by.it.sinkevich.jd03_02.taskC;

import by.it.sinkevich.jd03_02.taskC.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class CreateScenario {

    private static final List<String> QUERIES;

    static {
        QUERIES = new ArrayList<>();

        QUERIES.add("CREATE TABLE `sinkevich`.`roles` (\n" +
                "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL COMMENT 'Название',\n" +
                "  PRIMARY KEY (`id`))\n" +
                "COMMENT = 'Роли\t';");

        QUERIES.add("CREATE TABLE `sinkevich`.`users` (\n" +
                "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(100) NOT NULL COMMENT 'Ф.И.О.',\n" +
                "  `dateOfBirth` DATE NOT NULL COMMENT 'Дата рождения',\n" +
                "  `email` VARCHAR(100) NOT NULL COMMENT 'Почта',\n" +
                "  `fk_role` INT UNSIGNED NOT NULL COMMENT 'Роль',\n" +
                "  `login` VARCHAR(100) NOT NULL COMMENT 'Логин',\n" +
                "  `password` VARCHAR(100) NOT NULL COMMENT 'Пароль',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `role_idx` (`fk_role` ASC),\n" +
                "  CONSTRAINT `role`\n" +
                "    FOREIGN KEY (`fk_role`)\n" +
                "    REFERENCES `sinkevich`.`roles` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB\n" +
                "COMMENT = 'Пользователи';");

        QUERIES.add("CREATE TABLE `sinkevich`.`races` (\n" +
                "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `time` TIMESTAMP(3) NOT NULL COMMENT 'Время забега',\n" +
                "  `horse1` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 1',\n" +
                "  `horse2` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 2',\n" +
                "  `horse3` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 3',\n" +
                "  `horse4` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 4',\n" +
                "  `horse5` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 5',\n" +
                "  `horse6` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 6',\n" +
                "  `horse7` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 7',\n" +
                "  `horse8` VARCHAR(45) NOT NULL COMMENT 'Лошадь номер 8',\n" +
                "  `winner` VARCHAR(45) NOT NULL COMMENT 'Победитель забега',\n" +
                "  PRIMARY KEY (`id`))\n" +
                "COMMENT = 'Забеги';");

        QUERIES.add("CREATE TABLE `sinkevich`.`bets` (\n" +
                "  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `time` TIMESTAMP(3) NOT NULL COMMENT 'Время ставки',\n" +
                "  `fk_race` INT UNSIGNED NOT NULL COMMENT 'Забег',\n" +
                "  `horse` VARCHAR(45) NOT NULL COMMENT 'Имя лошади',\n" +
                "  `betSum` DECIMAL(7,2) NOT NULL COMMENT 'Сумма ставки',\n" +
                "  `fk_user` INT UNSIGNED NOT NULL COMMENT 'Пользователь',\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `race_idx` (`fk_race` ASC),\n" +
                "  INDEX `user_idx` (`fk_user` ASC),\n" +
                "  CONSTRAINT `race`\n" +
                "    FOREIGN KEY (`fk_race`)\n" +
                "    REFERENCES `sinkevich`.`races` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `user`\n" +
                "    FOREIGN KEY (`fk_user`)\n" +
                "    REFERENCES `sinkevich`.`users` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "COMMENT = 'Ставки';");
    }

    public static void reset() {
        createSchemas();
        System.out.println("Таблицы созданы!");
        try {
            fillInTableRoles();
            fillInTableRaces();
            fillInTableUsers();
            fillInTableBets();
            System.out.println("Таблицы заполенены данными!");
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД при заполнении данных!");
            e.printStackTrace();
        }
    }

    private static void createSchemas() {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            for (String QUERY : QUERIES) {
                statement.addBatch(QUERY);
            }
            statement.executeBatch();
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД при создании таблиц!");
            e.printStackTrace();
        }
    }

    private static void fillInTableBets() throws SQLException {
        List<Bet> bets = DeleteScenario.getBets();
        BetCRUD betCRUD = new BetCRUD();
        for (Bet bet : bets) {
            betCRUD.create(bet);
        }
    }

    private static void fillInTableUsers() throws SQLException {
        List<User> users = DeleteScenario.getUsers();
        UserCRUD userCRUD = new UserCRUD();
        for (User user : users) {
            userCRUD.create(user);
        }
    }

    private static void fillInTableRaces() throws SQLException {
        List<Race> races = DeleteScenario.getRaces();
        RaceCRUD raceCRUD = new RaceCRUD();
        for (Race race : races) {
            raceCRUD.create(race);
        }
    }

    private static void fillInTableRoles() throws SQLException {
        List<Role> roles = DeleteScenario.getRoles();
        RoleCRUD roleCRUD = new RoleCRUD();
        for (Role role : roles) {
            roleCRUD.create(role);
        }
    }
}
