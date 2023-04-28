package jdbc;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;

public class BancoDados implements InterfaceBancoDados {
	
	private Connection conn;
	@Override
	public void conectar(String db_url, String db_user, String db_password) {
		  
		try {
	            conn = DriverManager.getConnection(db_url, db_user, db_password);
	            System.out.println("Banco de dados Conectado.");
	        } catch (SQLException e) {
	            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	        }
		
	}

	@Override
	public void desconectar() {
	       try {
	            conn.close();
	          System.out.println("Conexão com banco de dados encerrada.");
	        } catch (SQLException e) {
	           System.out.println("Erro ao desconectar do banco de dados: " + e.getMessage());
	        }
	}

	@Override
	public void consultar(String db_query) throws IOException {
		Log meuLogger = new Log("Log2.txt");
		try {
			meuLogger.logger.setLevel(Level.FINE);
			 meuLogger.logger.info("Consultando Banco...");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(db_query);

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) +
                " " + rs.getString(4));
            }
            System.out.println("Banco de Dados consultado com sucesso");
            LocalDate now = LocalDate.now(); 
            LocalTime now1 = LocalTime.now(); 
            meuLogger.logger.info("Consulta realizada as:" + " " + LocalDate.now()+ " " + "e" + " " + LocalTime.now() + " " + "feita com sucesso");
            rs.close();
            stmt.close();
        } catch (SQLException e) {
        	meuLogger.logger.info("Erro ao executar consulta: " + e.getMessage());
        }
		
	}

	@Override
	public int inserirAlterarExcluir(String db_query) throws IOException {
		
		Log meuLogger = new Log("Log.txt");
		
		try {
			meuLogger.logger.setLevel(Level.FINE);
			System.out.println("Banco de Dados atualizado com sucesso");
			 LocalDate now = LocalDate.now(); 
	         LocalTime now1 = LocalTime.now(); 
	         meuLogger.logger.info("Atualização realizada as:" + " " + LocalDate.now()+ " " + "e" + " " + LocalTime.now() + " " + "feita com sucesso");
			Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(db_query);
            int linhas = result;
            System.out.println("A operacao afetou: "+linhas+" linhas.");
			meuLogger.logger.info((+linhas+" linhas afetadas."));
            stmt.close();
            return result;
          
           
		} 
		catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return -1;
		
		
		}
	}
	
