package by.it.sinkevich.jd03_01.taskC;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for jd03_01 TaskC
 * Contains sequence of sql queries to recreate my DB with Data
 *
 * @author Sinkevcih Denis
 */
class CreateScenario {

    static final List<String> QUERIES;

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

        QUERIES.add("INSERT INTO `sinkevich`.`roles` (`name`) VALUES ('Bookmaker');");

        QUERIES.add("INSERT INTO `sinkevich`.`roles` (`name`) VALUES ('Client');");

        QUERIES.add("INSERT INTO `sinkevich`.`users` (`name`, `dateOfBirth`, `email`, `fk_role`, `login`, `password`) " +
                "VALUES ('Синкевич Денис Сергеевич', '1986-11-08', 'SleePokeR@gmail.com', '1', 'Admin', 'Admin');");

        QUERIES.add("INSERT INTO `sinkevich`.`users` (`name`, `dateOfBirth`, `email`, `fk_role`, `login`, `password`) " +
                "VALUES ('Иванов Иван Иванович', '1991-07-07', 'Gambler@mail.ru', '2', 'Gambler', 'qwerty');");

        QUERIES.add("INSERT INTO `sinkevich`.`races` (`time`, `horse1`, `horse2`, `horse3`, `horse4`, `horse5`," +
                " `horse6`, `horse7`, `horse8`, `winner`) VALUES ('2016-07-07 13:00:00.000', 'Эклипс', 'Сметанка'," +
                " 'Сухарь', 'Будулай', 'Секретариат', 'Резвая', 'Абсент', 'Анилин', 'Сметанка');");

        QUERIES.add("INSERT INTO `sinkevich`.`bets` (`time`, `fk_race`, `horse`, `betSum`, `fk_user`) " +
                "VALUES ('2016-07-07 12:33:07.666', '1', 'Эклипс', '10.5', '2');");

        QUERIES.add("INSERT INTO `sinkevich`.`bets` (`time`, `fk_race`, `horse`, `betSum`, `fk_user`) " +
                "VALUES ('2016-07-07 12:35:41.013', '1', 'Сметанка', '5', '2');");

        QUERIES.add("INSERT INTO `sinkevich`.`bets` (`time`, `fk_race`, `horse`, `betSum`, `fk_user`) " +
                "VALUES ('2016-07-07 12:40:00', '1', 'Сухарь', '100.342', '2');");
    }
}
