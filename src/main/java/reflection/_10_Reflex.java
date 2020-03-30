package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class _10_Reflex {

    private static Object createObject(Class clazz, Class[] pareTypes, Object[] pareValues) {
        try {
            Constructor ctor = clazz.getDeclaredConstructor(pareTypes);
            ctor.setAccessible(true);
            return ctor.newInstance(pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getFieldObject(Class clazz, Object obj, String filedName) {
        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void setFieldObject(Class clazz, Object obj, String filedName, Object filedVaule) {
        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedVaule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object invokeInstanceMethod(Object obj, String methodName, Class[] pareTypes, Object[] pareValues) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName, pareTypes);
            method.setAccessible(true);
            return method.invoke(obj, pareValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object invokeStaticMethod(Class clazz, String method_name, Class[] pareTypes, Object[] pareValues) {
        try {
            Method method = clazz.getDeclaredMethod(method_name, pareTypes);
            method.setAccessible(true);
            return method.invoke(null, pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createObject(String className) {
        Class[] pareTypes = new Class[] {};
        Object[] pareValues = new Object[] {};
        try {
            Class r = Class.forName(className);
            return createObject(r, pareTypes, pareValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createObject(Class clazz) {
        Class[] pareTyple = new Class[] {};
        Object[] pareValues = new Object[] {};
        return createObject(clazz, pareTyple, pareValues);
    }

    public static Object createObject(String className, Class pareTyple, Object pareVaule) {
        Class[] pareTypes = new Class[] { pareTyple };
        Object[] pareValues = new Object[] { pareVaule };
        try {
            Class r = Class.forName(className);
            return createObject(r, pareTypes, pareValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createObject(Class clazz, Class pareTyple, Object pareVaule) {
        Class[] pareTypes = new Class[] { pareTyple };
        Object[] pareValues = new Object[] { pareVaule };
        return createObject(clazz, pareTypes, pareValues);
    }

    public static Object createObject(String className, Class[] pareTypes, Object[] pareValues) {
        try {
            Class r = Class.forName(className);
            return createObject(r, pareTypes, pareValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldObject(String className, Object obj, String filedName) {
        try {
            Class obj_class = Class.forName(className);
            return getFieldObject(obj_class, obj, filedName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldObject(String className, Object obj, String filedName, Object filedVaule) {
        try {
            Class obj_class = Class.forName(className);
            setFieldObject(obj_class, obj, filedName, filedVaule);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object invokeInstanceMethod(Object obj, String methodName, Class pareTyple, Object pareVaule) {
        Class[] pareTypes = { pareTyple };
        Object[] pareValues = { pareVaule };
        return invokeInstanceMethod(obj, methodName, pareTypes, pareValues);
    }


    public static Object invokeInstanceMethod(Object obj, String methodName) {
        Class[] pareTypes = new Class[] {};
        Object[] pareValues = new Object[] {};
        return invokeInstanceMethod(obj, methodName, pareTypes, pareValues);
    }

    public static Object invokeStaticMethod(String className, String method_name) {
        Class[] pareTypes = new Class[] {};
        Object[] pareValues = new Object[] {};
        return invokeStaticMethod(className, method_name, pareTypes, pareValues);
    }

    public static Object invokeStaticMethod(String className, String method_name, Class pareTyple, Object pareVaule) {
        Class[] pareTypes = new Class[] { pareTyple };
        Object[] pareValues = new Object[] { pareVaule };
        return invokeStaticMethod(className, method_name, pareTypes, pareValues);
    }


    private static Object invokeStaticMethod(String className, String method_name, Class[] pareTypes, Object[] pareValues) {
        try {
            Class obj_class = Class.forName(className);
            return invokeStaticMethod(obj_class, method_name, pareTypes, pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeStaticMethod(Class clazz, String method_name) {
        Class[] pareTypes = new Class[] {};
        Object[] pareValues = new Object[] {};
        return invokeStaticMethod(clazz, method_name, pareTypes, pareValues);
    }

    public static Object invokeStaticMethod(Class clazz, String method_name, Class classType, Object pareVaule) {
        Class[] classTypes = new Class[] { classType };
        Object[] pareValues = new Object[] { pareVaule };
        return invokeStaticMethod(clazz, method_name, classTypes, pareValues);
    }

    public static Object getStaticFieldObject(String className, String filedName) {
        return getFieldObject(className, null, filedName);
    }

    public static Object getStaticFieldObject(Class clazz, String filedName) {
        return getFieldObject(clazz, null, filedName);
    }

    public static void setStaticFieldObject(String classname, String filedName, Object filedVaule) {
        setFieldObject(classname, null, filedName, filedVaule);
    }

    public static void setStaticFieldObject(Class clazz, String filedName, Object filedVaule) {
        setFieldObject(clazz, null, filedName, filedVaule);
    }
}
