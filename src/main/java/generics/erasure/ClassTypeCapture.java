package generics.erasure;


import static common.utils.PrintUtil.println;

public class ClassTypeCapture<T> {

    static class Building {
    }

    static class House extends Building {
    }

    // sometimes you must compensate for erasure by introducing a type tag. 
    // This means you explicitly pass in the Class object for your type so that you can use it in type expressions.
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        println(ctt1.f(new Building()));
        println(ctt1.f(new House()));

        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        println(ctt2.f(new Building()));
        println(ctt2.f(new House()));
    }
}