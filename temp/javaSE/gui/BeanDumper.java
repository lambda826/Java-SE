package gui;

// Introspecting a Bean.

import static util.SwingConsole.*;

public class BeanDumper extends JFrame {
    private JTextField query = new JTextField(20);
    private JTextArea results = new JTextArea();

    public void println(String s) {
        results.append(s + "\n");
    }

    public void dump(Class<?> bean) {
        results.setText("");
        BeanInfo bi = null;
        try {
            bi = Introspector.getBeanInfo(bean, Object.class);
        } catch (IntrospectionException e) {
            println("Couldn't introspect " + bean.getName());
            return;
        }
        for (PropertyDescriptor d : bi.getPropertyDescriptors()) {
            Class<?> p = d.getPropertyType();
            if (p == null) {
                continue;
            }
            println("Property type:\n  " + p.getName() + "Property name:\n  " + d.getName());
            Method readMethod = d.getReadMethod();
            if (readMethod != null) {
                println("Read method:\n  " + readMethod);
            }
            Method writeMethod = d.getWriteMethod();
            if (writeMethod != null) {
                println("Write method:\n  " + writeMethod);
            }
            println("====================");
        }
        println("Public methods:");
        for (MethodDescriptor m : bi.getMethodDescriptors()) {
            println(m.getMethod().toString());
        }
        println("======================");
        println("Event support:");
        for (EventSetDescriptor e : bi.getEventSetDescriptors()) {
            println("Listener type:\n  " + e.getListenerType().getName());
            for (Method lm : e.getListenerMethods()) {
                println("Listener method:\n  " + lm.getName());
            }
            for (MethodDescriptor lmd : e.getListenerMethodDescriptors()) {
                println("Method descriptor:\n  " + lmd.getMethod());
            }
            Method addListener = e.getAddListenerMethod();
            println("Add Listener Method:\n  " + addListener);
            Method removeListener = e.getRemoveListenerMethod();
            println("Remove Listener Method:\n  " + removeListener);
            println("====================");
        }
    }

    class Dumper implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = query.getText();
            Class<?> c = null;
            try {
                c = Class.forName(name);
            } catch (ClassNotFoundException ex) {
                results.setText("Couldn't find " + name);
                return;
            }
            dump(c);
        }
    }

    public BeanDumper() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(new JLabel("Qualified bean name:"));
        p.add(query);
        add(BorderLayout.NORTH, p);
        add(new JScrollPane(results));
        Dumper dmpr = new Dumper();
        query.addActionListener(dmpr);
        query.setText("frogbean.Frog");
        // Force evaluation
        dmpr.actionPerformed(new ActionEvent(dmpr, 0, ""));
    }

    public static void main(String[] args) {
        run(new BeanDumper(), 600, 500);
    }
} ///:~
