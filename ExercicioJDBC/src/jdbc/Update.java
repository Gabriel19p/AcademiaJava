package jdbc;

import java.io.IOException;
import java.util.logging.Level;

public class Update {
	
	public static void main(String[] args) throws IOException {
		
		Log meuLogger = new Log("Log1.txt");
		
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
        
    //String query1 = "INSERT INTO carro (placa, marca, modelo) VALUES ('AXG52146', 'Audi', 'Q3')";
        /* String query2 = "INSERT INTO carro (placa, marca, modelo) VALUES ('AB4S5S', 'BMW', '320i')";
       	String query3 = "INSERT INTO carro (placa, marca, modelo) VALUES ('B4GJSA', 'HONDA', 'Fit')";*/
    // meuLogger.logger.info("Inserindo dados..");
        
     //String query1 = "DELETE FROM carro WHERE(placa, marca, modelo) = ('AXG52146', 'Audi', 'Q3')";
    	/*String query2 = "DELETE FROM carro WHERE (placa, marca, modelo) = ('AB4S5S', 'BMW', '320i)";
    	String query3 = "DELETE FROM carro WHERE (placa, marca, modelo) = ('B4GJSA', 'HONDA', 'Fit')";*/
      //meuLogger.logger.info("Deletando dados..");
       
     String query1 = "UPDATE carro SET modelo = 'Fit' WHERE modelo = 'Tracker'";
     /* String query2 = "INSERT INTO carro (placa, marca, modelo) VALUES ('AB4S5S', 'BMW', '320i')";
    	String query3 = "INSERT INTO carro (placa, marca, modelo) VALUES ('B4GJSA', 'HONDA', 'Fit')";*/
     meuLogger.logger.info("Atualizando dados..");
     
       bd.inserirAlterarExcluir(query1);
      /* bd.inserirAlterarExcluir(query2);
       bd.inserirAlterarExcluir(query3);*/
       
       meuLogger.logger.info("Banco de Dados desconectado");
       bd.desconectar();
	}
}
