//package containers;
//
//import generics._109_Generator;
//
//import java.util.ArrayList;
//
//@SuppressWarnings("serial")
//public class _138_CollectionData<T> extends ArrayList<T> {
//
//    public _138_CollectionData(_109_Generator<T> gen, int quantity) {
//        for (int i = 0; i < quantity; i++) {
//            add(gen.next());
//        }
//    }
//
//    public static <T> _138_CollectionData<T> list(_109_Generator<T> gen, int quantity) {
//        return new _138_CollectionData<T>(gen, quantity);
//    }
//}