package instruction.load;

import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public abstract class AbstractLoadInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.getLocal(getLoadIndex(bytecode, bytecodeIndex));
		checkType(reference);
		frame.push(reference);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract int getLoadIndex(byte[] bytecode, int bytecodeIndex);
	
	protected abstract void checkType(Reference reference);

}