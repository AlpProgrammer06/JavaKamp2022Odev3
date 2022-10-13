import Busines.CategoryManager;
import Busines.CourseManager;
import Busines.InstructorManager;
import DataAccsses.HibernateCategoryDao;
import DataAccsses.HibernateCourseDao;
import DataAccsses.JdbcIstructorDao;
import Entities.Category;
import Entities.Course;
import Entities.Instructor;
import Logging.DataBaseLogger;
import Logging.FileLogger;
import Logging.Logger;
import Logging.MailLogger;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger [] logger ={new DataBaseLogger(),new FileLogger(), new MailLogger() } ;
        System.out.println( " EĞİTMEN ");
        System.out.println("------------------------");

        Instructor instructor = new Instructor(1, "Engin", "DEMİROĞ");
        InstructorManager instructorManager =new InstructorManager(new JdbcIstructorDao(),logger);
        instructorManager.add(instructor);

        System.out.println("----------------");
        System.out.println(" KURSLAR ");
        System.out.println("----------------");

        Course course1 = new Course(1,"Yazılım Geliştirici Yetiştirme Kampı(JAVA+REACT), 700);", 450);
        Course course2 = new Course(2,"Senior Yazılım Geliştirici Yetiştirme Kampı (C#+Angular", 400);
        Course course3 = new Course(3, "Yazılım Geliştirici Yetiştirme Kampı (JavaScript)", 350);


        // Course course4 = new Course(3, "Yazılım Geliştirici Yetiştirme
        // Kampı(JAVA+REACT)", 700);
        // bu kullanımı yaparsak course ismi aynı oldugu için hata mesajı atar.
        // Course course4 = new Course(3, "Yazılım Geliştirici Yetiştirme
        // Kampı2(JAVA+REACT)", -700);
        // bu kullanımı yaparsak kurs ücreti sıfırdan küçük olduğu için yine hata mesajı
        // alırız.

        List<Course> courseList = new ArrayList<>();
        CourseManager courseManager =new CourseManager(new HibernateCourseDao(),logger,courseList);
        courseManager.add(course1);
        courseManager.add(course2);
        courseManager.add(course3);

        // courseManager.add(course4);


        System.out.println("--------------");
        System.out.println(" KATEGORİ ");
        System.out.println("--------------");


        Category category1 =new Category(1,"Programlama1");
        Category category2 =new Category(2,"Programlama2");
        Category categor3 =new Category(3,"Programlama");

        List<Category> categories =new ArrayList<>();
        CategoryManager categoryManager =new CategoryManager(new HibernateCategoryDao(),logger,categories);
        categoryManager.add(category1);
        categoryManager.add(category2);
        categoryManager.add(categor3);







    }
}