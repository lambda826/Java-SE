//package oop.polymorphism;
//
//class Super {
//
//    protected int field = 0;
//
//    public int getField() {
//        return field;
//    }
//
//}
//
//class Sub extends oop.polymorphism.override.Super {
//
//    public int field = 1;
//
//    public int getField() {
//        return field;
//    }
//
//    public int getSuperField() {
//        return super.field;
//    }
//
//}
//
//public class _102_FieldAccess {
//
//    public static void main(String[] args) {
//        oop.polymorphism.override.Super sup = new oop.polymorphism.override.Sub();
//        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
//        oop.polymorphism.override.Sub sub = new oop.polymorphism.override.Sub();
//        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());
//    }
//
//}