package chave_composta.embeddedid;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import util.DataUtil;

// Comentar @Entity na classe Matricula do outro pacote para evitar conflito
@Entity

public class Matricula {

	@EmbeddedId
	private MatriculaId id;

	@Column(name = "data_matricula")
	private LocalDate dataMatricula;

	
	public MatriculaId getId() {
		return id;
	}
	
	public void setId(MatriculaId id) {
		this.id = id;
	}
	
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	@Override
	public String toString() {
		String strData = DataUtil.formatarData(dataMatricula);
		return String.format("Aluno ID: %-7d Turma ID: %-7d Data: %s", id.getIdAluno(), id.getIdTurma(), strData);
	}
}
