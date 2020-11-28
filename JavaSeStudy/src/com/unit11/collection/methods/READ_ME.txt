
集合中都是以对象的形式存储数据

Collection接口中的方法的使用：
    这些方法是其所有子接口实现类所共有的

    1、添加
         add(Object obj)：将元素添加到集合中
         addAll(Collection coll)：将一个集合中的所有元素添加到另一个集合中
    2、获取有效元素的个数
         int size()：获取集合中元素个数
    3、清空集合
         void clear()
    4、是否是空集合
         boolean isEmpty()
    5、是否包含某个元素
         contains(Object obj):判断当前集合中是否包含obj，我们在判断时会调用obj对象所在类的equals()，
                              equals()函数重写前默认 ==（引用类型：比较地址），可以重写成比较内容的
         containsAll(Collection coll1):判断形参集合coll1中的所有元素是否都存在于当前集合中。
                                        也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较。
    6、删除
         boolean remove(Object obj) ：从当前集合中移除obj元素。
                                    通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素
         boolean removeAll(Collection coll)：取当前集合的差集   从当前集合中移除coll中所有的元素。
    7、取两个集合的交集
         boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c
    8、集合是否相等
         boolean equals(Object obj)
    9、转成对象数组：集合  -->  数组
         Object[] toArray()    对象数组
        拓展：数组（需要是一个对象数组） --->集合:调用Arrays类的静态方法asList()
    10、获取集合对象的哈希值
         hashCode()
    11、遍历
         iterator()：返回迭代器对象，用于集合遍历