package instruction.array.load;

import object.Reference;

public class IArrayLoadInstruction extends AbstractArrayLoadInstruction {
	
	public static final String OPCODE = "2E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkValue(Reference valueReference) {
		checkInteger(valueReference);
	}

}
