import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// GradingSystem class
public class GradingSystem implements Iterable<StudentAdm>{
    List<StudentAdm> studentsAdm = new ArrayList<>();
    List<Director> directs = new ArrayList<>();
    List<Professor> profs = new ArrayList<>();

    // Add a student to the system
    // The director of student's course is added as Monitor
    public StudentAdm addStudent(Student student) {
        StudentAdm studentAdm = new StudentAdm(student);
        studentsAdm.add(studentAdm);
        return studentAdm;
    }   

    // Add a director to the system
    // The director is added as monitor of the students in the same course
    public void addDirector(Course course) {
        for (StudentAdm studentAdm : studentsAdm) {
            if(studentAdm.getStudent().getCourse() == course){
                Director director = new Director(studentAdm, course);
                directs.add(director);
            }
        }
    } 

    public void addProfessor(Professor professor) {
        profs.add(professor);
    }


    public List<Director> getDirectors() {
        return directs;
    }

    public List<Professor> getProfessors() {
        return profs;
    }

    @Override
    public Iterator<StudentAdm> iterator() {
        return studentsAdm.iterator();
    }
    
}