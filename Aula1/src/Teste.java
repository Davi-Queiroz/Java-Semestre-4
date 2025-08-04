public class Teste {
    public static void main(String[] args) {
        int index = 10;
        double temperatura = -90;

        try {
            validar(index,temperatura);
        }catch (LeituraInvalida e){
            System.out.println(e.getMessage());
        }

    }

    private static void validar(int index, double temperatura) throws LeituraInvalida {
        if (temperatura<-60 || temperatura>60){
            throw new LeituraInvalida(index, temperatura);
        }
    }

}

