package net.pyrix25633.ncis.util;

public class Generics {
    /**
     * Method to sum two generics
     * @param first The first generic
     * @param second The second generic
     * @return The sum of the two generics
     * @param <T> T extends Number
     */
    @SuppressWarnings("unchecked")
    public static <T extends Number> T sum(T first, T second) {
        if(first instanceof Float && second instanceof Float)
            return (T)(Float)((Float)first + (Float)second);
        else if(first instanceof Integer && second instanceof Integer)
            return (T)(Integer)((Integer)first + (Integer)second);
        else return null;
    }
}