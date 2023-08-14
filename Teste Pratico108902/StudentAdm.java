import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class StudentAdm {
    private Student student;
    private double media;
    private Professor professor;
    private List <Professor> professores = new ArrayList<>();
    private Director diretor;
    private HashMap<Professor,Double> scores = new HashMap<>();


    public StudentAdm(Student stud) {
        this.student = stud;
        this.professores = professores;
        this.diretor = diretor;
    }

    public void addScore(String className, double score) {
        student.addScore(className, (Double) score);    
        scores.put(getProfessor(className), score);

        diretor.update(this);

        for (Professor prof : scores.keySet()) {
            double score_atual = scores.get(prof);

            System.out.println("Professor " + prof.getName() + " of " + prof.getClassName() + " class evaluated student " + student + " with score: " + score_atual);
        }
    }

    public void addProfessor(Professor prof) {
        this.professores.add(prof);
    }

    public void addDiretor(Director d){
        this.diretor = d;
    }

    public Professor getProfessor(String className) {
        for (Professor prof : professores) {
            if (prof.getClassName().equals(className)) {
                return prof;
            }
        }
        return null;
    }

    public Student getStudent() {
        return student;
    }
    
}








