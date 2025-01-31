/**************************************************************************************
*   ITESS-TICS 2025
*   ICPC-CP SRPING JAKARTA
*   by FJMP
*   Array: Exercise 1: student management
*   Programmer: FJMP
*   24/enero/2025
*
*   javac Exercise01DynamicArray.java
*   java Exercise01DynamicArray
**************************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student {
    public String name;
    public int standard;

    public Student() {
    }

    public Student(String name, int standard) {
        this.name = name;
        this.standard = standard;
    } 
    @Override
    public String toString() {
        return "[name: " + name + ", Standard: "  + standard + "]";
    }
} 

public class Exercise01DynamicArray<T> {
    private T[] data;
    private int n;

    public Exercise01DynamicArray(int n) {
        data = (T[]) new Object[n];
    
    }

    public Exercise01DynamicArray(Exercise01DynamicArray other) {
        this.n = other.n;
        this.data = (T[]) new Object[n];

        for(int i = 0; i < n; i++)
			data[i] = (T) other.data[i];
    }

    public int size() {
        return this.data.length;        
    }

    public Exercise01DynamicArray<T> add(Exercise01DynamicArray<T> arr2) {
        Exercise01DynamicArray<T> result = new Exercise01DynamicArray<>(this.n + arr2.n);

        for(int i = 0; i < this.n; i++)
			result.data[i] = (T) this.data[i];
        
        for(int i = 0; i < arr2.n; i++)
			result.data[i+this.n] = (T) arr2.data[i];

        return result;
    }

    public void add(T t) {
        if (n >= data.length) return;

        data[n] = t;
        n++;
    }

    public void set(T t, int index) {
        if (n >= data.length) return;
        data[index] = t;
    }

    public T get(int index) {
        // this must be exception out of bounds
        if (n >= data.length) return null;
        return data[index];
    }

    @Override
    public String toString() {
       
        StringBuilder osb = new StringBuilder();

        osb.append(data[0]);

        for(int i = 1; i < data.length; i++) {
			osb.append(" ");
            osb.append(data[i]);
        }

        return osb.toString();
    }

    public static void testStatic() {
        Student st1 = new Student("Juan", 10);
        Student st2 = new Student("Lau", 20);

        Exercise01DynamicArray<Student> eda1 = new Exercise01DynamicArray<>(3);
        eda1.add(st1);
        eda1.add(st2);

        // Data in first Dynamic array
        System.out.println("Data in first Dynamic array");
        System.out.println(eda1);

        // Deep copy, this does't exists in java. We can use clone or a constructor
        Exercise01DynamicArray<Student> eda2 = new Exercise01DynamicArray<>(eda1);
        System.out.println("Data in second Dynamic array");
        System.out.println(eda2);

        // Combines both classes and creates a bigger one
        Exercise01DynamicArray<Student> eda3 = eda1.add(eda2);
        System.out.println("Combined class: ");
        System.out.println(eda3);
    }
    public static void main(String args[]) throws IOException {
        int nStudents;
        BufferedReader r = new BufferedReader( new InputStreamReader(System.in));

        System.out.print("Enter number of students in class 1: ");
        nStudents = Integer.parseInt(r.readLine());
        
        Exercise01DynamicArray<Student> eda1 = new Exercise01DynamicArray<>(nStudents);
        for (int i = 0; i < nStudents; i++) {
            System.out.print("Enter name and class of student " + (i+1) + ": ");
            String line = r.readLine();
            String[] arrS = line.split(" ");
            Student student = new Student(arrS[0], Integer.parseInt(arrS[1]));
            eda1.add(student);
        }
	
        // Data in first Dynamic array
        System.out.println("Data in first Dynamic array");
        System.out.println(eda1);

        // Deep copy, this does't exists in java. We can use clone or a constructor
        Exercise01DynamicArray<Student> eda2 = new Exercise01DynamicArray<>(eda1);
        System.out.println("Data in second Dynamic array");
        System.out.println(eda2);

        // Combines both classes and creates a bigger one
        Exercise01DynamicArray<Student> eda3 = eda1.add(eda2);
        System.out.println("Combined class: ");
        System.out.println(eda3);
    }
}

