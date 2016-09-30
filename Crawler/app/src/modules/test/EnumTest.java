
package modules.test;

public class EnumTest{

    public enum Color{

        RED,GREEN,BLANK,YELLOW;


    }

    public static void main(String args[]){

        for(enum value:Color.values()){
            System.out.println(value);

        }


    }

}

