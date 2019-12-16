public class Gonka extends Thread {
    static   int  a=0;
    static   int  b=0;

    public static  void main(String[] args) {
        Thread0 thread1 = new  Thread0 ("FORD");
        thread1.start();
        Thread0 thread2 = new Thread0("Ferrari");
        thread2.start();
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("Test.txt")), true)); //не победил старт записи в файл
    }

    static class  Thread0 implements Runnable {
        Thread guruthread;
        private String guruname;
        Thread0(String name) {
            guruname = name;    }


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(guruname + " " + i + " километр ");
                if (guruname == "FORD") {
                    a = i;
                } else {
                    b = i;
                }
                if (a > b & a == 9) {
                    a=10;
                    System.out.println("FORD победил");

                }
                if (b > a & b == 9) {
                    b=10;
                    System.out.println("Ferrari победил");

                }
                if (a==9 & b==10) {
                    System.out.println("FORD проиграл!!!");
                }
                if (b==9 & a==10) {
                    System.out.println("Ferrari проиграл!!!");
                }
            }

        }

        public void start() {
            System.out.println(" Старт " + guruname);
            if (guruthread == null) {
                guruthread = new Thread(this, guruname);
                guruthread.start();


            }


        }
    }}
