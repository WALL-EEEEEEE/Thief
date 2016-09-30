
public class ConcreteBuilder implements Builder{

    Part partA,partB,partC;

    public void buildPartA(){

        System.out.println("build A");
    }

    public void buildPartB(){

        System.out.println("buildB");


    }


    public void buildPartC(){

        System.out.println("buildC");
    }

    //返回最后组装成的成品结果

    public Product getResult(){


        return new Product(){};

    }


}
