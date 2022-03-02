import model.History;
import model.User;

import java.util.ArrayList;
import java.util.List;

// 1. Users contains: Name, ID, Point
// 2. User has a function send and received the point
// 3. Information history send and received point(Date, user sender, point, user receiver)
// 4. Information about List of Users
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<History> histories = new ArrayList<>();

        User arif = new User(1, "arif", 100);
        User khafido = new User(2, "khafido", 100);
        ArrayList<User> users = new ArrayList<>(List.of(arif, khafido));
        showUsers(users);
        showHistories(histories);

        histories.addAll(arif.sendPoint(khafido, 1200));
        showHistories(histories);
        showUsers(users);
        Thread.sleep(1000);

        histories.addAll(khafido.sendPoint(arif, 20));
        showHistories(histories);
        Thread.sleep(1000);

//        arif.askPoint(histories, khafido, 10);
//        showHistories(histories);
//        showUsers(users);
//        Thread.sleep(1000);
//
//        khafido.askPoint(histories, arif, 20);
//        showUsers(users);

        System.out.println("------------------------------");
        System.out.println("Users " + "(" + users.size() + "): ");
        showUsers(users);
    }

    private static void showHistories(ArrayList<History> histories) {
//        System.out.println("------------------------------");
        System.out.println("History size: " + histories.size());
        System.out.println("------------------------------");
        histories.forEach(history -> System.out.println(history.toString()));
    }

    public static void showUsers(ArrayList<User> users) {
        System.out.println("------------------------------");
        users.forEach(Main::showUser);
    }

    public static void showUser(User user) {
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Point: " + user.getPoint());
        System.out.println("------------------------------");
    }
}
