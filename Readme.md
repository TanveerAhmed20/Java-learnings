# Important features of java 8

- Lambda expressions
- Functional Interfaces
- Default methods in interfaces
- Static methods in interfaces
- Predicate
- Function
- Consumer
- Method Reference & constructor Reference By double color (::) operator
- Stream API
- Date & time API (Joda API)

What is functional Interface ?

An interface which only contains one abstract method

examples : runnable , callable , comparable ,

```java
// Functional Interface
interface Inter{
    public void m1() ;
    default void m2 (){

    }
    public static void m3(){

    }
}

// only Interface but not functional

interface Interf{
    public void m1();
    public void m2();
    // This has two abstract methods;
}

```

Note : Annotations are part of Java 1.8

```java
@FunctionalInterface
interface Interf{
    public void m1() ;
    default void m2 (){

    }
    public static void m3(){

    }
}
```

Check java version

```java
javac -version
```

Check jvm version

```java
java -version
```

If parent interface contains a functional interface but the child interface does not contain any functional interface then automatically the child interface will be called functional interface

##### Invoking Lambda expression by using Functional Interface examples 2, 3 ,4

```java
interface Interf
{
    public void add(int a, int b );
}

class Demo implements Interf {
    public void add (int a , int b ){
        system.out.println(a+b)
    }
}

class Tes1{
    psvm (string[] args1){
        Interf i = new Demo ();
        i.add(10,20);
        i.add(100,200);
    }
}

// writing above code with lambda expression


interface Interf
{
    public void add(int a, int b );
}

class Demo implements Interf {
    public void add (int a , int b ){
        system.out.println(a+b)
    }
}

class Tes1{
    psvm (string[] args1){
        Interf i = new Demo ();
        i.add(10,20);
        i.add(100,200);
    }
}
```

#### Runnable

Runnable interface consist of only one method which is the runnable method
The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.

```java

class myRunnable implements Runnable {
    public void run (){
        for(int i =0;i<10;i++){
            system.out.println("CHILD THREAD");
        }
    }
}

class ThreadsDemo{
     public static void main(String[] args){
        Runnable r  = new myRunnable();

        Thread  t = new Thread(r);
        t.start(); // after this two threads are started child and main thread
        for(int i=0;i<10;i++){
            system.out.println("MAIN THREAD");
        }
     }
}


//Above application using lambda expression 

class ThreadsDemo2 {
    public static void main(String[] args) {
        Runnable r = () ->{
             for(int i =0;i<10;i++){
                system.out.println("Lambda Expression CHILD THREAD");
            }
        }
        Thread t = new Thread(r);
        for(int i=0;i<10;i++){
            system.out.println("MAIN THREAD");
        }
    }
}

```

##### Functional Interface , Lambda Expressions Summary 


**Functional Interface** 
- It shoould contain exactly one abstract method 
- It can contain any number of default and stait cmethods 
- It acts as a type for lambda expression 
```java
//  example
Interf i = ()-> Sout("hello")

```
- It can be used to invoke lambda expression 


Question : why functional interface should contian only one abstract method ? 

Answer : Error-CE: Then we will get incompatible type error


--- 

## COLLECTIONS OVERVIEW : LIST AND SET
List ordering is preserved 
In hashset ordering is not preserved

```java
HashMap<String , String > m = new HashMap<String , String>();
```

```java

``` 

##### Sorting Elements of ArrayList with Lambda Expression

```java

Collection.sort(list , (I1,I2)->(I1 > I2) ? -1 : (I1< I2) ? 1  : 0 )



```
---  
#### sorting elements of treeset with lambda expression

TreeSet is set implementatino class , 
if we need sorting order then tree Set automatically orders

```java
TreeSet<Integer> t = new TreeSet<Integer>();
t.add(10);
t.add(0);
t.add(15);
t.add(10);
t.add(23);
t.add(5);
t.add(0);
t.add(0);
t.add(10);
system.out.println(t)


```

---  
#### sorting elements of treeMAp with lambda expression

TreeSet is set implementatino class , 
if we need sorting order then tree Set automatically orders

```java
package java8;
import java.util.TreeMap;

public class Tut_5_TreeMap_withLambda {
	public static void main(String[] args) {
		TreeMap<Integer, String> m = new TreeMap<Integer, String>();
		m.put(100, "Durga");
		m.put(600, "Sunny");
		m.put(300, "Bunny");
		m.put(200, "Chinny");
		m.put(700, "Vinny");
		
		
	}
}


```

---

