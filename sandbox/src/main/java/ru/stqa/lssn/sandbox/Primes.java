package ru.stqa.lssn.sandbox;

public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0 ){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeFast(int n) {
        int m = (int) Math.sqrt(n);
        //int m = n / 2;
        //for (int i = 2; i < n / 2; i++) { // у меня при i < n / 2 тест работает дольше, чем при i < n, что странно, должно быть меньше раза в два
        for (int i = 2; i < m; i++) {
            if (n % i == 0 ){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(long n) {
        for (long i = 2; i < n; i++) {
            if (n % i == 0 ){
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeWhile(int n) {
        int i = 2;
        while (i < n && n % i != 0) {
            i++;
        }
        return i == n;
    }


}
