package rvt;
import java.util.HashMap;
public class IOU {
    HashMap<String, Double> person = new HashMap<>();
    public IOU() {
    }
    public void setSum(String toWhom, double amount) {
        person.put(toWhom, amount);
    }
    public double howMuchDoIOweTo(String toWhom) {
        if (person.get(toWhom) == 0) {
            return 0;
        } else {
            return person.get(toWhom);
        }
    }
    public static void main(String[] args) {
        IOU mattsIOU = new IOU();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Michael", 30);
        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael"));
    }
}