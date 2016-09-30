package modules.test.DecoratorModuleTest;

import modules.common.Decorator;
import modules.common.Component;

public class  Decorator1 extends Decorator{


    public Decorator1(Component component){
        super(component);
    }



    public void BeforeOperation(){

         System.out.println("Decorator1 BeforeOperation");

    }

    public void AfterOperation(){
        System.out.println("Decorator1 AfterOperation");


    }






}
