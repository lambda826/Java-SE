package generics.bounds.wildcards;

/**
 * The real issue is that we are talking about the type of the container, rather than the type that the container is holding.
 * Unlike arrays, generics do not have built-in covariance.
 * This is because arrays are completely defined in the language and can thus have both compile-time and runtime checks built in,
 * but with generics, the compiler and runtime system cannot know what you want to do with your types and what the rules should be
 */
public class _02_NonCovariantGenerics {
    // Compile Error: incompatible types:
    //        List<Fruit> flist = new ArrayList<Apple>();
}
