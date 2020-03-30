//package lambda.methodReference;
//
//
//import java.util.Collections;
//import java.util.List;
//import java.util.function.Supplier;
//
//public class MethodReference2 {
//
//    static class Person {
//        @Getter
//        @Setter
//        private String name;
//
//        public int compare(Person p1, Person p2) {
//            return p1.getName().compareTo(p2.getName());
//        }
//
//        public int compareTo(Person p) {
//            return this.getName().compareTo(p.getName());
//        }
//    }
//
//    static class PersonFactory {
//        private Supplier<Person> supplier;
//
//        public PersonFactory(Supplier<Person> supplier) {
//            this.supplier = supplier;
//        }
//
//        public Person getPerson() {
//            return supplier.get();
//        }
//    }
//
//    public static int myCompare(Person p1, Person p2) {
//        return p1.getName().compareTo(p2.getName());
//    }
//
//
//    public static void main(String[] args) {
//        PersonFactory factory = new PersonFactory(Person::new);
//        Person p1 = factory.getPerson();
//        p1.setName("Kobe");
//        Person p2 = factory.getPerson();
//        p2.setName("James");
//        Person p3 = factory.getPerson();
//        p3.setName("Paul");
//        List<Person> personList = Lists.newArrayList(p1, p2, p3);
//
//
//        // Comparator, compare(T t1, T t2)
//        Collections.sort(personList, MethodReference2::myCompare);
//        Collections.sort(personList, Person::compareTo);
//        Collections.sort(personList, p1::compare);
//    }
//
//
//}