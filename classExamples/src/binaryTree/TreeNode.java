package binarytree;

/**
 * In class assignment. HomeWork 8 - Binary Tree.
 * @author Vincent T. Mossman
 */

public class TreeNode 
{
	//--------------------
	//Instance Variables
	//--------------------
	protected int 	 value;
	protected TreeNode leftNode;
	protected TreeNode rightNode;
	
	//Default Constructor
	public TreeNode(int aValue)
	{
		this.value     = aValue;
		this.leftNode  = new NullNode();
		this.rightNode = new NullNode();
	}
	
	//--------------------
	//Class Methods
	//--------------------
	public int getValue()
	{
		return this.value;
	}
	
	public void addNode(int aValue)
	{
		if (aValue < this.getValue())
		{
			leftNode.addNode(aValue);
		}
		else
		{
			rightNode.addNode(aValue);
		}
	}
	
	public void clearTree()
	{
		this.value	   = 0;
		this.leftNode  = new NullNode();
		this.rightNode = new NullNode();
	}
	
	public boolean valueInTree(int aValue)
	{
		if (this.getValue() == aValue)
		{
			return true;
		}
		else
		{
			return (leftNode.valueInTree(aValue) || rightNode.valueInTree(aValue));
		}
	}
	
	public int getHeight()
	{
		if (leftNode.getHeight() < rightNode.getHeight())
		{
			return leftNode.getHeight() + 1;
		}
		else
		{
			return rightNode.getHeight() + 1;
		}
	}
}
