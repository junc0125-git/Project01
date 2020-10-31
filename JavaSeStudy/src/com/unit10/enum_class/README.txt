
枚举类


一、枚举类的使用   列举对象
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量对象时，强烈建议使用枚举类    （注：一组：互相联系，同一种类   常量：不可修改）
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。

 二、如何定义枚举类
  * 方式一：jdk5.0之前，自定义枚举类
  * 方式二：jdk5.0，可以使用enum关键字定义枚举类   说明：定义的枚举类默认继承于java.lang.Enum类
        例：
            enum Session{
            //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
            //没有属性的情况下          //有属性的情况下
                    对象的省略类型：public static final
                SPRING,     ----->      SPRING("春天"),
                SUMMER,     ----->      SUMMER("夏天"),
                AUTUMN,     ----->      AUTUMN("秋天"),
                WINTER;     ----->      WINTER("冬天");
            //提供默认的无参构造器       //2.声明Season对象的属性:private final修饰
              不用再声明了                   private final String seasonName;
                                        //3.私有化类的构造器,并给对象属性赋值
                                            private Season1(String seasonName){
                                                    this.seasonName = seasonName;
                                                }
                                        //4.其他诉求1：获取枚举类对象的属性
                                            public String getSeasonName() {
                                                return seasonName;
                                            }
            }

三、Enum类中的常用方法：
 *      values()方法：返回枚举类型的 *对象数组* 。该方法可以很方便地遍历所有的枚举值。
 *      valueOf(String str)：根据枚举类对象名称来获取 *枚举类对象* 。要求字符串必须是枚举类对象的“名字”。如
 *                          不是，会有运行时异常：IllegalArgumentException。
 *      toString()：返回当前枚举类对象常量的 *名称*

四、使用enum关键字定义的枚举类实现接口的情况
 *     情况一：实现接口，在enum类中实现抽象方法
 *     情况二：让枚举类的对象分别实现接口中的抽象方法