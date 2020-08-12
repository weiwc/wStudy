package com.weiwc.study.java8;

/**
 * @author weichen
 * @description: 匿名内部类实例
 * @create 2020-04-23 13:47
 * @from https://docs.oracle.com/javase/tutorial/java/javaOO/anonymousclasses.html
 */
public class HelloWorldAnonymousClasses {

    // 申明一个接口
    interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    @FunctionalInterface
    interface HelloWorldLambda {
        void greet();
    }

    // 定义一个方法
    public void sayHello() {
        // 局部类实现了HelloWorld接口
        class EnglishGreeting implements HelloWorld {

            String name = "world";
            @Override
            public void greet() {
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        // 匿名内部类实现
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            @Override
            public void greet() {
                greetSomeone("mundo");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola," + name);
            }
        };

        HelloWorld chineseGreeting1 = new HelloWorld() {
            String name = "世界";
            @Override
            public void greet() {
                greetSomeone("世界");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("你好 " + name);
            }
        };

//        HelloWorldLambda chineseGreeting2 = new HelloWorldLambda() {
//            @Override
//            public void greet() {
//                System.out.println("你好 世界");
//            }
//        };
        HelloWorldLambda chineseGreeting2 = () -> System.out.println("你好 世界");
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
        chineseGreeting1.greet();
        chineseGreeting2.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}
