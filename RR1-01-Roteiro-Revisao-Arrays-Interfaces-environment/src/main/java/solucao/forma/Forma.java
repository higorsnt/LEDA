package solucao.forma;

/**
 * A classe que vai usar qualquer uma das forma geometricas precisa apenas
 * enxergar referencias do tipo Forma. Em tempo de execução essas referencias
 * podem assumir qualquer subtipo de Forma. Assim, na hora de imprimir a área de
 * um objeto, chama-se simplesmente o método area(), definido na interface e
 * implementado especificamente pelos subtipos. Isso deixa a classe usuária sem
 * qualquer conhecimento de como o método area foi implementado. Ela apenas
 * precisa chamar o método (invocar o serviço)
 * 
 * @author Adalberto
 *
 */
public interface Forma {
	public double area();
}
