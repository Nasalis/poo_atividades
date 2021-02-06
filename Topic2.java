import java.util.ArrayList;

class Pass {

	private String name;
	private int idade;
	
	public Pass(String name, int idade) {
		this.name = name;
		this.idade = idade;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		
		return this.name+":"+this.idade;
	}
}

class TopicJava {

	public ArrayList<Pass> cadeiras;
	public int qtdPref;
    int ocupadoPref = 0;
    int ocupadoNPref = 0;
	
	public TopicJava(int lotacao, int qtdPref) {
		this.qtdPref = qtdPref;
		this.cadeiras = new ArrayList<>();
		
		for(int i = 0; i < lotacao; ++i) {
			cadeiras.add(null);
		}
	}
	
	public boolean subir(Pass pass) {
		

        if(pass.getIdade() >= 60) {
            for(int i = 0; i < this.qtdPref; ++i) {
                if(this.cadeiras.get(i) == null) {
                    cadeiras.set(i, pass);
                    return true;
                }
            }

        }else if(pass.getIdade() < 60) {
            for(int i = this.qtdPref; i < this.cadeiras.size(); ++i) {
                if(this.cadeiras.get(i) == null) {
                    cadeiras.set(i, pass);
                    return true;
                }
            }

            for(int j = 0; j < qtdPref; j++) {
                if(cadeiras.get(j) == null) {
                    cadeiras.set(j, pass);
                    return true;
                }
            }
        }
			
		return false;
	}
	
	
	// public Pass descer(String name) {
		
	// 	for(int i = 0; i < cadeiras.size(); ++i) {
			
	// 		Pass cadeira = this.cadeiras.get(i);
			
	// 		if(this.cadeiras != null && this.cadeiras.contains(cadeira.getName()) == false) {
	// 			System.out.println("fail: pass nao esta na topic");
	// 			return this.cadeiras.set(i, null);
	// 		}
			
	// 		if(this.cadeiras.get(i).equals(name)) {
	// 			this.cadeiras.set(i, null);
	// 		}
	// 	}
		
	// 	return null;
		
	// }
	
    public String toString() {
        String output = "[ ";

        for(int i = 0; i < qtdPref; i++) {
            if(cadeiras.get(i) == null)
                output += "@ ";
            else
                output += "@" + cadeiras.get(i) + " ";
        }

        for(int j = qtdPref; j < cadeiras.size(); j++) {
            if(cadeiras.get(j) == null)
                output += "= ";
            else
                output += "=" + cadeiras.get(j) + " ";
        }
        return output += "]";
    }
}

public class Topic2 {

    public static void main(String[] args) {
        
        TopicJava topicJava = new TopicJava(5, 2);
        System.out.println(topicJava);
        
        topicJava.subir(new Pass("davi", 17));
        System.out.println(topicJava);
        
        topicJava.subir(new Pass("joao", 103));
        System.out.println(topicJava);
        
        topicJava.subir(new Pass("ana", 35));
        System.out.println(topicJava);
        
        topicJava.subir(new Pass("rex", 20));
        topicJava.subir(new Pass("bia", 16));
        System.out.println(topicJava);
        
        // topicJava.descer("davi");
        System.out.println(topicJava);
        
        topicJava.subir(new Pass("aragao", 96));
        System.out.println(topicJava);
        
        topicJava.subir(new Pass("lucas", 23));
        System.out.println(topicJava);
        
        // topicJava.descer("marcelo");
        System.out.println(topicJava);
        
        // topicJava.descer("ana");
    }
    
}