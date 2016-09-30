//适配器类,继承了被适配类,同时实现了标准接口
class Adapter extends Adaptee implements Target{

    public void request(){

        super.specificRequest();

    }

}
