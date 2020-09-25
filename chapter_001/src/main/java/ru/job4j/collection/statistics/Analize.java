package ru.job4j.collection.statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Класс собирает статистику по изменениям в коллекции.
 * @author Frolov Sergey (Slevkelebr@yandex.ru)
 * @version 0.1
 * @since 25.09.2020
 */

public class Analize {


    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> map = new HashMap<>();
        for (var user : previous) {
            map.put(user.id, user.name);
        }
        for (var user : current) {
            if (!map.containsKey(user.id)) {
                info.added++;
            } else if (!map.get(user.id).equals(user.name)) {
                info.changed++;
            }
        }
        info.deleted = previous.size() - current.size() + info.added;
        return info;

    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    name.equals(user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added;
        int changed;

        int deleted;

    }
}
