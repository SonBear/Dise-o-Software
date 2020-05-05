package FactoryAbstract;

public class Cliente {
	
	public Cliente() {
				
	}
	
	public String encriptar(String texto, String algo) {
		if(algo.equalsIgnoreCase("ghash")) {
			GHash encriptadorG = new GHash();
			encriptadorG.configure();
			return encriptadorG.encrypt(texto);
		}
		KHash encriptadorK = new KHash();
		encriptadorK.configurar();
		return encriptadorK.encriptar(texto);
	}
	
	public static void main (String args[]) {
		String cadenaEncriptada;
		cadenaEncriptada = new Cliente().encriptar("Hola", "khash");
		System.out.println(cadenaEncriptada);
	}

}
