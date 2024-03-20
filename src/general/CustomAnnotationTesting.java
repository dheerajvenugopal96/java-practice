package dsa.src.general;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomAnnotationTesting {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = new CustomAnnotationTesting().getClass().getMethod("method2");
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());

        Method method2 = new CustomAnnotationTesting().getClass().getMethod("method3");
        EnumAnnotation enumAnnotation = method2.getAnnotation(EnumAnnotation.class);
        System.out.println("phone passed in annotation is: "+enumAnnotation.phone().toString());
        if(enumAnnotation.phone().price<20000){
            method2.invoke(new CustomAnnotationTesting());
        }else{
            Method method3 = new CustomAnnotationTesting().getClass().getMethod("method4");
            enumAnnotation = method3.getAnnotation(EnumAnnotation.class);
            System.out.println("You can buy "+enumAnnotation.phone().toString()+" at "+enumAnnotation.phone().price
            +". It has a rating of "+enumAnnotation.phone().rating+" stars.");
        }

    }

    @MyAnnotation(value = 23)
    public static void doSomething(){
        System.out.println("This method has myannotation added");
    }

    @MyAnnotation
    public void method2(){
        System.out.println("This method has annotation but takes default annotation value");
    }

    @EnumAnnotation(phone=Phones.IPHONE_10)
    public void method3(){
        System.out.println("call this method only if iphone is launched below 40000");
    }

    @EnumAnnotation(phone=Phones.S24_ULTRA)
    public void method4(){

    }
}