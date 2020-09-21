package ru.job4j.collection.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("Sergey", 0, new GregorianCalendar(1990, 6, 10), 15465151);
        User user2 = new User("Sergey", 0, new GregorianCalendar(1990, 6, 10), 15646584);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        Set<Map.Entry<User, Object>> set = map.entrySet();

        System.out.println();
        set.forEach(System.out::println);

        System.out.println();
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());

    }
}
