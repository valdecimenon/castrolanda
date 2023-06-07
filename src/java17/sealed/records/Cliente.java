package java17.sealed.records;

/*
 * records permitem implementar também interfaces sealed
 * porém não aceitam o modificador sealed ou non-sealed,
 */
public record Cliente() implements DAO {

	@Override
	public void salvar(String nome) {
		// TODO Auto-generated method stub
		
	}

}
