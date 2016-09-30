import java.util.*;


public class EnumTest4{

    public static void main(String[] args){
        PowerOfTwo i = PowerOfTwo.fromInt(2);
        System.out.println(i);

    }

    enum PowerOfTwo{
        ONE(1),TWO(2),FOUR(4),EIGHT(8);
        private int value;
        PowerOfTwo(int value){

            this.value = value;

        }

        @Override
        public String toString(){

            return Integer.toString(this.value);
        }


        public static PowerOfTwo fromInt(int i){

            return PowerOfTwo.map.get(i);
        }


        public static Map<Integer,PowerOfTwo> map = new HashMap<Integer,PowerOfTwo>();
        static {
            for(PowerOfTwo p :PowerOfTwo.values()){

                PowerOfTwo.map.put(p.value,p);

            }


        }


    }

}
