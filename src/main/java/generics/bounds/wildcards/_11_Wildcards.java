package generics.bounds.wildcards;

public class _11_Wildcards {

    // Raw argument:
    static void rawArgs(_05_Holder holder, Object arg) {
        // Warning: Unchecked call to set(T) as a member of the raw type Holder
        holder.set(arg);
        holder.set(new _11_Wildcards()); // Same warning

        // Can't do this; don't have any 'T'
        // T t = holder.get();

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    // Similar to rawArgs(), but errors instead of warnings:
    static void unboundedArg(_05_Holder<?> holder, Object arg) {
        // holder.set(arg); // Error: set(capture of ?) in Holder<capture of ?> cannot be applied to (Object)
        // holder.set(new _11_Wildcards()); // Same error

        // Can't do this; don't have any 'T':
        // T t = holder.get();
        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    static <T> T exact1(_05_Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(_05_Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(_05_Holder<? extends T> holder, T arg) {
        // holder.set(arg); // Error: set(capture of ? extends T) in Holder<capture of ? extends T> cannot be applied to (T)
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(_05_Holder<? super T> holder, T arg) {
        holder.set(arg);
        // T t = holder.get();  // Error:
        //   Incompatible types: found Object, required T

        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        _05_Holder raw = new _05_Holder<Long>();
        // Or:
        raw = new _05_Holder();
        _05_Holder<Long> qualified = new _05_Holder<>();
        _05_Holder<?> unbounded = new _05_Holder<Long>();
        _05_Holder<? extends Long> bounded = new _05_Holder<>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        // Object r1 = exact1(raw); // Warnings:
        //   Unchecked conversion from Holder to Holder<T>
        //   Unchecked method invocation: exact1(Holder<T>) is applied to (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // Must return Object
        Long r4 = exact1(bounded);

        // Long r5 = exact2(raw, lng); // Warnings: Unchecked conversion from Holder to Holder<Long>
        //   Unchecked method invocation: exact2(Holder<T>,T) is applied to (Holder,Long)
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng); // Error: exact2(Holder<T>,T) cannot be applied to (Holder<capture of ?>,Long)
        // Long r8 = exact2(bounded, lng); // Error: exact2(Holder<T>,T) cannot be applied to (Holder<capture of ? extends Long>,Long)

        // Long r9 = wildSubtype(raw, lng); // Warnings: Unchecked conversion from Holder to Holder<? extends Long>
        //   Unchecked method invocation: wildSubtype(Holder<? extends T>,T) is applied to (Holder,Long)
        Long r10 = wildSubtype(qualified, lng);
        // OK, but can only return Object:
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);

        // wildSupertype(raw, lng); // Warnings: Unchecked conversion from Holder to Holder<? super Long>
        //   Unchecked method invocation: wildSupertype(Holder<? super T>,T) is applied to (Holder,Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng); // Error: wildSupertype(Holder<? super T>,T) cannot be applied to (Holder<capture of ?>,Long)
        // wildSupertype(bounded, lng); // Error: wildSupertype(Holder<? super T>,T) cannot be applied to (Holder<capture of ? extends Long>,Long)
    }
}
