/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.util.Scanner;

/**
 *
 * @author Tiago Gomes
 */
public class main {
    public static void main(String[] args) {
        connection conexao = new connection();
        Scanner ler = new Scanner(System.in);        
        int escolha = 0;
        do{
            System.out.println("+---- Cadastro de Pessoa com RG ----+");
            System.out.println("Menu:");
            System.out.println("1 - Cadastrar\n2 - Atualizar\n3 - Excluir\n4 - Mostrar no Banco\n5 - Fechar programa");
            System.out.print("Sua escolha ->");
            escolha = ler.nextInt();
                if(escolha == 1){
                    System.out.println("Escolha número "+ escolha); 
                    System.out.println("Cadastrar!");
                    System.out.print("Informe o RG ->");
                    String rg = ler.next();
                    conexao.inserir(rg);
                }
                else if (escolha == 2){
                    System.out.println("Escolha número "+ escolha);
                    System.out.println("Atualizar!");
                    System.out.print("RG antigo ->");
                    String dadoAntigo = ler.next();
                    System.out.print("RG novo ->");
                    String dadoNovo = ler.next();                    
                    conexao.atualizar(dadoAntigo, dadoNovo);
                }
                else if (escolha == 3){
                    System.out.println("Escolha número "+ escolha);
                    System.out.println("Excluir!");
                    System.out.print("Informe o RG a ser excluído ->");
                    String rg = ler.next();
                    conexao.excluir(rg);
                }
                else if (escolha == 4){
                    System.out.println("Escolha número "+ escolha);
                    System.out.println("Mostrar no Banco!");
                    conexao.mostrar();
                }
                else{
                    System.out.println("Fechar o Programa!");
                    System.out.println("Obrigado e volte sempre :)");   
                }
        }while(escolha!=5);
        
        
        
        
    }
 
    public static void limpaTela(){
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
