package org.jana;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //Initialize new objects individually
//        Car car = new Car();
//        Bike bike = new Bike();

        //Create common interface and just modify the 'Object' part or instantiation
//        Vehicle vehicle = new Bike();
//        vehicle.drive();

        //We may use both ApplicationContext or BeanFactory to get beans. ApplicationContext - preferred for enterprise level apps
        ApplicationContext context = new ClassPathXmlApplicationContext("file:C:\\SpringPractice\\MavenOne\\demo\\src\\spring.xml");

        Vehicle obj = (Vehicle) context.getBean("vehicle");
        obj.drive();
    }
}
