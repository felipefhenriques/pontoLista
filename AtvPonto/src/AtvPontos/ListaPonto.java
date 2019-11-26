package AtvPontos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan.gferreira
 */

public class ListaPonto {
    
    private Ponto pontos[];
    private int validos;

    
    public ListaPonto(int n){
        this.pontos = new Ponto[n];
        this.validos = 0;
    }
    
    /**
     * Método para adição de ponto, realizando verificação para inserção
     * do objeto no vetor, inserindo-o e retornando o mesmo.
     * 
     * @param Ponto
     * @return Ponto[]
     */
    public Ponto[] AddPonto(Ponto cordenada){
        if(this.validos<pontos.length){
            for(int i=0;i<pontos.length;i++){            
                if(pontos[i]==null){
                    pontos[i]=cordenada;
                    this.validos++;
                    System.out.println("Ponto adicionado");
                    return pontos;
                }
            }
        }
        System.out.println("Falha ao adicionar ponto");
        return pontos;
    }
    
    public Ponto[] AddPonto2(Ponto cordenada){
        if(this.validos<pontos.length){
            for(int i=0;i<pontos.length;i++){            
                if(pontos[i]==null){
                    pontos[i]=cordenada;
                    this.validos++;
                    return pontos;
                }
            }
        }
        System.out.println("Falha ao adicionar ponto");
        return pontos;
    }
    
    /**
    * Método para adição de ponto, mas em uma posição específica escolhida pelo
    * usuário, com uma validação com o parametro local, para saber se ela está
    * vazia e se não, faz um passo de troca para tentar alocar o ponto 
    *
    * @param int
    * @param Ponto
    * @return Ponto[]
    */
    public Ponto[] AddLocale(int local, Ponto cordenada){
        Ponto aux = new Ponto();
            if(local>this.validos){
                pontos[this.validos] = cordenada;
                validos++;
            }
            else{
                this.validos++;
                for(int i=0;i<this.validos;i++){
                    if(i==local && pontos[i]==null){
                        pontos[i] = cordenada; 
                    }
                    if(i==local && pontos[i]!=null){
                        aux = pontos[i];
                        pontos[i] = cordenada;
                    }
                    if(i>local){
                        if(pontos[i]==null){
                            pontos[i] = aux;
                        }
                        else{
                            cordenada = pontos[i]; 
                            pontos[i] = aux;
                            aux = cordenada;
                        }
                    }
                }
            }    
            System.out.println("Ponto alocado na posição selecionada");
            return pontos;    
        }

    /**
     * Método simples de busca, chamando um outro método da classe ponto
     * para checar igualdade e possui um retorno informativo com objetos
     * válidos
     * 
     * @param proc
     * @return int 
     */
    public int BuscaPonto(Ponto proc){
       boolean achou;
       for(int i =0; i<this.validos; i++){
            achou = pontos[i].igual(proc);
            if(achou!= false){
                System.out.println("Objetos validos "+ this.validos);
                return (i+1);
            }
        }
        System.out.println("Objetos validos "+ this.validos);
        return -1;
    }
    
    /**
     * Método para deletar objeto em posição que retorna uma string, pode 
     * avisar ao usuário que a posição está vazia e o objeto não pode ser deletado
     * ou retorna avisando que o ponto foi removido com sucesso.
     * 
     * 
     * @param int
     * @return String
     */
    public String DeletaPonto(int local){  
        if(local>this.validos || pontos[local]==null ){
            return "Posição "+ (local+1) +" vazio";
        }
        else{
            pontos[local] = null;            
            
            for(int i = 0; i<this.validos; i++){
                if(pontos[i]==null){
                    pontos[i] = pontos[i+1];
                    pontos[i+1] = null;    
                }
            }
        }
        this.validos--;
        return "Ponto removido!";
    }
    
    
    /**
     * Método que chama o método de distância já feito na classe ponto, 
     * realizando uma impressão com o valor da distância
     * 
     * @param 
     * @return void
     */
    public void Distancia(){
        double dist=0;
        for(int i=0; i<this.validos; i++){
            for(int j=0; j<this.validos; j++){             
                if(i<j || i>j){
                    if(i == 0 && j == 0){
                        dist = pontos[i].distancia(pontos[j]);
                    }
                    if( dist < pontos[i].distancia(pontos[j]))
                        dist = pontos[i].distancia(pontos[j]);
                }     
            }
        }
        System.out.printf("A maior distancia entre dois pontos é %.2f\n", dist);
    }
    
    
    /**
     * Último método do menu, que verifica pontos validos na circunferência,
     * realizando uso do método AddPonto2 e a chamada do método distancia
     * da classe ponto. 
     * 
     * 
     * @param circ
     * @param raio
     * @return ListaPonto
     */
    public ListaPonto circulo(Ponto circ, double raio){
        ListaPonto CircuLista = new ListaPonto(validos);
        double dist;
        for(int i=0; i<this.validos; i++){
            dist = circ.distancia(pontos[i]);
            if(dist<= raio){
                CircuLista.AddPonto2(pontos[i]);
            }
            
        }
        return CircuLista;
    }
       /**
        * Método simples de impressão
        * @return void
        */
    public void Impm(){
        System.out.println("\nImpressão");
        for(int i=0; i<this.validos;i++){           
            System.out.print(pontos[i]+ " ");
        }
        System.out.println("");
    }
   
   
       
}
