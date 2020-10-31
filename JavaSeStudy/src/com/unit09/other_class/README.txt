* 其他常用类的使用
 *      1.System类
            System类代表系统，构造器是private的，无法实例化，成员变量和成员方法都是static的。

            成员变量：
                System类内部包含in、out和err三个成员变量，分别代表标准输入流(键盘输入)，
                标准输出流(显示器)和标准错误输出流(显示器)。

            成员方法：
                void gc()： 该方法的作用是请求系统进行垃圾回收。至于系统 是否立刻回收 ，则
                            取决于系统中垃圾回收算法的实现以及系统执行时的情况。
                String getProperty(String key)： 该方法的作用是获得系统中属性名为key的属性对应的值。
                void exit(int status)： 该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表
                异常退出。
                native long currentTimeMillis()： 该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时
                间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数。




 *      2.Math类
            其方法的参数和返回值类型一般为double型。
            常用方法：
                abs 绝对值
                acos,asin,atan,cos,sin,tan 三角函数
                sqrt 平方根
                pow(double a,doble b) a的b次幂
                log 自然对数
                exp e为底指数
                max(double a,double b)
                min(double a,double b)
                random() 返回0.0到1.0的随机数
                long round(double a) double型数据a转换为long型（四舍五入）
                toDegrees(double angrad) 弧度—>角度
                toRadians(double angdeg) 角度—>弧度


 *      3.BigInteger 和 BigDecimal
            BigInteger可以表示不可变的任意精度的整数。  长度不限，用来表示很大很大的整数
            构造器：
                BigInteger(String val)：根据字符串构建BigInteger对象

            BigDecimal类支持不可变的、任意精度的有符号十进制定点数。   精度不限
            构造器 ：
                public BigDecimal(double val)
                public BigDecimal(String val)