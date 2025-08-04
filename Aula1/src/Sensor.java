import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<Double> leituras;
    private String id;

    public List<Double> getLeitura(){
        return leituras;
    }

    public Sensor(List<Double> leituras, String id) {
        this.leituras = new ArrayList<>();
        this.id = id;
    }

    void registrarLeituras(List<Double> leituras) throws LeituraInvalida{
    if (leituras.size() != 100){
        throw new IllegalArgumentException("O total de leitruas deve ser 100");
    }
        for (int i = 0; i < leituras.size(); i++) {
            double temp = leituras.get(i);
            if (temp<-60 || temp > 60){
                throw new LeituraInvalida(i,temp);
            }
        }
    }
    String getId(){
        return "aaa";
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "leituras=" + leituras +
                ", id='" + id + '\'' +
                '}';
    }
}
