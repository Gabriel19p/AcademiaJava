package jdbc;

import java.io.IOException;
import java.util.logging.Level;

public class Consulta {
	
	public static void main(String[] args) throws IOException {
		
		Log meuLogger = new Log("Log.txt");
		
		try {
		meuLogger.logger.setLevel(Level.FINE);
		meuLogger.logger.info("Iniciando Banco de Dados");
		

	} 
	catch (Exception e) {
		meuLogger.logger.info("Exception:" + e.getMessage());
		e.printStackTrace();
	}	
		
        BancoDados bd = new BancoDados();

        String db_url = "jdbc:mysql://localhost:3306/locadora_veiculos";
        String db_user = "root";
        String db_password = "";

        bd.conectar(db_url, db_user, db_password);

       	String query4 = "SELECT * FROM carro";
        
       	bd.consultar(query4);
        bd.desconectar();
        
        meuLogger.logger.info("Banco de Dados desconectado");
    }
}

