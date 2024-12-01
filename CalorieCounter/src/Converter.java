public class Converter {
    private Integer LenghtStep = 75;
    private Integer CallorySize = 50;
    public Integer getDistsnseCm(Integer steps){
        return (steps * this.LenghtStep);
    }
    public Double getDistsnseKm(Integer steps){
        return (getDistsnseCm(steps) * 0.00001);
    }
    public Integer getCallory(Integer steps){
        return (steps * this.CallorySize);
    }
    public Double getkilloCallory(Integer steps){
        return (getCallory(steps) * 0.001);
    }


}
