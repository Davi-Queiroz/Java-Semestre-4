import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
     private List<Sensor> sensoresValidos;
     private List<ErroSensor> sensoresComErro;

     public SistemaMonitoramento(){
         this.sensoresComErro=new ArrayList<>();
         this.sensoresValidos = new ArrayList<>();
     }

     void processorSensores(List<Sensor> listaSensores, List<List<Double>> listaLeitura){
         for (int i = 0; i < listaSensores.size(); i++) {
             Sensor sensor=listaSensores.get(i);
             List<Double> leitura = listaLeitura.get(i);

             try {
                 sensor.registrarLeituras(leitura);
                 sensoresValidos.add(sensor);
             } catch (LeituraInvalida | IllegalArgumentException e) {
                 sensoresComErro.add(new ErroSensor(sensor.getId(), e.getMessage()));
             }
         }


     }
    void exibirRelatorio(){
        System.out.println("====== Sensores Validos ======");
        for(Sensor sensor : sensoresValidos){
            System.out.println("Sensor: "+sensor.getId());
        }
        System.out.println("\n ====Sensores com erro ====");
        for (ErroSensor sensor:sensoresComErro){
            System.out.println("Sensor: " + sensor.getIdSensor() + " --> " + sensor.getMensagemErro());
        }
    }
}
