package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	public void inserir(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection
					.prepareStatement("INSERT INTO aluno(id, nome, matricula, cpf) VALUES(?, ?, ?, ?)");

			statement.setInt(1, aluno.getId());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getMatricula());
			statement.setString(4, aluno.getCpf());

			statement.execute();
			connection.close();

			System.out.println("\nALUNO CADASTRADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFalha ao inserir aluno.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection
					.prepareStatement("UPDATE aluno SET nome=?, matricula=?, cpf=? WHERE id=?");

			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			statement.setString(3, aluno.getCpf());
			statement.setInt(4, aluno.getId());

			statement.execute();
			connection.close();

			System.out.println("\nALUNO ATUALIZADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFalha ao inserir aluno.");
			System.out.println(e.getMessage());
		}
	}
	public void excluir(int id) {
		
		try {
			
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection
					.prepareStatement("DELETE FROM aluno WHERE id=?");
			
			statement.setInt(1, id);
			
			statement.execute();
			connection.close();
			
			System.out.println("\nALUNO EXCLUÍDO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFalha ao inserir aluno.");
			System.out.println(e.getMessage());
		}
	}
	
	public List<Aluno> consultar(){
		
		var lista = new ArrayList<Aluno>();
		
		try {
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT id, nome, matricula, cpf FROM aluno ORDER BY nome");
			
			var result = statement.executeQuery();
			
			while (result.next()) {	
				var aluno = new Aluno();
				aluno.setId(result.getInt("id"));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));
				
				lista.add(aluno);
			}
			connection.close();
		}
		catch(Exception e) {
			System.out.println("\nFalha ao consultar alunos");
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
	
	public Aluno obterPorId(Integer id) {
		
		Aluno aluno = null;
		
		try {
			
			var connection = ConnectionFactory.getConnection();
			
			var statement = connection.prepareStatement("SELECT id, nome, matricula, cpf FROM aluno WHERE id=?");
			statement.setInt(1, id);
			
			var result = statement.executeQuery();
			
			if(result.next()){
				aluno = new Aluno();
				
				aluno.setId(result.getInt("id"));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));
			}
			
			connection.close();
		}
		catch(Exception e) {
			System.out.println("\nFalha ao consultar por id.");
			System.out.println(e.getMessage());
		}
		
		return aluno;
	}
}
