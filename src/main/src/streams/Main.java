package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative Approach ❌

//        List<Person> females = new ArrayList<>();
//
//        for (Person person : people) {
//            if (person.getGender().equals(Gender.FEMALE)) {
//                females.add(person);
//            }
//        }
//
//        females.forEach(System.out::println);


        // Declarative Approach ✅

        // Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();

//        females.forEach(System.out::println);

        // Sort

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .toList();

//        sorted.forEach(System.out::println);

        // All Match
        Boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() < 100);

//        System.out.println(allMatch);

        // None Match
        Boolean noneMatch = people.stream()
                .noneMatch(person -> person.getAge() == 14);

//        System.out.println(noneMatch);

        // Any Match
        Boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() == 14);

//        System.out.println(anyMatch);

        // Max

        people.stream()
              .max(Comparator.comparing(Person::getAge));
//              .ifPresent(System.out::println);

        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge));
//                .ifPresent(System.out::println);

        // Group
        Map<Gender,List<Person>> group = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

//        group.forEach((gender, peopleList) -> {
//            System.out.println(gender);
//            peopleList.forEach(System.out::println);
//            System.out.println();
//        });

        // Chain
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
