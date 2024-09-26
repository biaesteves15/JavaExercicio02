package controllers;

import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarAluno() {

		try {
			System.out.println("\nCADASTRO DE ALUNOS:\n");

			System.out.println("ID DO ALUNO....:");
			var id = Integer.parseInt(scanner.nextLine());

			System.out.println("NOME DO ALUNO....:");
			var nome = scanner.nextLine();

			System.out.println("MATRICULA DO ALUNO....:");
			var matricula = scanner.nextLine();

			System.out.println("CPF DO ALUNO....:");
			var cpf = scanner.nextLine();

			var aluno = new Aluno(id, nome, matricula, cpf);

			var alunoRepository = new AlunoRepository();
			alunoRepository.inserir(aluno);

		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar aluno!");
			System.out.println(e.getMessage());
		}
	}

	public void atualizarAluno() {

		try {

			System.out.println("\nATUALIZAÇÃO DE ALUNOS:\n");

			System.out.println("INFORME O ID DO ALUNO....:");
			var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDADOS DO ALUNO:");
				System.out.println("ID...........:" + aluno.getId());
				System.out.println("NOME.........:" + aluno.getNome());
				System.out.println("MATRICULA....:" + aluno.getMatricula());
				System.out.println("CPF..........:" + aluno.getCpf());

				System.out.println("ALTERE O NOME:");
				aluno.setNome(scanner.nextLine());

				System.out.println("ALTERE A MATRICULA:");
				aluno.setMatricula(scanner.nextLine());

				System.out.println("ALTERE O CPF:");
				aluno.setCpf(scanner.nextLine());

				alunoRepository.atualizar(aluno);
			} else {
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar aluno!");
			System.out.println(e.getMessage());
		}
	}

	public void excluirAluno() {

		try {
			System.out.println("\nEXCLUSÃO DE ALUNOS:\n");

			System.out.println("INFORME O ID DO ALUNO:");
			var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDADOS DO ALUNO");
				System.out.println("ID.........:" + aluno.getId());
				System.out.println("NOME.......:" + aluno.getNome());
				System.out.println("MATRICULA..:" + aluno.getMatricula());
				System.out.println("CPF........:" + aluno.getCpf());

				alunoRepository.excluir(aluno.getId());
			} else {
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao excluir aluno!");
			System.out.println(e.getMessage());
		}
	}

	public void consultarAluno() {

		try {
			System.out.println("\nCONSULTA DE ALUNOS:\n");

			var alunoRepository = new AlunoRepository();
			var lista = alunoRepository.consultar();

			for(Aluno aluno : lista) {

				System.out.println("\nDADOS DO ALUNO");
				System.out.println("ID.........:" + aluno.getId());
				System.out.println("NOME.......:" + aluno.getNome());
				System.out.println("MATRICULA..:" + aluno.getMatricula());
				System.out.println("CPF........:" + aluno.getCpf());

			}
		} catch (Exception e) {
			System.out.println("\nFalha ao consultar aluno!");
			System.out.println(e.getMessage());
		}
	}
}
