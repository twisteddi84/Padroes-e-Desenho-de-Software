public class Professor{
    private String className;
    private String name;

    public Professor(StudentAdm adm, String name, String className) {
        this.name = name;
        this.className = className;
        adm.addProfessor(this);
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public double getGrade(StudentAdm adm) {
        return adm.getStudent().getScore(className);
    }
}
