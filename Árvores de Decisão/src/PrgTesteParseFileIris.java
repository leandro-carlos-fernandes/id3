import java.io.IOException;

public class PrgTesteParseFileIris {

	public static void main(String[] args) {

		DataSet dataset = null;
		
		ParseFile databaseFile = new ParseFile();
		databaseFile.setArquivo("./Iris.txt");
		try {
			dataset = databaseFile.getRegistros();
		} catch (IOException e) {
			System.err.println("Ops! Problemas ao ler o arquivo.");
			System.err.println("ERRO" + e.getMessage());
		}

		// Definindo o atributo que queremos usar como classe
		dataset.setAtributoDeClasse("EspécieDeOrquídea");
		System.out.println(dataset);
		
		// Criando e construindo a árvore de decisão usando como base de treino
		// o conjunto de dados representado pelo objeto dataset.
		DecisionTree arvDecisao = new DecisionTree();
		arvDecisao.construir(dataset);
		
		// Exibindo a Árvore de Decisão após a sua construção
		System.out.println("--:: Árvore de Decisão para esse conjunto de dados ::--");
		System.out.println(arvDecisao);
		
		System.out.println("\n");
			
		Record registro1 = new Record();
		//Iris-virginica
		registro1.add("ComprDaSépala","longa");
		registro1.add("LargDaSépala","fina");
		registro1.add("ComprDaPétala","longa");
		registro1.add("LargDaPétala","média");
		
		System.out.println("Para o caso: " + registro1);
		System.out.println("É esperado \"Iris-virginica\" e a resposta foi: " + arvDecisao.getClassificacao(registro1) );
		
		Record registro2 = new Record();
		//Iris-versicolor
		registro2.add("ComprDaSépala","média");
		registro2.add("LargDaSépala","fina");
		registro2.add("ComprDaPétala","longa");
		registro2.add("LargDaPétala","média");
		
		System.out.println("Para o caso: " + registro2);
		System.out.println("É esperado \"Iris-versicolor\" e a resposta foi: " + arvDecisao.getClassificacao(registro2) );
		
		Record registro3 = new Record();
		//Iris-setosa
		registro3.add("ComprDaSépala","média");
		registro3.add("LargDaSépala","larga");
		registro3.add("ComprDaPétala","curta");
		registro3.add("LargDaPétala","fina");
		
		System.out.println("Para o caso: " + registro3);
		System.out.println("É esperado \"Iris-setosa\" e a resposta foi: " + arvDecisao.getClassificacao(registro3) );
		
		// The life can't be more easy Padawan, all data load was automated!
		// May the force be with you! :)
		System.exit(0);
	}

}
