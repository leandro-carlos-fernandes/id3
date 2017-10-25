import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Representa um nodo da árvore e toda a sub-estrutura a ele ligado. Pode ser
 * de dois tipos: de decisão (um nodo interno) ou de valor (nodo folha).
 *  
 * @author Leandro Fernandes
 */
public class Node {

	// Nodo de decisão
	private String atributo;
	private double ganho;
	private DataSet subSet;
	
	// Nodo de classificação
	private boolean isFolha;
	private String valor;	
	
	// Referencias para a estruturação na forma de árvore
	private Map<String,Node> descendentes;
	private int nivel;
	
	/**
	 * Cria um nodo ou sub-árvore que representará os registros contidos na
	 * base de dados informada.
	 * @param baseDados base de dados, podendo ser um conjunto completo ou
	 * um subconjunto.
	 */
	public Node(DataSet baseDados) {
		this.atributo = "<não definido>";
		this.ganho = 0;
		this.subSet = baseDados;
		this.isFolha = false;
		this.valor = "<não definido>";
		this.descendentes = null;
	}

	/**
	 * Recupera o atributo de decisão representado pelo nodo 
	 * @return nome do atributo
	 */
	public String getAtributo() {
		return atributo;
	}

	/**
	 * Recupera a categoria (classe) que o nodo representa 
	 * @return valor do atributo classe
	 */
	public String getValor() {
		if (!isFolha)
			throw new RuntimeException("Este não é um nodo folha da árvore, é impossível retornar a classificação a partir dele");
		return valor;
	}
	
	/**
	 * Permite verificar se trata-se ou não de um nodo folha na árvore
	 * @return verdadeiro se for um nodo folha
	 */
	public boolean isFolha() {
		return (isFolha || (descendentes == null));
	}

	/**
	 * Adiciona o novo nodo como filho do nodo corrente, associando-o como o
	 * caminho a ser seguindo quando o atributo de decisão tiver valor igual a
	 * aquele que foi informado como parâmetro.
	 * @param valor valor do atributo de decisão com o qual o nodo deverá ser associado
	 * @param filho nodo descentente do elemento corrente
	 */
	private void addDescente(String valor, Node filho) {
		if (descendentes == null)
			descendentes = new LinkedHashMap<String,Node>();
		filho.nivel = this.nivel + 1;
		descendentes.put(valor, filho);
	}
	
	/**
	 * Constrói a árvore (ou sub-árvore) que represente os dados do nodo corrente
	 */
	public void construir() {
		if (subSet.isEmpty())
			throw new RuntimeException("Base de dados sem registros (vazia), impossível construir uma árvore de decisão.");
		if (subSet.entropia() == 0) {
			isFolha = true;
			valor = subSet.getRegistroAt(0).getValor( subSet.getAtributoDeClasse() );
		}
		else {
			isFolha = false;
			// calcula os ganhos e identifica qual atributo oferece o maior ganho
			for (String atrib : subSet.getRegistroAt(0).getAtributos()) {
				if ( !atrib.equals(subSet.getAtributoDeClasse()) ) {
					double ganhoAtrib = subSet.ganho(atrib);
					if (ganho < ganhoAtrib) {
						ganho = ganhoAtrib;
						atributo = atrib;
					}
				}
			}
			// recupera todos os valores para o atributo que oferece o maior ganho
			// e cria, para cada valor possível, um node com o subset da base de
			// dados original com os registros que contenham o valor especificado
			// para aquele atributo.  
			for (String valor : subSet.getValoresDoAtributo(atributo))
				addDescente(valor, new Node(subSet.getSubSet(atributo, valor)) );
			// por fim, para cada filho do nodo corrente, repetimos o processo
			for (Entry<String, Node> e : descendentes.entrySet()) {
				e.getValue().construir();
			}
		}
	}

	/**
	 * Retorna o próximo nodo da árvore a ser utilizado quando o atributo de
	 * decisão tem valor igual ao informado como parâmetro.
	 * @param valor um dos valores possíveis para o atributo de decisão
	 * @return próximo nodo da árvore
	 */
	public Node getProximoNode(String valor) {
		if (isFolha)
			throw new RuntimeException("Nodo folha, use getValor() para determinar a classificação.");		
		return descendentes.get(valor);
	}
	
	/**
	 * Representação na forma textual da estrutura hierárquica da sub-árvore
	 * dada a partir deste nodo.
	 */
	@Override
	public String toString() {
		String msg = "";		
		if (isFolha)
			msg += "-> " + valor;
		else {
			msg += "<<" + atributo + ">>";
			for (Entry<String,Node> e : descendentes.entrySet()) {
				msg += "\n";
				for (int i = 0; i < nivel; i++) msg += "\t\t";
				msg += "\t+--" + e.getKey() + "--" + e.getValue();
			}
		}
		return msg;
	}

}
