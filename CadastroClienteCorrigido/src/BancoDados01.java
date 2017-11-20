import java.sql.*;

public class BancoDados01 {
    
    static String Nome, Email, Tipo_Cliente, Endereco;
    static int Cod_Cadastro, Idade, Doc;

    public void Cadastrar() throws SQLException, ClassNotFoundException {
        Connection conexao = ObterConexao();
        
        Statement statement = conexao.createStatement();
        
        try{
            
             //olha no arquivo de criação da tabela
        String cadastrar = "INSERT INTO cadastro (cod_cadastro, nome, email, idade, documento, tipo_cliente, endereco) VALUES ("
                + Cadastro.Cadastro + ",'" + Cadastro.Nome + "','" + Cadastro.Email + "'," + Cadastro.Idade + "," + Cadastro.Doc + ",'" + 
               Cadastro.Tipo_Cliente + "','" + Cadastro.Endereco + "')";
        
        ResultSet resultSet;
        resultSet = statement.executeQuery(cadastrar);
        System.out.println("Cliente Cadastrado");
        
        }catch (SQLException ex) {
            
            System.out.println(ex);
        }
       
    }


    public void consulta(int Cd_Cadastro) throws SQLException, ClassNotFoundException {
        Connection conexao = ObterConexao();
        Statement statement = conexao.createStatement();
        String query = "select nome, email, idade , documento, tipo_cliente, endereco from cadastro where cod_cadastro =" + Cd_Cadastro;
        ResultSet resultSet;
        resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            //os nome dentro do getString deve ser igual ao que você passou na query, senão da pau na consulta
            Nome = resultSet.getString("nome");
            Email = resultSet.getString("email");
            Tipo_Cliente = resultSet.getString("tipo_cliente");
            Endereco = resultSet.getString("edereco");
            Idade = resultSet.getInt("idade");
            Doc = resultSet.getInt("documento");
        }
    }

    public void Alterar(int Cd_Cadastro) throws SQLException, ClassNotFoundException {
        Connection conexao = ObterConexao();
        Statement statement = conexao.createStatement();
        String query = "Update cadastro set  nome= " + Nome + ",email=" + Email + ",idade=" + Idade + ",documento=" + Doc + ",tipo_cliente=" + Tipo_Cliente + ",endereco=" + Endereco;
        ResultSet resultSet = statement.executeQuery(query);
    }

    public static Connection ObterConexao() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "andrews", "0436");
        return conexao;
        // 
    }
}
