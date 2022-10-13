package Busines;

import DataAccsses.InstructorDao;
import Entities.Instructor;
import Logging.Logger;

import java.util.List;

public class InstructorManager {
    private InstructorDao instructorDao;
    private Logger [] loggers;
    private List<Instructor> instructors;

    public InstructorManager(InstructorDao instructorDao, Logger[] loggers) {
        this.instructorDao = instructorDao;
        this.loggers = loggers;
        this.instructors = instructors;
    }
    public void add(Instructor instructor) {
      instructorDao.add(instructor);
      for (Logger logger : loggers){
          logger.Log(instructor.getFirstName() + " " + instructor.getLastName());
      }

    }
}
