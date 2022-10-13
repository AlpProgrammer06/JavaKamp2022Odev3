package Busines;

import DataAccsses.CourseDao;
import Entities.Course;
import Logging.Logger;

import java.util.List;

public class CourseManager {
    private CourseDao courseDao;
    private Logger[] loggers;
    private List<Course> courses;

    public CourseManager(CourseDao courseDao, Logger[] loggers, List<Course> courses) {
        this.courseDao = courseDao;
        this.loggers = loggers;
        this.courses = courses;
    }

    public void add(Course course) throws Exception {
        if (course.getCoursePrice() < 0) {
            throw new Exception("Kurs fiyatı 0 dan küçük olamaz.");
        }
        for (Course courses : courses) {
            if (courses.getCourseName().equals(course.getCourseName())) {
                throw new Exception("Aynı kurs ismi kullanılamaz.");
            }
        }
        courses.add(course);
        for (Logger logger : loggers) {
            logger.Log(course.getCourseName());
        }
    }
}
