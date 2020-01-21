package com.jianzhi.offer;

public class SingletonBuildFactory {

    /**
     * 单利模式  饿汉式  线程安全
     */
    public static class Singleton {
        private final static Singleton INSTANCE = new Singleton();

        private Singleton() {

        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

    /**
     * 单例模式 懒汉式  线程不安全
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 单例模式  懒汉式  线程安全  多线程环境下效率不高
     */
    public static class Singleton3 {

        private static Singleton3 instance = null;

        private Singleton3() {

        }

        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }

            return instance;
        }
    }

    /**
     * 单例模式  懒汉式  变种  线程安全
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式  静态内部类  线程安全
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 使用静态内部类  双重校验锁  线程安全
     */
    public static class Singleton6 {
        private volatile static Singleton6 instance = null;

        private Singleton6() {

        }

        public static Singleton6 getInstance() {
            if (instance == null) {
                synchronized (Singleton6.class) {
                    if (instance == null) {
                        instance = new Singleton6();
                    }
                }
            }

            return instance;
        }
    }

}
