package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import static common.utils.PrintUtil.println;

// Reconstructing an externalizable object.

public class Blip3 implements Externalizable {
    private int i;
    private String s; // No initialization

    public Blip3() {
        println("Blip3 Constructor");
        // s, i not initialized
    }

    public Blip3(String x, int a) {
        println("Blip3(String x, int a)");
        s = x;
        i = a;
        // s & i initialized only in non-default constructor.
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        println("Blip3.writeExternal");
        // You must do this:
        out.writeObject(s);
        out.writeInt(i);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        println("Blip3.readExternal");
        // You must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        println("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        println("Saving object:");
        o.writeObject(b3);
        o.close();
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        println("Recovering b3:");
        b3 = (Blip3) in.readObject();
        println(b3);
    }
} /* Output:
  Constructing objects:
  Blip3(String x, int a)
  A String 47
  Saving object:
  Blip3.writeExternal
  Recovering b3:
  Blip3 Constructor
  Blip3.readExternal
  A String 47
  *///:~
