package Java.oops.Abstraction;

public class LooseCouplingClass1 {

	public static void main(String[] args) {
		LooseCouplingInterface lci = new AC();
		lci.On();
		lci.Off();
		
		lci = new Switch();
		lci.On();
		lci.Off();
		
		lci = new TV();
		lci.On();
		lci.Off();
	}
}


class Switch implements LooseCouplingInterface{

	@Override
	public void On() {		
		System.out.println("Switch On");
	}

	@Override
	public void Off() {
		System.out.println("Switch Off");	
	}

}

class TV implements LooseCouplingInterface {

	@Override
	public void On() {
		System.out.println("TV On");
		
	}

	@Override
	public void Off() {
		System.out.println("TV off");
		
	}
	
	
}

class AC implements LooseCouplingInterface {

	@Override
	public void On() {
		System.out.println("AC On");
		
	}

	@Override
	public void Off() {
		System.out.println("AC off");
		
	}
		
}
