import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Representa uma instância do problema (um caso) e armazena os valores de cada
 * atributo.
 * @author Leandro Fernandes
 */
public class Record {

	private static int cont = 0;	// gerador de ID's (contador de instâncias)
	
	private int id;					// ID do registro
	private Map<String, String> map;// Lista de pares atributo-valor

	/**
	 * Cria um novo registro e estabelece o valor de seu identificador (ID) 
	 */
	public Record() {
		map = new LinkedHashMap<String, String>();
		id = ++cont;
	}

	/**
	 * Adiciona cada parte de informação que compõe o registro, sendo dada pelo
	 * par: atributo-valor
	 * @param atributo nome do atributo
	 * @param valor	string correspondente ao valor deste atributo
	 */
	public void add(String atributo, String valor) {
		map.put(atributo, valor);
	}
	
	/**
	 * Retorna o número identificador (ID) atribuído ao registro.
	 * @return número identificador do registro
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Retorna a quantidade de campos (atributos) que compõem o registro.
	 * @return número de atributos
	 */
	public int getSize() {
		return map.size();
	}
	
	/**
	 * Retorna o valor correspondente ao atributo informado
	 * @param atributo string que identifica o atributo desejado
	 * @return valor valor associado aquele atributo
	 */
	public String getValor(String atributo) {
		return map.get(atributo);
	}
	
	/**
	 * Retorna uma lista com todos os valores do registro
	 * @return lista de valores
	 */
	public List<String> getValores() {
		if (map.isEmpty())
			return null;
		else {
			List<String> listaDeValores = new ArrayList<String>();
			for(Entry<String,String> e : map.entrySet()) {
				listaDeValores.add( e.getValue() );
			}
			return listaDeValores;
		}
	}
	
	/**
	 * Retorna a lista de atributos que compõe o registro
	 * @return lista de atributos
	 */
	public List<String> getAtributos() {
		if (map.isEmpty())
			return null;
		else {
			List<String> listaDeValores = new ArrayList<String>();
			for(Entry<String,String> e : map.entrySet()) {
				listaDeValores.add( e.getKey() );
			}
			return listaDeValores;
		}
	}

	@Override
	public String toString() {
		String msg = "";
		for(Entry<String,String> e : map.entrySet())
			msg += e.getKey() + "=\"" + e.getValue() + "\" ";
		return msg;
	}
}
