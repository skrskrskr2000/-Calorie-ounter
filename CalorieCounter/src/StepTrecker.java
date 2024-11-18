import java.util.HashMap;

public class StepTrecker {

    private HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    private Integer steps = 10000;

    public StepTrecker() {
        for (int i = 1; i < 13; i++) {
            this.monthToData.put(i, new MonthData());
        }
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps,Integer day,Integer mounth) {
        if (steps>0){
        this.steps = steps;
        this.monthToData.get(mounth).setStepsinDay(day,steps);
        this.monthToData.get(mounth).printAllData();
        } else {
            System.out.println("Ты ебанутый? Назад чтоль шагал?");
        }

    }
}
class MonthData {
    private HashMap<Integer, Integer> stepsToData = new HashMap<Integer, Integer>();
    public MonthData() {
        for (int i = 1; i < 31; i++) {
            this.stepsToData.put(i, 0);
        }
    }

    public void setStepsinDay(Integer day, Integer steps){
        this.stepsToData.put(day,steps);
    }

    public Integer getStepsinDay(Integer day){
        return this.stepsToData.get(day);
    }

    public void printAllData(){
        System.out.println(this.stepsToData);
    }



}

