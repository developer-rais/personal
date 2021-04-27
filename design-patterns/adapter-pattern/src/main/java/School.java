public class School {
    public static void main(String[] args) {

        PenAdapter penAdapter=new PenAdapter();
        AssignmentWork assignmentWork=new AssignmentWork(penAdapter);
        assignmentWork.writeAssignment("Wring the first line ");
    }
}
