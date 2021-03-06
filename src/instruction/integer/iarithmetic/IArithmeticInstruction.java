package instruction.integer.iarithmetic;

import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public abstract class IArithmeticInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		Reference reference1 = frame.pop();
		Reference reference2 = frame.pop();
		checkInteger(reference1);
		checkInteger(reference2);
		Integer integer1 = ((IntegerObject)reference1.getObject()).getValue();
		Integer integer2 = ((IntegerObject)reference2.getObject()).getValue();
		IntegerObject result = new IntegerObject(getResult(integer2, integer1));
		heap.addObject(result);
		frame.push(result);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract Integer getResult(Integer operand1, Integer operand2);

}
