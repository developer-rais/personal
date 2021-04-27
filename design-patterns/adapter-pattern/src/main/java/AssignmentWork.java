public class AssignmentWork {

    private Pen pen;

    public AssignmentWork(Pen pen) {
        this.pen = pen;
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment(String string)
    {
        pen.write(string);
    }
}
