package jdbc;

import java.sql.*;

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
	public void consultar(String db_query) {
		try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(db_query);

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) +
                " " + rs.getString(4));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao executar consulta: " + e.getMessage());
        }
		
	}

	@Override
	public int inserirAlterarExcluir(String db_query) {
		 try {
	            Statement stmt = conn.createStatement();
	            int result = stmt.executeUpdate(db_query);
	            int linhas = result;
				System.out.println("A operacao afetou: "+linhas+" linhas.");
	            stmt.close();
	            return result;
	        } catch (SQLException e) {
	            System.out.println("Erro ao executar inserção/alteração/exclusão: " + e.getMessage());
	            return -1;
	        }
	}

   
}
