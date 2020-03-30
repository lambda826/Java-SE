//package oop.polymorphism.override;
//
//
//class Super {
//}
//
//class Sub extends Super {
//}
//
//abstract class Test {
//    abstract void method1(Super param);
//
//    abstract void method2(Sub param);
//
//    abstract Super method3();
//}
//
///**
// * I couldn't find any topic or thread explain why method overriding doesn't support parameter list polymorphism
// * I couldn't find the source code of the annotation processor of @Override
// */
//class TestOverride extends Test {
//
//    /**
//     * Not Ok
//     * Because it's down casting, so it's not safe, compile fail
//     */
//    @Override
//    void method1(Sub param) { // abstract void method1(Super param);
//
//    }
//
//    /**
//     * Not Ok
//     * This is up casting, I don't understand why it's failing
//     * One reason I came up is because of ambiguity
//     * Which means if you have multiple methods which have compatible in the sub class, then at runtime JVM doesn't know which method it should invoke
//     */
//    @Override
//    void method2(Super param) { // abstract void method2(Sub param);
//    }
//
//    @Override
//    void method2(Sub param) { // abstract void method2(Sub param);
//
//    }
//
//
//    /**
//     * OK
//     * This is because when we get the returned value, it is safe to cast the sub type to it's super type to achieve polymorphism
//     * This works because Java doesn't allow us ot overload methods if and only if the return type is different
//     */
//    @Override
//    Sub method3() { // abstract Super method2();
//        return null;
//    }
//
//}
//
