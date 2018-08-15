package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2)
    {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {

       Thread thread1 = new Thread()
       {
           @Override
           public void run()
           {
               synchronized (o1)
               {
                   try {
                       sleep(50);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (o2){}
               }
           }
       };
       Thread thread2 = new Thread()
       {
           @Override
           public void run()
           {

                   solution.someMethodWithSynchronizedBlocks(o1,o2);

           }
       };


       thread1.start();
       thread1.sleep(10);
       thread2.start();
       thread2.sleep(100);

       if(thread1.getState() == Thread.State.BLOCKED)return false;
       else return true;


    }

    public static void main(String[] args) throws Exception {

        for(int i = 0; i < 100; ++i) {

        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

            System.out.println(isNormalLockOrder(solution, o1, o2));
        }
        }
}
