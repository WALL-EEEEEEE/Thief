package modules.test;

import java.text.SimpleDateFormat;



public class TestDate{

    public static void main(String args[]){

        System.out.println(System.currentTimeMillis());

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(System.currentTimeMillis()));




    }


}
