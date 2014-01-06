package instruction.object;

import instruction.AbstractInstruction;
import object.JavaObject;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.JavaClass;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;

public class NewInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "BB";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		int index = getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
		Constant constant = frame.getConstant(index);
		int nameIndex = ((ConstantClass)constant).getNameIndex();
		Constant nameConstant = frame.getConstant(nameIndex);
		String className = ((ConstantUtf8)nameConstant).getBytes();
		// TODO tady rozhodovat, zda tridu simulovat nebo opravdu vytvorit objekt
		JavaClass loadedClass = ClassLoader.loadClass(className);
		JavaObject object = new JavaObject(loadedClass);
		heap.addObject(object);
		frame.push(object);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
