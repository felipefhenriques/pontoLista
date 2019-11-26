package AtvPontos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
import java.util.Scanner;
    
public class Main {
    
    // Menu visual
    static void Menu(){
        System.out.println("\n---Menu---");
        System.out.println("1- Adicionar novo elemento \n"
                          +"2- Adicionar novo elemento na posição X \n"
                          +"3- Buscar posição do elemento \n"
                          +"4- Remover ponto da posição \n"
                          +"5- Maior distancia entre pontos\n"
                          +"6- Pontos validos na circuferencia\n"
                          +"7- Encerrar \n");
        
}
    //Chamada de métodos e impressão dos dados pedidos no menu
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int x, y, tamnho = 30;
        ListaPonto pontos = new ListaPonto(tamnho);
        int resp=0;
        while(resp<7){
            Menu();
            System.out.print("Escolha opção desejada: ");
            resp = entrada.nextInt();
            switch(resp){
                case 1:
                    System.out.println("\nPontos");
                    System.out.print("Indique o ponto X: ");
                    x = entrada.nextInt();
                    System.out.print("Indique o ponto Y: ");
                    y = entrada.nextInt();
                    Ponto cod = new Ponto(x,y);
                    pontos.AddPonto(cod);
                    pontos.Impm();
                    break;
                case 2:
                    System.out.print("\nIndique a posição a ser usada: ");
                    int posicao = entrada.nextInt();
                    if(posicao>tamnho || posicao<=0){
                        System.out.println("Posição " +posicao+ "  invalida.");
                    }
                    else{
                        System.out.println("\nPontos");
                        System.out.print("Indique o ponto X: ");
                        x = entrada.nextInt();
                        System.out.print("Indique o ponto Y: ");
                        y = entrada.nextInt();
                        Ponto codi = new Ponto(x,y);
                        pontos.AddLocale((posicao-1), codi);
                    }
                    pontos.Impm();
                    break;    
                case 3:
                    System.out.println("\nPontos");
                    System.out.print("Indique o ponto X: ");
                    x = entrada.nextInt();
                    System.out.print("Indique o ponto Y: ");
                    y = entrada.nextInt();
                    Ponto procura = new Ponto(x,y);
                    posicao = pontos.BuscaPonto(procura);
                    if(posicao != -1){
                        System.out.println("Ponto " +procura+ " esta na posição "+ posicao);
                    }else{
                        System.out.println("Ponto "+procura+ " não se encontra na coleção.");
                    }
                    pontos.Impm();
                    break;
                case 4: 
                    System.out.print("\nIndique a posição que quer remover: ");
                    posicao = entrada.nextInt();
                    if(posicao<=0 || posicao>tamnho){
                        System.out.println("Posição " +posicao+" invalida.");
                    }
                    else{
                        System.out.println(pontos.DeletaPonto(posicao-1));
                    }
                    pontos.Impm();
                    break;
                case 5:
                    pontos.Distancia();
                    pontos.Impm();
                    break;
                case 6:
                    ListaPonto circulo;
                    System.out.println("\nPonto centro circulo");
                    System.out.print("Indique o ponto X: ");
                    x = entrada.nextInt();
                    System.out.print("Indique o ponto Y: ");
                    y = entrada.nextInt();
                    Ponto circ = new Ponto(x, y);
                    System.out.print("Indique o raio da circuferencia: ");
                    double raio = entrada.nextDouble();
                    circulo = pontos.circulo(circ, raio);
                    circulo.Impm();
                    break;
                case 7:
                    System.out.println("\nFechando menu");
                    break;
                default:
                    System.out.println("\nOpção invalida");
            }
        }      
    }
}
