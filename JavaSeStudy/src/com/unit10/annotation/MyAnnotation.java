package com.unit10.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author shkstart
 * @create 2019 上午 11:56
 *
 * 自定义注解
 *
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";//value实际上是一个成员变量，只不过以无参数方法的形式来声明。
                    // 给了一个默认值     // 其方法名和返回值定义了该成员的名字和类型

                //类型： 类型只能是八种基本数据类型、String类型、Class类型、enum类型、
                        // Annotation类型、以上所有类型的数组。
}
