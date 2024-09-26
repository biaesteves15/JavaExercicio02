package principal;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\nSISTEMA DE CONTROLE DE ALUNOS:\n");

		System.out.println("(1) CADASTRAR ALUNOS");
		System.out.println("(2) CONSULTAR ALUNOS");
		System.out.println("(3) ATUALIZAR ALUNOS");
		System.out.println("(4) EXCLUIR ALUNOS");

		System.out.println("\nINFORME A OPÇÃO DESEJADA: ");
		var opcao = scanner.nextLine();

		var alunoController = new AlunoController();

		switch (opcao) {
		case "1":
			alunoController.cadastrarAluno();
			break;
		case "2":
			alunoController.consultarAluno();
			break;
		case "3":
			alunoController.atualizarAluno();
			break;
		case "4":
			alunoController.excluirAluno();
			break;
		}
		
		System.out.println("\nDESEJA CONTINUAR: (S, N):");
		var continuar = scanner.nextLine();

		if (continuar.equalsIgnoreCase("S")) {
			main(args);
		} else {
			System.out.println("\nFIM DO PROGRAMA!");
		}
	}

}
