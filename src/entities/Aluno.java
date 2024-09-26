package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Aluno {
	
	private Integer id;
	private String nome;
	private String matricula;
	private String cpf;
}
