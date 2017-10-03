/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados;

import java.io.PrintWriter;
import org.apache.derby.impl.drda.NetworkServerControlImpl;

/**
 *
 * @author pablo
 */
public class ControleServerJavaDB {

    //Aqui você também pode utilizar um caminho relativo, porém lembre-se de que esse
    //caminho inicia no mesmo diretório onde você iniciou a aplicação.
    //Alterar aqui o caminho do banco de dados
    final String caminho_banco = "C:\\AgendaBancada\\derby\\db";

    public boolean iniciaServer() {
        try {

            System.setProperty("derby.system.home", caminho_banco);
            NetworkServerControlImpl networkServer = new NetworkServerControlImpl();
            networkServer.start(new PrintWriter(System.out));

            //System.out.println("Conectado ao banco de dados.");
            return true;
            
        } catch (Exception ex) {
            //System.out.println("Não conseguiu conectar no banco de dados.");
            return false;
        }
    }

    public void fechaServer() {
        try {
            System.setProperty("derby.system.home", caminho_banco);
            NetworkServerControlImpl networkServer = new NetworkServerControlImpl();
            networkServer.shutdown();
        } catch (Exception e) {
            System.out.println("Não conseguiu desligar banco de dados.");
        }

    }
}
