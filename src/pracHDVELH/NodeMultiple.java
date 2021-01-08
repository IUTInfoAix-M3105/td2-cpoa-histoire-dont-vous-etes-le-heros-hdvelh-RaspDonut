/**
 * File: NodeMultiple.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import myUtils.ErrorNaiveHandler;

import java.util.ArrayList;

/**
 * @author prost
 *
 */
public class NodeMultiple {
	public static final int ERROR_STATUS_INDEX_OUT_OF_RANGE = -1;
	public static final String ERROR_MSG_INDEX_OUT_OF_RANGE = "Index out of range";
	public static int NODE_MAX_ARITY = 10;

	private Object data;

	private NodeMultiple[] daughters = new NodeMultiple[NODE_MAX_ARITY];

	/* Overridden methods */
	@Override
	public String toString() {
		return data.toString();
	}

	/* Getters/Setters */

	/**
	 * Gets the {@code i}th daughter node.
	 * <p>
	 * Aborts if the given index {@code i} is out of range.
	 *
	 * @param i the index of the daughter node.
	 * @return the {@code i}th daughter node, or {@code null} if it does not exist.
	 */
	public NodeMultiple getDaughter(int i) {
		return daughters[i];
	}

	/**
	 * Sets the {@code i}th daughter node to the input parameter {@code daughter}.
	 * Should be used cautiously, since {@code i} may not be the first index
	 * available (i.e. there may be lower indexes which do not refer to any
	 * daughter).
	 * <p>
	 * If a daughter node is already referred to at this index then it is erased
	 * with {@code daughter}.
	 * <p>
	 * Aborts if the index {@code i} is out of range.
	 *
	 * @param daughter the node to be linked as a daughter of {@code this} node.
	 * @param i        the daughter node's index
	 */
	public void setDaughter(NodeMultiple daughter, int i) {
		daughters[i-1] = daughter;
	}

	/**
	 * @return all the daughters
	 */
	public NodeMultiple[] getDaughters() {
		return daughters;
	}

	/**
	 * @param daughters the daughters to set
	 */
	public void setDaughters(NodeMultiple[] daughters) {
		this.daughters = daughters;
	}

	/**
	 * Adds the given {@code daughter} node at the first available index.
	 * <p>
	 * If the max number of daughters ({@link #NODE_MAX_ARITY}) is already reached
	 * nothing happens (no abort).
	 *
	 * @param daughter
	 */
	public void addDaughter(NodeMultiple daughter) {
		for(int i = 0; i < NODE_MAX_ARITY;i++){
			if(getDaughter(i) == null){
				setDaughter(daughter,i);
				return;
			}
		}
	}

	/**
	 * @return the content data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return {@code true} if and only if this node has at least one non-null
	 * daughter node.
	 */
	public boolean hasDaughters() {
		for (NodeMultiple daughter : daughters) {
			if (daughter != null) return true;
		}
		return false;
	}

	/* Constructors */

	/**
	 * Default constructor.
	 */
	public NodeMultiple() {
		/* TO BE COMPLETED */
	}

	/**
	 * Constructor. Sets the content data to {@code data} and creates an empty set
	 * of daughters.
	 *
	 * @param data
	 */
	public NodeMultiple(Object data) {
		setData(data);
	}
}
// eof