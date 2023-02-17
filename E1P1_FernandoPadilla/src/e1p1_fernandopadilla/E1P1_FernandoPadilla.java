package e1p1_fernandopadilla;

import java.util.Scanner;

public class E1P1_FernandoPadilla {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1.Numero Valido");
            System.out.println("2.Reordenado de Cadenas");
            System.out.println("3.Trigonometria");
            System.out.println("4.Salida");
            opcion = read.nextInt();

            switch (opcion) {
                case 1:
                    String num;
                    System.out.println("Ingrese el numero que desea validar: ");
                    read.nextLine();
                    num = read.nextLine();
                    Num_valido(num);
                    break;

                case 2:
                    String str;
                    System.out.println("Ingrese la cadena que desea reordenar: ");
                    read.nextLine();
                    str = read.nextLine();
                    Reorden_cadena(str);
                    break;

                case 3:
                    double angulo;
                    int precision;
                    System.out.println("Ingrese el angulo (grados) que desea calcular: ");
                    angulo = read.nextDouble();
                    System.out.println("Ingrese la precision deseada: ");
                    precision = read.nextInt();
                    Trigonometria(angulo,precision);
                    break;

                case 4:
                    opcion = 4;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
    }

    //metodo numero valido
    public static void Num_valido(String num) {
        boolean vof = true;
        if (num.indexOf("-") > 0) {
            vof = false;
        }else{
            vof = true;
        }
        if (vof){
            System.out.println("El numero es valido");
        }else{
            System.out.println("El numero no es valido");
        }
    }

    //metodo reordenar cadena
    public static void Reorden_cadena(String str) {
        String acumn = "";
        String acuml = "";
        String acuml2 = "";
        String acums = "";
        
        //separar numeros
        for (int i = 0;i < str.length(); i++){
            char lettern = str.charAt(i);
            int numletter = lettern;
            if (numletter >=48 && numletter < 58){
                acumn = acumn + lettern;
            }
        }
        //separar letras mayusculas
        for (int i = 0;i < str.length(); i++){
            char letterm = str.charAt(i);
            int numletterm = letterm;
            if (numletterm >=65 && numletterm < 91){
                acuml2 = acuml2 + letterm;
            }
        }
        //separar letras minusculas
        for (int i = 0;i < str.length(); i++){
            char letterl = str.charAt(i);
            int numletterl = letterl;
            if (numletterl >=97 && numletterl < 123){
                acuml = acuml + letterl;
            }
        }
        //separar caracteres
        for (int i = 0; i < str.length(); i++) {
            char letters = str.charAt(i);
            int numletters = letters;
            if (numletters >= 1 && numletters < 47 || numletters >=58 && numletters <65||numletters >=91 && numletters <96|| numletters >=123) {
                acums = acums + letters;
            }
        }
        String result = acumn + acuml + acuml2 + acums;
        System.out.println("String reordenado: "+result);
    }

    //metodo sumatoria
    public static void Trigonometria(double angulo,int precision) {
        double z = (angulo*Math.PI)/180;
        double sumatoria = 0;
        double numerador = 0;
        double denominador = 0;
        double acumulador = 1;
        int contador = 1;
        for (int i = 0; i<= precision; i++){
            numerador = (Math.pow(-1, i))*Math.pow(z,((2*i)+1)) ;
            denominador = ((2*i)+1);
            while (contador <= denominador){
                acumulador *= contador;
                contador++;
            }
           sumatoria = sumatoria + (numerador/acumulador);
        }
        System.out.println("sin"+ "("+z+")"+"= "+sumatoria);
    }
}
