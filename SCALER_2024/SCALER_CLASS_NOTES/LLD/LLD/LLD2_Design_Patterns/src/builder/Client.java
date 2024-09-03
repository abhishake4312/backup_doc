package builder;

public class Client {
    public static void main(String[] args) {
        //version 1
//        Builder b = new Builder();
//        b.setName("abhi");
//        b.setBatch("march24");
//        b.setAge(20);
//        b.setPsp(75.5);
//        b.setGradYear(2024);
//
//       Student s=new Student(b);

        //version 2
//        Builder b=Student.getBuilder();
//        b.setName("abhi");
//        b.setBatch("march24");
//        b.setAge(20);
//        b.setPsp(75.5);
//        Student s=new Student(b);

        //version 3
//        Builder b=Student.getBuilder();
//        b.setName("abhi");
//        b.setBatch("march24");
//        b.setAge(20);
//        b.setPsp(75.5);
//        Student s=b.build();

        //version 4
        Student s=Student.getBuilder()
                        .setName("abhi")
                                .setAge(24)
                                        .setBatch("March24")
                                                .build();

        System.out.println("DEBUG");
    }
}
