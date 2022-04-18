package Avaliacao1;

import java.io.File;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


	
public class Produto implements Serializable{
		//private final static String FILE_PATH = "C:\\Users\\SAMSUNG\\Desktop\\teams senac noturno\\produtos_avaliacao.csv";
		private final static String FILE_PATH = "C:\\Users\\fabricio.curi\\Desktop\\produtos_avaliacao.csv";


		private String nome;
		private float preco;
		private short codigo;



		@Override
		public String toString() {
			return nome+";"+preco+";"+codigo;
		}
		public Produto() {
			super();
		}
		public Produto(String nome, double preco, int codigo) {
			super();
			this.nome = nome;
			this.preco = (float) preco;
			this.codigo = (short) codigo;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public float getPreco() {
			return preco;
		}
		public void setPreco(float preco) {
			this.preco = preco;
		}
		public short getCodigo() {
			return codigo;
		}
		public void setCodigo(short codigo) {
			this.codigo = codigo;
		}
	}




