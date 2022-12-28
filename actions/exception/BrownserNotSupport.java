package exception;

public class BrownserNotSupport extends IllegalArgumentException{

	private static final long serialVersionUID = 1L;
	
	public BrownserNotSupport (String brownserName) {
		super(String.format("Brownser with name = %s is not support", brownserName.toUpperCase()));
	}

}
