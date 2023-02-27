package demo1;

public class MainThread {
    public static void main(String[] args){
        Sub1 s1 = new Sub1(5,30);
        s1.start();

        Sub2 s2 = new Sub2();
        Thread t = new Thread(s2);
        t.start();

        Runnable r = ()->{
            for (int i=0;i<20;i++){
                System.out.println();
            }
        };

        Thread t2 = new Thread(r);
        t2.start();

        // tạo thread chạy luôn mà không cần khai báo biến
        new Thread(()->{
            // cần chạy gì viết vào đây
        }).start();

//        for (int i=0;i<20;i++){
//            System.out.println("Main i="+i);
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e){
//
//            }
//        }
    }
}
