package annotations;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

import static utils.PrintUtil.println;


public class InheritedDemo {

    @Inherited
    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface DocumentA {}

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface DocumentB {}

    @DocumentA
    static class A {}

    static class B extends A {}

    @DocumentB
    static class C {}

    static class D extends C {}

    public static void main(String... args) {
        println(Arrays.toString(new A().getClass().getAnnotations()));
        println(Arrays.toString(new B().getClass().getAnnotations()));
        println(Arrays.toString(new C().getClass().getAnnotations()));
        println(Arrays.toString(new D().getClass().getAnnotations()));
    }
}
