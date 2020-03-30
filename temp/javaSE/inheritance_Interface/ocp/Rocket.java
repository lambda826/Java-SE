/**
 *  @author Yunxiang He
 *  @date Feb 10, 2018 1:32:44 AM
 */

package inheritance_Interface.ocp;

public class Rocket extends Ship {

    public int weight = 1;
    public int height = 2;

    public void printDetails() {
        System.out.println(super.getWeight() + ", " + super.getHeight());
    }

    @Override
    public void println() {
        System.out.println("sub");
        super.println();
    }

    public static final void main(String[] args) {
        Rocket r = new Rocket();
        r.printDetails();
        r.println();
    }

}

class Ship {
    protected int weight = 4;
    private int height = 5;

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    protected void println() {
        System.out.println("super");
    }
}
