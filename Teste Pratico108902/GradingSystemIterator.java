import java.util.Iterator;
import java.util.List;
public class GradingSystemIterator implements Iterator<StudentAdm>{
    private List<StudentAdm> studentsAdm;
    private int index = 0;

    public GradingSystemIterator(List<StudentAdm> studentsAdm) {
        this.studentsAdm = studentsAdm;
    }

    @Override
    public boolean hasNext() {
        return index < studentsAdm.size();
    }

    @Override
    public StudentAdm next() {
        return studentsAdm.get(index++);
    }

    public Iterator<StudentAdm> iterator() {
        return new GradingSystemIterator(studentsAdm);
    }
    
}
