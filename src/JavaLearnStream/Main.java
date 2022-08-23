package JavaLearnStream;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        //Imperative
//        List<JavaLearnStream.Person> females = new ArrayList<>();
//
//        for (JavaLearnStream.Person person : people) {
//            if (person.getGender().equals(JavaLearnStream.Gender.FEMALE)) {
//                females.add(person);
//            }
//        }
//        females.forEach(System.out::println);

        //Declarative


        //Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();

        //Sort
        List<Person> sortedByGender = people.stream()
                .sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getAge).reversed())
                .toList();


        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .toList();

        //All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);


        //Any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 127);
        //Max
        //Min
        //Group

        //Print
        females.forEach(System.out::println);
//        sortedByGender.forEach(System.out::println);
//        sortedByAge.forEach(System.out::println);
        System.out.println(anyMatch);
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