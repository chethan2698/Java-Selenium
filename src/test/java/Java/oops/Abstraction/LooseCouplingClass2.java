package Java.oops.Abstraction;

public class LooseCouplingClass2 {

	public static void main(String[] args) {
		LooseCouplingAbstract lci = new ACs();
		lci.On();
		lci.Off();
		
		lci = new Switches();
		lci.On();
		lci.Off();
		
		lci = new TVs();
		lci.On();
		lci.Off();
	}
}


class Switches extends LooseCouplingAbstract{

	@Override
	public void On() {		
		System.out.println("Switch On");
	}

	@Override
	public void Off() {
		System.out.println("Switch Off");	
	}

}

class TVs extends LooseCouplingAbstract {

	@Override
	public void On() {
		System.out.println("TV On");
		
	}

	@Override
	public void Off() {
		System.out.println("TV off");
		
	}
	
	
}

class ACs extends LooseCouplingAbstract {

	@Override
	public void On() {
		System.out.println("AC On");
		
	}

	@Override
	public void Off() {
		System.out.println("AC off");
		
	}
		
}
