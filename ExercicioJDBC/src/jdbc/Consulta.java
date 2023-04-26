package jdbc;

public class Consulta {
	
	public static void main(String[] args) {
        BancoDados bd = new BancoDados();

        String db_url = "jdbc:mysql://localhost:3306/locadora_veiculos";
        String db_user = "root";
        String db_password = "";

        bd.conectar(db_url, db_user, db_password);

        String query4 = "SELECT * FROM carro";
        bd.consultar(query4);

        bd.desconectar();
    }
}

