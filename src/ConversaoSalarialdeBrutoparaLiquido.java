import java.util.Scanner;

public class  ConversaoSalarialdeBrutoparaLiquido{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira teu nome: ");
        String nomeFuncionario = scanner.nextLine();

        System.out.println("Insira teu departamento");
        String departamentoFuncionaro = scanner.nextLine();

        System.out.println("Bem vindo " +nomeFuncionario);
        System.out.println("Seu departamento "+ departamentoFuncionaro+ " já depositou teu pagamento!");
        System.out.println("------------------------------------------------");
        System.out.println("Acompanhe abaixo teu holerite!");


        System.out.print("Insira o salário bruto: ");
        double salarioBruto = scanner.nextDouble();

        System.out.println("Você fez quantas horas extras esse mês?");
        double horasExtras = scanner.nextDouble();

        double descontoINSS = calculoDescontoINSS(salarioBruto);
        double descontoIR = calculoDescontoIR(salarioBruto - descontoINSS);
        double adicionalHorasExtras = calculoHorasExtras(horasExtras);
        double salarioLiquido = salarioBruto - descontoINSS - descontoIR + adicionalHorasExtras;


        System.out.println("-------------CONTABILIDADE----------");
        System.out.println("_____________________________________");

        System.out.println("Seu salário atual é de " + salarioBruto);

        System.out.println("----------------DESCONTOS--------------");

        System.out.println("Desconto INSS: R$ " + descontoINSS);
        System.out.println("Desconto Imposto de Renda: R$ " + descontoIR);

        System.out.println("-------------------ADICIONAIS----------------");
        System.out.println("Horas extras calculadas " + adicionalHorasExtras);


        System.out.println("-----------------SALDO LIQUIDO------------");
        System.out.println("Salário Líquido: R$ " + salarioLiquido);

        System.out.println("Tenha um ótimo inicio de mês!");

        scanner.close();
    }

    public static double calculoDescontoINSS(double salarioBruto) {

        double descontoINSS;

        //dica: O Governo Federal atualiza o seu teto do INSS todos os anos. Em 2024, o teto do INSS é R$ 7.786,02.

        if(salarioBruto <= 1212.0 ) {
            descontoINSS = salarioBruto * 0.075;
        } else if (salarioBruto <= 2427.35) {
            descontoINSS = salarioBruto * 0.09;
        } else if (salarioBruto <= 3641.03) {
            descontoINSS = salarioBruto * 0.12;
        } else {
            descontoINSS = salarioBruto * 0.014;
        }

        return descontoINSS;

    }



    public static double calculoDescontoIR(double salarioComDesconto) {

        double descontoIR;

        if(salarioComDesconto <= 1903.98 ) {
            descontoIR = 0.0;
        } else if (salarioComDesconto <= 2826.65) {
            descontoIR = salarioComDesconto * 0.075;
        } else if (salarioComDesconto <= 3751.05) {
            descontoIR = salarioComDesconto * 0.15;
        } else if (salarioComDesconto <= 4664.68) {
            descontoIR = salarioComDesconto * 0.225;
        } else {
            descontoIR = salarioComDesconto * 0.275;
        }

        return descontoIR;

    }


    public static double calculoHorasExtras(double horasExtras) {

        double horasAdicionais;

        if(horasExtras <= 0.5 ) {
            horasAdicionais = 15.0;
        } else if (horasExtras <= 1.0) {
            horasAdicionais = 20.50;
        } else if (horasExtras <= 2.0) {
            horasAdicionais = 100.00;
        } else {
            horasAdicionais = 150.0 + (horasExtras - 2.0) * 20.0;
        }

        return horasAdicionais;

    }

}





