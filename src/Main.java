import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        //Imperative
//        List<Person> females = new ArrayList<>();
//
//        for (Person person : people) {
//            if (person.getGender().equals(Gender.FEMALE)) {
//                females.add(person);
//            }
//        }
//        females.forEach(System.out::println);

        //Declarative


        //Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        //Sort
        List<Person> sortedByGender = people.stream()
                .sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getAge).reversed())
                .collect(Collectors.toList());


        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());

        //All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);


        //Any match
        //Max
        //Min
        //Group

        //Print
//        sortedByGender.forEach(System.out::println);
//        sortedByAge.forEach(System.out::println);
        System.out.println(allMatch);
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