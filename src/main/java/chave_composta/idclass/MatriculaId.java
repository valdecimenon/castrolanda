package chave_composta.idclass;

import java.io.Serializable;
import java.util.Objects;

public class MatriculaId implements Serializable {

	private static final long serialVersionUID = -5895299752574893186L;

	private Integer idAluno;
	private Integer idTurma;

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAluno, idTurma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaId other = (MatriculaId) obj;
		return Objects.equals(idAluno, other.idAluno) && Objects.equals(idTurma, other.idTurma);
	}
	
}