#### Sorting of Our own class objects with Lambda Expression
```java

class Employee {
	int eno;
	String ename; 
	
	Employee(int eno , String ename){
		this.eno = eno ; 
		this.ename = ename;
	}
	public String toString(){
//		oVERRIDING toString method 
		// without overriding we get only the address of the object
		return eno + ": " + ename;  
	}
}
public class Tut_6_sorting_CLassObject_with_lambda {
	public static void main(String[] args){
	    // Employee e = new Employee(100,"tanveer");

        Employee e = new Employee ()

        ArrayList<Employee> l = new ArrayList<Employee>();
        l.add(new Emloyee(111),"Dipika");
        l.add(new Emloyee(100),"Dipika");
        l.add(new Emloyee(101),"Dipika");
        l.add(new Emloyee(200),"Dipika");
        

        Collection.sort(l,(e1,e2)->(e1.eno < e2.eno>) ? -1 : (e1.eno > e2.eno) ? 1: 0 )
	    System.out.println(e);
	 }
}
```

Note : Where ever there is functional interface we can happily replace it with lambda expressions 


--- 

### Annonymous Inner Class Vs Lambda Expression 

```java 
// using annonymous Inner class 
class ThreadsDemo{
    public static void main(String[] args){
        Runnable r  = new Runnable(){
            public void run (){
                for(int i=0;i<10;i++){
                    System.out.println(i);
                }
            }
        }

        Thread t = new Thread(r);
        t.start();

        for(int i=0;i<10;i++){
            System.out.println(i);
        }


    }
}


// USing Lambda functions 
class ThreadsDemo2{
    public static void main (String[] args)
    {
        Runnable r  = ()->{
          for(int i=0;i<10;i++){
                    System.out.println(i);
                }
        }

    }
    Thread t = new Thread(r);
    t.start();

    for(int i=0;i<10;i++){
        System.out.println(i);
    }

}
```

Note : Not all anonymous can  not be replaced with lambda expressions **Lecture 22**

#### Scope of instance variables in Inner Class vs Lambda Expression 

```java 
interface Interf{
    public void m1();
}
class Test{
    int x = 888;
    public void m2(){

        Interf i = new Interf(){
        // annonymous inner class
            int x = 999; // instance varible of anonymous inner class
            public void m1(){
                System.out.println(this.x); // 999
            }
        }
        i.m1();

    }
     public static void main(String[] args){
        Test t = new Test();
        t.m2();
     }
}
// inside anonyous inner class this refers to the current class  only 

```


### difference between anonymouse inner class and lambda expression 

## Plugins

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |


















#### Advantages of lambda expressions

- we can enable functional programming in java 
- we can reduce length of the code so that readability will be improved 
- we can resolve complexity of anonymous inner classes until some extent 
- we can handle procedures/ functions just like values 
- we can pass procedures / functions as arguments 
- easier to use updated API's and libraries 
- Enable support for parallel processing 


--- 

### Default methods and static methods in interfaces 

- Every variable inside an interface is public static and final 
- every method inside an interface is public abstract 


##### What are default methods : 

```java
interface I{
    default public void defaultmethod(){
        // default method needs to have definition
        System.out.println('Default method')
    }
}

```

Advantages of default methods : 
- child classes now don't need to forcefully provide implementation of this method , It's present in this interface by default.

```java

interface Interf{
    default void m1(){
        sout('default method')
    }
}
class Test implements Interf{
    psvm(){
        Test t = new Interf() ; 
        sout(t.m1());
    }
}

// You can have your own implementation 
class Test2 implements Interf{
    public void m1(){
        sout('my own implementation');
    }
    psvm(){
        Test t = new Interf() ; 
        
        sout(t.m1());
    }
}

```



#### Difference between Inteface with default methods and abstract classes

```java 
interface Left {
    default void m1(){
        sout('left default method');
    }
}
interface Left {
    default void m1(){
        sout('left default method');
    }
}

class Test implements Left, Right{
    // Error : ambiguity of Left and Right Interface


    // method 1 to fix ambiguity
    public void m1(){
        sout('my own implemnetation')
    }

    // method 2 to fix ambiguity
    public void m1(){
        Left.super().m1();
    }
}

```


