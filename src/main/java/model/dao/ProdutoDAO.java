package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Produto;



	public class ProdutoDAO implements BaseDAO<Produto>{
		
		public Produto inserir(Produto novoProduto) {
			Connection conexao = Banco.getConnection();
			String sql = " INSERT INTO PRODUTO(NOME, PRECO, CODIGO)" 
						+ "VALUES (?, ?, ?);";
					
			PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
			
			try {
				stmt.setString(1, novoProduto.getNome());
				stmt.setFloat(2, novoProduto.getPreco());
				stmt.setInt(3, novoProduto.getCodigo());
				
				stmt.execute();
				
				ResultSet chavesGeradas = stmt.getGeneratedKeys();
				if(chavesGeradas.next()) {
					novoProduto.setId(chavesGeradas.getInt(1));
				}
			} catch (SQLException e) {
				System.out.println("Erro ao inserir produto. Causa:" + e.getMessage());
			}
			
			return novoProduto;
		}

		public boolean atualizar(Produto objeto) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean remover(int id) {
			boolean removeu = false;
			
			Connection conexao = Banco.getConnection();
			String sql = " DELETE FROM PRODUTO"
						+" WHERE ID=?";
			PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
			
			try {
				stmt.setInt(1, id);
				removeu = stmt.executeUpdate() > 0;
			} catch (SQLException e) {
				System.out.println("Erro ao remover cliente. Causa:" + e.getMessage());
			}		
			
			return removeu;
		}

		public Produto consultar(int codigo) {
			Produto produtoConsultado = null;
			Connection conexao = Banco.getConnection();
			String sql = " SELECT * FROM PRODUTO "
						+" WHERE CODIGO=?";
			PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
			
			try {
				stmt.setInt(1, codigo);
				ResultSet resultado = stmt.executeQuery();
				
				if(resultado.next()) {
					produtoConsultado = construirDoResultSet(resultado);
				}
			} catch (SQLException e) {
				System.out.println("Erro ao consultar cliente (id:" + codigo + ". Causa:" + e.getMessage());
			}
			
			return produtoConsultado;
		}
		private Produto construirDoResultSet(ResultSet resultado) throws SQLException {
			Produto produtoConsultado = new Produto();
			produtoConsultado.setId(resultado.getInt("id"));
			produtoConsultado.setNome(resultado.getString("nome"));
			produtoConsultado.setPreco(resultado.getFloat("preco"));
			produtoConsultado.setCodigo(resultado.getShort("codigo"));
			return produtoConsultado;
		}
		

		public List<Produto> consultarTodos() {
				List<Produto> produtos = new ArrayList<Produto>();
				Connection conexao = Banco.getConnection();
				String sql = " SELECT * FROM PRODUTO ";
				PreparedStatement stmt = Banco.getPreparedStatement(conexao, sql);
				
				try {
					ResultSet resultado = stmt.executeQuery();
					
					while(resultado.next()) {
						Produto produtoConsultado = construirDoResultSet(resultado);
						produtos.add(produtoConsultado);
					}
				} catch (SQLException e) {
					System.out.println("Erro ao consultar todos os clientes. Causa:" + e.getMessage());
				}
				
				return produtos;
			}

		
		}


	

