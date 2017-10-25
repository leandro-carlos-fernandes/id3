
public class PrgTesteDecisionTree {

	public static void main(String[] args) {

		Record reg;
		DataSet dataset = new DataSet();

		// Dia 1
		reg = new Record();
		reg.add("Aparencia", "ensolarado");
		reg.add("Temperatura", "quente");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "não");
		dataset.add(reg);

		// Dia 2
		reg = new Record();
		reg.add("Aparencia", "ensolarado");
		reg.add("Temperatura", "quente");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "forte");
		reg.add("JogouTenis", "não");
		dataset.add(reg);

		// Dia 3
		reg = new Record();
		reg.add("Aparencia", "nublado");
		reg.add("Temperatura", "quente");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 4
		reg = new Record();
		reg.add("Aparencia", "chuva");
		reg.add("Temperatura", "moderada");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 5
		reg = new Record();
		reg.add("Aparencia", "chuva");
		reg.add("Temperatura", "fria");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 6
		reg = new Record();
		reg.add("Aparencia", "chuva");
		reg.add("Temperatura", "fria");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "forte");
		reg.add("JogouTenis", "não");
		dataset.add(reg);

		// Dia 7
		reg = new Record();
		reg.add("Aparencia", "nublado");
		reg.add("Temperatura", "fria");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "forte");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 8
		reg = new Record();
		reg.add("Aparencia", "ensolarado");
		reg.add("Temperatura", "moderada");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "não");
		dataset.add(reg);

		// Dia 9
		reg = new Record();
		reg.add("Aparencia", "ensolarado");
		reg.add("Temperatura", "fria");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 10
		reg = new Record();
		reg.add("Aparencia", "chuva");
		reg.add("Temperatura", "moderada");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 11
		reg = new Record();
		reg.add("Aparencia", "ensolarado");
		reg.add("Temperatura", "moderada");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "forte");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 12
		reg = new Record();
		reg.add("Aparencia", "nublado");
		reg.add("Temperatura", "moderada");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "forte");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 13
		reg = new Record();
		reg.add("Aparencia", "nublado");
		reg.add("Temperatura", "quente");
		reg.add("Umidade", "normal");
		reg.add("Ventando", "fraco");
		reg.add("JogouTenis", "sim");
		dataset.add(reg);

		// Dia 14
		reg = new Record();
		reg.add("Aparencia", "chuva");
		reg.add("Temperatura", "moderada");
		reg.add("Umidade", "alta");
		reg.add("Ventando", "forte");
		reg.add("JogouTenis", "não");
		dataset.add(reg);

		// Definindo o atributo que queremos usar como classe
		dataset.setAtributoDeClasse("JogouTenis");
		
		// Criando e construindo a árvore de decisão usando como base de treino
		// o conjunto de dados representado pelo objeto dataset.
		DecisionTree arvDecisao = new DecisionTree();
		arvDecisao.construir(dataset);
		
		// Exibindo a Árvore de Decisão após a sua construção
		System.out.println("--:: Árvore de Decisão para esse conjunto de dados ::--");
		System.out.println(arvDecisao);
		
		// Vamos criar um novo registro para ver qual seria a sua classificação
		Record registro = new Record();
		registro.add("Aparencia", "nublado");
		registro.add("Temperatura", "moderada");
		registro.add("Umidade", "normal");
		registro.add("Ventando", "fraco");
		
		// Classificando o novo caso
		System.out.println("Nestas condições:");
		System.out.println(registro);
		System.out.println("Será que ele jogaria tenis?");
		System.out.println("E a resposta é: " + arvDecisao.getClassificacao(registro) );

		// Now you are ready to became a Jedi, my Padawan!
		// May the force be with you!
		System.exit(0);
	}

}
