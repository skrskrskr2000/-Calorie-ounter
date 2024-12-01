import java.util.HashMap;

public class StepTrecker {

    private HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
    private Integer steps;
    private Integer stepTarget = 10000;

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
        //this.monthToData.get(mounth).printAllData();
        } else {
            System.out.println("Ты ебанутый? Назад чтоль шагал?");
        }

    }

    public void setStepTarget(Integer stepTarget) {
        this.stepTarget = stepTarget;
    }

    public Integer getStepTarget() {
        return stepTarget;
    }

    public void printDataonMounth(Integer mounth){

        Integer sum = 0;

        Integer MaxSteps = 0;

        Integer MaxStepsDay = 0;

        Integer bestEpisode  = 0;

        Integer maxBestEpisode  = 0;



        Converter converter = new Converter();

        for (Integer days: this.monthToData.get(mounth).getStepsToData().keySet()){
            System.out.print(days + "день: "+this.monthToData.get(mounth).getStepsToData().get(days));
            sum += this.monthToData.get(mounth).getStepsToData().get(days);
            if (days != 30){
                System.out.print(", ");
            } else {
                System.out.print("\n");
            }
            if (MaxSteps<this.monthToData.get(mounth).getStepsToData().get(days)){
                MaxSteps=this.monthToData.get(mounth).getStepsToData().get(days);
                MaxStepsDay = days;
            }
        }


        System.out.println("Общее число шагов: " + sum);
        System.out.println("Максимальное количество шагов: "+MaxSteps+" в "+MaxStepsDay+" день");
        if (sum!=0){
            System.out.println("Среднее число шагов: "+sum/30);
        }else{
            System.out.println("Среднее число шагов: 0");
        }

        System.out.println("Пройденная дистанция: "+ converter.getDistsnseKm(sum)+" км");
        System.out.println("Сожженных киллокаллорий: "+ converter.getkilloCallory(sum)+"ККал");

        for (Integer days: this.monthToData.get(mounth).getStepsToData().keySet()){
            if (days==1) {
                continue;
            }

            if (this.monthToData.get(mounth).getStepsToData().get(days)<this.stepTarget){
                if (maxBestEpisode<bestEpisode){
                    maxBestEpisode=bestEpisode;
                    bestEpisode = 0;
                }
                continue;
            }

            if (this.monthToData.get(mounth).getStepsToData().get(days)>=this.stepTarget){
                bestEpisode++;
            }
        }
        if (maxBestEpisode<bestEpisode){
            maxBestEpisode=bestEpisode;
        }

        System.out.println("Лучшая серия: "+maxBestEpisode+" дней.");


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
        if (day<=30){
            this.stepsToData.put(day,steps);
        }
    }

    public Integer getStepsinDay(Integer day){
        return this.stepsToData.get(day);
    }

    public void printAllData(){
        System.out.println(this.stepsToData);
    }


    public HashMap<Integer, Integer> getStepsToData() {
        return stepsToData;
    }
}

