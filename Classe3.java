public class Classe3 {
    private static final String[] operadoresMatematicos = {"Soma", "Subtração", "Multiplicação", "Divisão"};

    public static String[] pegarOpcoes() {
        return operadoresMatematicos;
    }

    public static String processarDados(float fltInputUsuario1, float fltInputUsuario2,int opcaoEscolhida){
        float resultado = 0;
        switch(opcaoEscolhida){
        case 0:
            resultado = somar(fltInputUsuario1,fltInputUsuario2);
            break;
        case 1:
            resultado = subtrair(fltInputUsuario1, fltInputUsuario2);
            break;
        case 2:
            resultado = multiplicar(fltInputUsuario1, fltInputUsuario2);
            break;
        case 3:
            resultado = dividir(fltInputUsuario1, fltInputUsuario2);
            break;
        default:
            break;
        }
        return String.valueOf(resultado);
    }

    public static float somar(float numero1, float numero2) {
        return numero1 + numero2;
    }

    public static float subtrair(float numero1, float numero2) {
        return numero1 - numero2;
    }

    public static float multiplicar(float numero1, float numero2) {
        return numero1 * numero2;
    }

    public static float dividir(float numero1, float numero2) {
        return numero1 / numero2;
    }

    
        

    }
    


