package innerClazz.memberInnerClass.namespace;

class WithInner {
    class Inner {
    }
}

/**
 * the inner-class constructor must attach to a reference of the enclosing class object
 * the reference to the enclosing class object must be initialized
 * in the derived class there’s no longer a default object to attach to
 */
public class InheritInner extends WithInner.Inner { // InheritInner is extending only the inner class, not the outer one

    // Won't compile
    // _29_InheritInner() {}
    InheritInner(WithInner wi) {
        wi.super(); // enclosingClassReference.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
