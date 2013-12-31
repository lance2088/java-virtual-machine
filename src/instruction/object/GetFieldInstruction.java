package instruction.object;

import object.JavaObject;
import object.Reference;
import instruction.AbstractInstruction;
import enviroment.Frame;
import enviroment.Heap;

public class GetFieldInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B4";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		FieldOrMethodInfo fieldInfo = getFieldOrMethodInfo(frame, bytecode, bytecodeIndex);
		Reference objectReference = frame.pop();
		
		checkObject(objectReference);
		// TODO dodelat kontrolu typu
		
		JavaObject object = (JavaObject) objectReference.getObject();
		Reference valueReference = object.getField(fieldInfo.name);
		frame.push(valueReference.getObject());
		
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
