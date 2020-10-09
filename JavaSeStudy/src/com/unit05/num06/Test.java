package com.unit05.num06;

/**
 * @author cj
 * @create 2020-10-03 16:20
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        Vehicle car = new Car();
        Vehicle plane = new Plane();
        Vehicle ship = new Ship();
        t.testMove(car);
        t.testMove(plane);
        t.testMove(ship);
    }

    public void testMove(Vehicle v) {
        v.move();
    }
}
