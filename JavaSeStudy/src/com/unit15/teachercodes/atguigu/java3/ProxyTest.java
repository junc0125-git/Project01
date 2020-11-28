package com.unit15.teachercodes.atguigu.java3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理的举例
 *
 * @author shkstart
 * @create 2019 上午 10:18
 */

interface Human{

    String getBelief();

    void eat(String food);

}
//被代理类
class SuperMan implements Human{


    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{
    //另一个测试模块
    public void method1(){
        System.out.println("====================通用方法一====================");

    }

    public void method2(){
        System.out.println("====================通用方法二====================");
    }

}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。


 */

class ProxyFactory{ //工厂的作用：根据传入的被代理类来动态生成代理类
    //何为代理类和被代理类
        //被代理类要执行的方法由代理类封装执行，即通过调用代理类的方法来调用被代理的方法

    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);//相当于把obj参数传过去，给MyInvocationHandler类实例化

        //返回一个代理类的对象
        //obj.getClass().getClassLoader(): 获取被代理类的加载器
        //obj.getClass().getInterfaces()：获取被代理类所实现的接口
        //handler: 当我们通过代理类的对象，调用方法a时，就会自动的调用MyInvocationHandler中的
        // 方法：invoke()  （注：被代理类要执行的方法a的功能就声明在invoke()中）
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    //作为参数传递的一个过程  相当于把被代理类的对象给传过来
    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //关于HumanUtil是另一个测试模块
        HumanUtil util = new HumanUtil();
        util.method1();

        //method:即为代理类对象调用的方法（代理类调用某个方法时，该方法即作为参数传了过来），此方法也就
        //              作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj,args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return returnValue;

    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象    代理类对象实现的也是Human的接口，故可以强转
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        // 实际上调用的是invork()函数（注：invork()函数对原先的函数功能做了拓展）
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("*****************************");
        //测试：使用StaticProxyTest.java中的被代理类来动态创建代理类
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();

    }
}
