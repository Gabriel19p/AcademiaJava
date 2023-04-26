package jdbc;

public class Update {
	
	public static void main(String[] args) {
        BancoDados bd = new BancoDados();

        String db_url = "jdbc:mysql://localhost:3306/locadora_veiculos";
        String db_user = "root";
        String db_password = "";

        bd.conectar(db_url, db_user, db_password);
        
       String query1 = "INSERT INTO carro (placa, marca, modelo) VALUES ('ABC456', 'Volkswagen', 'Gol')";
       String query2 = "INSERT INTO carro (placa, marca, modelo) VALUES ('AB4S5S', 'BMW', '320i')";
       String query3 = "INSERT INTO carro (placa, marca, modelo) VALUES ('B4GJSA', 'HONDA', 'Fit')";
	
	/*String query1 = "DELETE FROM carro WHERE (placa, marca, modelo) = ('ABC456', 'Volkswagen', 'Gol')";
    String query2 = "DELETE FROM carro WHERE (placa, marca, modelo) = ('AB4S5S', 'BMW', '320i)";
    String query3 = "DELETE FROM carro WHERE (placa, marca, modelo) = ('B4GJSA', 'HONDA', 'Fit')";*/
       
       bd.inserirAlterarExcluir(query1);
       bd.inserirAlterarExcluir(query2);
       bd.inserirAlterarExcluir(query3);
       
    bd.desconectar();
	}
}
