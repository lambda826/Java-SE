package innerClazz.LocalInnerClass;

import static utils.PrintUtil.println;

public class InnerClassInAnyScope {
    public static void main(String[] args) {
        InnerClassInAnyScope p = new InnerClassInAnyScope();
        p.track();
    }

    public void track() {
        internalTracking(true);
    }

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            println(ts.getSlip());
        }
        // Can't use it here! Out of scope:
        //! TrackingSlip ts = new TrackingSlip("x");
    }
}
