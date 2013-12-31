package enviroment;

import java.util.LinkedList;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantPool;

import object.Reference;

public class Frame {
	
	/**
	 * this je lokalni promenna s indexem 0.
	 */
	public static final int THIS = 0;
	
	private Frame parent;
	private LinkedList<Reference> stack = new LinkedList<Reference>();
	private Reference[] localVariables;
	private ConstantPool constantPool;
	
	public Frame(Frame parent, ConstantPool constantPool, int countOfLocals) {
		super();
		this.parent = parent;
		this.constantPool = constantPool;
		this.localVariables = new Reference[countOfLocals];
	}
	
	public Frame getParent() {
		return parent;
	}

	public void push(Reference reference) {
		stack.addFirst(reference);
	}
	
	public Reference pop() {
		return stack.removeFirst();
	}
	
	public void setLocal(int index, Reference reference) {
		localVariables[index] = reference;
	}
	
	public Reference getLocal(int index) {
		return localVariables[index];
	}
	
	public Constant getConstant(int index) {
		return constantPool.getConstant(index);
	}

}
