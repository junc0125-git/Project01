package com.unit09.compare_class.own;

/**
 * 商品类
 * @author cj
 * @create 2020-10-29 20:36
 */
public class Goods implements  Comparable{

    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式:按照价格从低到高排序,再按照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
//        System.out.println("**************");//证明调用了compareTo方法
        if(o instanceof Goods){
            Goods goods = (Goods)o;//也可能是Goods的子类，所以要先强转为Goods
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;   //单重排序
               return -this.name.compareTo(goods.name);  //多重排序  先根据价格排，价格相同在根据名称排
            }
            //方式二：Double类中的一个比较方法，其实底层同方法一
//           return Double.compare(this.price,goods.price);
        }
//        return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
