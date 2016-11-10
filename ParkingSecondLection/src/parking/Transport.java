package parking;

public abstract class Transport {
    protected String model;
    protected int number;

    public Transport(String model, int number) {
        this.model = model;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return number;
    }

    protected void move() {
        printAction(this + " move!");
    }

    protected void broke() {
        printAction(this + " broke!");
    }

    public void printAction(String message){
        System.out.println(message);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " model='" + getModel() + '\'' +
                ", number=" + number;
    }
}
