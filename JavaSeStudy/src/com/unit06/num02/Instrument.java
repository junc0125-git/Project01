package com.unit06.num02;

/**
 * @author cj
 * @create 2020-10-07 17:20
 *
 * 请使用接口编码实现如下需求：乐器（Instrument）分为：钢琴(Piano)、小提琴(Violin).
 * 各种乐器的弹奏（ play ）方法各不相同。编写一个测试类InstrumentTest，
 * 要求：编写方法testPlay，对各种乐器进行弹奏测试。要依据乐器的不同，进行相应的弹奏。
 * 在main方法中创建不同的乐器对象，通过testPlay的弹奏测试方法进行测试。
 */
public interface Instrument {
    void paly();
}
