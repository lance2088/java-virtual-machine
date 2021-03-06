package instruction.integer.istore;

import instruction.store.StoreInstruction;
import object.Reference;


public class IstoreInstruction extends StoreInstruction {
	
	public static final String OPCODE = "36";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
