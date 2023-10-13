package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

//Aby zobaczyć rezultat dla danego podpunktu, proszę zakomentować ostatni podpunkt (funkcje main i run w pkt 16,17)
//i odkomentować kod dla konkretnego podpunktu.

public class World {
//    pkt 6
    /*
    public static void main(String[]args){
        System.out.println("system wystartował");
        System.out.println("system zakończył działanie");
    }
    */

//    pkt 8,9
    /*
    public static void main(String[]args){
        System.out.println("system wystartował");
        run();
        System.out.println("system zakończył działanie");
    }

    public static void run(){
        System.out.println("Zwierzak idzie do przodu");
    }

    */


//    pkt 11
    /*
    public static void main(String[]args){
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }

    public static void run(String[]args){
        System.out.println("Zwierzak idzie do przodu");
    }

    */

//    pkt 12

    /*
    public static void main(String[]args){
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }

    public static void run(String[]args){
        System.out.println("Zwierzak idzie do przodu");
        int i=0;
        int n=args.length;

        for(String arg : args){
            System.out.print(arg);
            if(i++!=n-1){
                System.out.print(", ");
            }
        }

        System.out.println();

    }
     */

//    pkt 14,15
    /*

    public static void main(String[]args){
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }

    public static void run(String[]args){
        for(String arg : args){
            switch(arg){
                case "f"->System.out.println("Zwierzak idzie do przodu");
                case "b"->System.out.println("Zwierzak idzie do tyłu");
                case "r"->System.out.println("Zwierzak skręca w prawo");
                case "l"->System.out.println("Zwierzak skręca w lewo");
            }
        }
     }
     */

//  pkt 16,17

    public static void main(String[]args){
        System.out.println("system wystartował");
        //pkt 16,17
        MoveDirection[] parsed= OptionParser.parse(args);
        run(parsed);

        System.out.println("system zakończył działanie");
    }

    public static void run(MoveDirection[]args){
        for (MoveDirection arg : args){
            if (arg!=null){
                System.out.println(arg);
            }

        }
    }



}
