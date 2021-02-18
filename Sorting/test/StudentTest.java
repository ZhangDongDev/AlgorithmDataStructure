import org.junit.jupiter.api.Test;

class StudentTest {

    Comparable getMax(Student s1, Student s2) {
        int i = s1.compareTo(s2);
        if (i >= 0) {
            return s1;
        } else  {
            return s2;
        }
    }
    @Test
    void testComparable() {
        Student s1 = new Student("zhangsan", 22);
        Student s2 = new Student("lisi", 18);
        Comparable max = getMax(s1, s2);
        System.out.println("max = " + max);


    }


}