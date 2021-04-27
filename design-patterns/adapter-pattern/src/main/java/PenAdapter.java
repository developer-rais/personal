public class PenAdapter implements Pen {

    private PilotPen pilotPen=new PilotPen();

    public PilotPen getPilotPen() {
        return pilotPen;
    }

    public void setPilotPen(PilotPen pilotPen) {
        this.pilotPen = pilotPen;
    }

    public void write(String string) {
        pilotPen.mark(string);

    }
}
