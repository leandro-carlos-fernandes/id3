

public class PrgTesteDataSet {

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

		dataset.setAtributoDeClasse("JogouTenis");

		// Exibe a estrutura e os valores que constituem a base de dados
		System.out.println("--:: DataSet ::--");
		System.out.println(dataset);

		// Calcula a entropia para a base de dados
		System.out.println("\nEntropia: " + dataset.entropia());

		// Calcula o ganho oferecido por cada um dos atributos
		for (String atributo : dataset.getRegistroAt(0).getAtributos()) {
			if (!atributo.equals(dataset.getAtributoDeClasse()))
				System.out.println("Ganho(" + atributo + "): " + dataset.ganho(atributo));
		}

		// The force is growing in you, young Padawan! Stay in that way ...
		System.exit(0);
	}

}
