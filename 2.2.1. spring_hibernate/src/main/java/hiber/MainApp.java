package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Вадим", "Шиленков", "vadim@yandex.ru");
        User user2 = new User("Алёна", "Шиленква", "alena@yandex.ru");
        User user3 = new User("Матвей", "Шиленков", "matvey@yandex.ru");
        User user4 = new User("Сева", "Курганов", "seva@yandex.ru");

        Car car1 = new Car("ЗИЛ", 130);
        Car car2 = new Car("КРАЗ", 250);
        Car car3 = new Car("УРАЛ", 5557);
        Car car4 = new Car("КАМАЗ", 43253);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        for (User user : userService.printUsers()) {
            System.out.println(user);
        }

        System.out.println(userService.getUserByCar("ЗИЛ", 130));

        context.close();
    }
}


