import java.util.ArrayList;
import java.util.Scanner;

class student{
    String name;
    int marks;
}
public class cgpa {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       ArrayList<student>stu=new ArrayList<student>();
        System.out.println("enter no.of student");
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            student s=new student();
            System.out.println("student"+(i+1));
            System.out.println("enter student name");
            s.name=sc.nextLine();
        System.out.println("enter marks");
        s.marks=sc.nextInt();
        sc.nextLine();
        stu.add(s);

    }
        int total=0;
        int highest=stu.get(0).marks;
        int lowest=stu.get(0).marks;
        for(int i=0;i<stu.size();i++){
            total=total+stu.get(i).marks;
            if(stu.get(i).marks>highest){
                highest=stu.get(i).marks;
            }
            if(stu.get(i).marks<lowest){
                lowest=stu.get(i).marks;
            }
        }
        double average=(double)total/stu.size();
        System.out.println("student report");
        for(int i=0;i<stu.size();i++){
            System.out.println("name"+" "+stu.get(i).name + " "+"marks:" +" "+ stu.get(i).marks);
        }
        System.out.println("average marks"+" "+average);
        System.out.println("higest marks"+" "+highest);
        System.out.println("lowest marks"+" "+lowest);
        sc.close();
}
}