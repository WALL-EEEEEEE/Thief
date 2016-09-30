
package  modules.common;
public abstract class Decorator extends Component  {


        private Component component;


        public Decorator(Component icomponent){

            this.component = icomponent;

        }



        public void  Operation(){

            this.BeforeOperation();
            this.component.Operation();
            this.AfterOperation();
        }



        public abstract void BeforeOperation();



        public abstract void AfterOperation();



}

