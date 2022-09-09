package homework;

//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();



        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */


        Map<String, List<Integer>> map1 = Arrays.stream(RAW_DATA)
                .distinct()
                .collect(Collectors.groupingBy(Person::getName, mapping(Person::getId, toList())));

        Collection<List<Integer>> values = map1.values();

        List<Long> countId = values.stream().map(x -> (long) x.size()).toList();

        Set<String> keys = map1.keySet();
        List<String> keysList = new ArrayList<>(keys);

        Map<String, Long> mapResult = new HashMap<>();

        for (int i = 0; i < keysList.size(); i++) {
            mapResult.put(keysList.get(i), countId.get(i));
        }

        for(Map.Entry<String, Long> entry: mapResult.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            System.out.println("Key: " + key + "\n" + "Value: " + value);
        }







        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */
        int[] arr = {3, 5, 2, 7};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] + arr[j] == 10 & i < j) {
                    System.out.println("[" + arr[i] + ", " + arr[j] + "]");
                }
            }
        }



        /*
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */

        ComplexExamples fuzzy = new ComplexExamples();
        System.out.println(fuzzy.fuzzySearch("cwheeel", "cartwheel"));
    }

    public boolean fuzzySearch(String source, String search) {
        char[] sourceArray = source.toCharArray();
        int[] charIndex = new int[source.length()];
        int index = search.indexOf(sourceArray[0]);
        charIndex[0] = index;
        for (int i = 1; i < source.length(); i++) {
            if (search.indexOf(sourceArray[i], index + 1 ) != -1) {
                index = search.indexOf(sourceArray[i], index + 1);
                    charIndex[i] = search.indexOf(sourceArray[i], index);
            } else {
                charIndex[i] = search.indexOf(sourceArray[i], index + 1);
            }
        }
        boolean found = Arrays.stream(charIndex).anyMatch(x -> x == -1);
        return !found;
    }






}
