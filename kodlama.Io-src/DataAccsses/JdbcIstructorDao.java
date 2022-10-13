package DataAccsses;

import Entities.Instructor;

public class JdbcIstructorDao implements InstructorDao{



    @Override
    public void add(Instructor instructor) {
        System.out.println("Jdbc ile eklendi. " + instructor.getFirstName() + " " + instructor.getLastName());

    }
}
