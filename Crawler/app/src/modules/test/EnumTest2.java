package modules.test;

import java.util.EnumSet;
import java.util.EnumMap;
public class EnumTest2{

    //定义枚举类型
    public enum Light{

        RED(1),GREEN(3),YELLOW(2);

        private int nCode;

        private Light(int _nCode){

            this.nCode = _nCode;

        }

        @Override
        public String toString(){

            return String.valueOf(this.nCode);
        }

    }

        /**
         * @param args
         *
         */
        public static void main(String[] args){

            System.out.println("演示枚举类型的遍历....");
            testTraversalEnum();

            System.out.println("演示EnumMap对象的使用和遍历....");
            testEnumMap();

            System.out.println("演示EnumSet对象的使用和遍历....");
            testEnumSet();
        }


        /**
         * 演示枚举类型的遍历
         *
         */
        private static void testTraversalEnum(){

            Light[] allLight = Light.values();
            for(Light aLight:allLight){
                System.out.println("当前灯name"+aLight.name());
                System.out.println("当前灯ordinal:"+aLight.ordinal());
                System.out.println("当前灯:"+aLight);

            }


        }

        /**
         * 演示EnumMap的使用
         *
         */

        private static void testEnumMap(){

            EnumMap<Light,String> currEnumMap = new EnumMap<Light,String>(Light.class);
            currEnumMap.put(Light.RED,"红灯");
            currEnumMap.put(Light.GREEN,"绿灯");
            currEnumMap.put(Light.YELLOW,"黄灯");

            for(Light aLight:Light.values()){
                System.out.println("[key=]"+aLight.name()+",value="+currEnumMap.get(aLight) +"]");

            }

        }

        private static void testEnumSet(){

            EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);
            for(Light aLightSetElement:currEnumSet){

                System.out.println("当前EnumSet中的数据为:"+aLightSetElement);

            }

        }

    }



