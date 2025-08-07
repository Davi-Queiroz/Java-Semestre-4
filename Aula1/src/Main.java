import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Sensor> listSensor = new ArrayList<>();
        List<List<Double>> listaleitura = new ArrayList<>();

        for (int i = 0; i <= 3; i++) {
            listSensor.add(new Sensor(String.valueOf(i)));
            listaleitura.add(gerar(i));
        }

        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.processorSensores(listSensor,listaleitura);
        sistema.exibirRelatorio();
    }

    private static List<Double> gerar(int i) {
        Random r = new Random();
        List<Double> lista = new ArrayList<>();
        int total = 100;
        int limite = 60;

        switch (i){
            case 2 ->total=total/2;
            case 3 -> limite = limite*5;
        }
        for (int j = 0; j <= total; j++) {
            lista.add(r.nextDouble(-limite,limite));
        }
        return lista;
    }
}