public class Director extends Monitor{
    private Course degreeName;
    private StudentAdm stud;
    private Student st1;

    public Director (StudentAdm stud, Course course) {
        super(stud);
        if(course == stud.getStudent().getCourse()){
            this.degreeName = course;
        stud.addDiretor(this);
        }else{
            System.out.println("Error: Director's course must be the same as student's course");
        }
    }

    

    public Course getCourseName() {
        return degreeName;
    }



    @Override
    public void update(StudentAdm adm) {
        System.out.println("LEI director reports that student " + adm.getStudent() + " has changed the overall grade: " + adm.getStudent().getOverallGrade());
    }

}
