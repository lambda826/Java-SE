package generics.factory;


import static utils.PrintUtil.println;

class ClassAsFactory<T> {

    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        println("ClassAsFactory<Employee> succeeded");
        try {
            // Fails with ClassAsFactory<Integer> because Integer has no default constructor
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            println("ClassAsFactory<Integer> failed");
        }
    }
}