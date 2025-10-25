package university.utils;

public class IdGenerator {
    private static long counter = System.currentTimeMillis() % 100000;
    public static synchronized long next() { return ++counter; }
}

