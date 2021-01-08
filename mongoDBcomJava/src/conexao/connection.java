/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tiago Gomes
 */
public class connection {
    DB baseDados;
    DBCollection colecao;
    BasicDBObject document = new BasicDBObject();
    
    public connection() {
        try{
            //Conexão banco de Dados
            Mongo m = new Mongo("localhost", 27017);
            
            //Conectando à base de dados teste
            baseDados = m.getDB("teste");
            
            colecao = baseDados.getCollection("pessoa");
//            System.out.println("Conexão efetuada com sucesso!");
            
        }catch(UnknownError e){
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
    }
    
//Conumicações com o Banco de Dados    
    public boolean inserir (String rg){
        document.put("RG",rg);
        colecao.insert(document);
        return true;   
    }
    

    public void mostrar(){
        DBCursor cursor = colecao.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    public boolean atualizar(String dadoAntigo, String dadoNovo){
        document.put("RG", dadoAntigo);
        BasicDBObject docNovo = new BasicDBObject();
        docNovo.put("RG", dadoNovo);
        colecao.findAndModify(document, docNovo);
        return true;
    }
    
    public boolean excluir(String dado){
        document.put("RG", dado);
        colecao.remove(document);
        return true;
    }
    
}