| Interface with default methods | Abstract Class |
| ------ | ------ |
|Inside interface every variable is always public, static and final and we cannot declare instance variables | Inside abstract class we can declare instance varibles , which are required to the child class|
| Interface never talks about state of object| Abstract class can talk about state of object|
| inside interface we cant| [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |




##### Static methods inside interface 
```java 
interface Interf{
    public static void m1(){
        sout('inferface static method')
    }
}
class Test implements Interf{
    psvm(String args[]){
        Test t = new Test () ;
        t.m1(); // Incorrect 
        Test.m1(); // Incorrect
        Interf.m1(); // Correct
    }
}

// 

/// Example 1 : Correct 
interface Interf {
    public static void m1(){

    }
}

class Test implements Interf{
    public static void m1(){

    }
}

// Example 2 : Workds 
interface Interf {
    public static void m1 (){

    }
}

class Test implements Interf{
    public void m1(){
        // not a concept of overriding , due to m1 being static in the interface 
    }
}

// example 3 : Works 

interface Interf {
    public static void m1(){

    }
}
class Test implements Interf{
    private static void m1(){

    }
}


// Conclusion : interface static method is not available to the implementation classes

```

**Note** : After java 1.8 version we can declare main method inside an interface


--- 

#### Predefined Functional Interface 
Introduced in 1.8 Version

- Predicate : reutrns true or false based on a condidition. It's a boolean valued function 

```java 
public boolean test (Integer I ){
    if( I > 10){
        return true;
    }
    else return false ;
}

//  lambda code
(Integer I )->{
    if(I > 10 )return true ; 
    else return false ;
}

// or 
I-> I>10


public class Predicates_28 {
	public static void main(String[] args) {
		Predicate<Integer> P = I-> I>10;
		System.out.print(P.test(100));
		System.out.print(P.test(5));
		
		
		Predicate<String> p2 = s->s.length()>5;
		System.out.println(p2.test("abcded"));
		System.out.println(p2.test("abc"));
		
		
		Predicate<Collection> p3 = c-> c.isEmpty();
		ArrayList<Integer> ar = new ArrayList();
	}
	
}



```


##### Predicate Joining : 

```java 
int[] x = 
```


Q . program to display name stars with 'k' by using predicate: 

```java 
String[] names = ["Tanveer","Loves","Juhi"];
Predicate<String> startsWithK = s->s.charAt(0) == 'k';
for(String s : names){
    if(startsWithK.test(s)){
        Sout(s);
    }
}
```


Q. remove null values and empty strings from 

```java
String[] names = ["Durga", "" ,null, "ravi"," "]

Predicate<String> p= s->s!=null && s.length()!=0;
ArrayList<String> l = new ArrayList<String>();

for(string s : names){
    if(p.test(s){
        l.add(s)
    })
}

sout(l)
```

--- 

```java
 class Test{
    public static void main (String[] args){
        Predicate<User> p = user->user.username.equals("durge") && user.pwsd.equals("java");
        Scanner sc = new Scanner(System.in);
    }
}
```

####  Predicate interface isEqual() method

```java 
Predicate<String> p = Predicate.isEqual("DurgaSoft");
System.out.println(p.test("DurgaSoft")); // true
System.out.println(p.test("DurgaHard")); // false

```


----

#### Streams

IO Streams and Collection Streams are different
```java 
ArrayList<Integer> l = new ArrayList<Integer>();
l.add(0);
l.add(1);
l.add(2);
l.add(3);
l.add(4);
l.add(5);

// Without Streams 
List<Integer> l1 = new ArrayList<Integer>();
for(Integer I1: l ){
    if(I1%2 ==0 ){
        l1.add(I1);
    }
}

// with streams 
List<Integer> l2 = l.stream().filter(i->i%2==0).collect(Collectors.toList());



```

// Collection streams 

```java

Stream s = c.stream();

```


##### Filtering 
- IF we want to filter elemnets from the collection based on some boolean condition then we should go for filtering 
- We can configure Filter by using filter() method of Stream interface 

- `public steram filter(Predicate<T> t )`

```java

Stream s1 = c.stream().filter(i->i%2==0);

```

##### Mapping 

- if we want to create a seperate new object for evrey object present in the collection based on some function then we should go for mapping mechanism 

- we can implement mapping by using map() method of stream interface 

- `public stream map(Function<T,R> f )`

eg : Stream s1 = c.stream().map()

###### Processing by collect method 

This method collects te elemnts from the stream and addin gto the specified colelction 

eg : 
```java 
ArrayList<String> l = new ArrayList<String>();
l.add("Pavan");
l.add("Ravi Teja");
l.add("Chiranjeev");
l.add("Venkatesh");
l.add("Nagarjun");

System.out.println(l)

List<String> newlist  = l.stream().map(s->s.toUpperCase()).collect(Collectors.toList());

```

###### Processing by count method 

The method reutrns the numebr of elements present in the stream 

```java 

public long count;

ArrayList<String> l = new ArrayList<String>();
l.add("Pavan");
l.add("Ravi Teja");
l.add("Chiranjeev");
l.add("Venkatesh");
l.add("Nagarjun");

System.out.println(l)

count   = l.stream().filter(s->s.length() >=9 ).count();

```

###### Processing by sorted method 

```java
List<Integer> l1 = l.stream().sorted().collect(Collectors.toList())

//reverse order
List<Integer> l2 = l.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList())



```



