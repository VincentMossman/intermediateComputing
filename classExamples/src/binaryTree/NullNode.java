package binarytree;

public class NullNode extends TreeNode 
{
	//Default Constructor
	public NullNode()
	{
		super(-1);
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
		this.value = aValue;
	}
	
	public void clearTree()
	{
		//Do nothing
	}
	
	public boolean valueInTree(int aValue)
	{
		return false;
	}
	
	public int getHeight()
	{
		return 0;
	}
}
