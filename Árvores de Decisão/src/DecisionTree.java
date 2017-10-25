
/**
 * Representa a árvore de decisão capaz de classificar um novo registro com
 * base na estrutura de decisão construída a partir de uma base de dados de
 * treinamento.
 * 
 * @author Leandro Fernandes
 */
public class DecisionTree {
	
	private Node raiz = null;
	
	/**
	 * Constrói a árvore de decisão para o conjunto de dados informado
	 * @param baseDados base de dados para treinamento
	 */
	public void construir(DataSet baseDados) {
		raiz = new Node(baseDados);
		raiz.construir();
	}
	
	/**
	 * Retorna a classificação dada para o registro informado, segundo
	 * a árvore de decisão construída anteriormente.
	 * @param registro
	 * @return
	 */
	public String getClassificacao(Record registro) {
		if (raiz == null)
			throw new RuntimeException("Impossível classificar este registro, pois a árvore aidna não foi construída.");
		else {
			Node no = raiz;
			while (!no.isFolha()) {
				String valor = registro.getValor( no.getAtributo() );
				no = no.getProximoNode(valor);
			}
			return no.getValor();
		}
	}

	/**
	 * Representação na forma textual da estrutura hierárquica da árvore
	 */
	@Override
	public String toString() {
		return raiz.toString();
	}
}
