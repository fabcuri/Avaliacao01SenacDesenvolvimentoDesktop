package executavel;


import javax.swing.JOptionPane;
import model.dao.ProdutoDAO;
import model.entity.Produto;

public class executavel {

	public static void main(String[] args) {
		testarCadastroProdutoComJOptionPane();
	}

	

		private static void testarCadastroProdutoComJOptionPane() {
				
				String nome = JOptionPane.showInputDialog("Informe o nome do produto");
				Float preco =Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do produto"));
				Short codigo =Short.parseShort (JOptionPane.showInputDialog("Informe o codigo do produto"));
			
				
				//TODO Violando o MVC...
				ProdutoDAO produtoDAO = new ProdutoDAO();
				Produto novoProduto = new Produto(nome, preco, codigo);
				novoProduto = produtoDAO.inserir(novoProduto);
				
				if(novoProduto.getId() > 0) {
					JOptionPane.showMessageDialog(null, "Novo produto salvo!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar produto","Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		
	}

	


