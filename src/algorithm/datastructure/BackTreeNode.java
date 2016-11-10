package algorithm.datastructure;

public class BackTreeNode {
	private String str;
	private BackTreeNode parent;

	public BackTreeNode(String str, BackTreeNode parent) {
        this.str = str;
        this.parent = parent;
    }
	   
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public BackTreeNode getParent() {
		return parent;
	}

	public void setParent(BackTreeNode parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "BackTreeNode [str=" + str + "]";
	}

	public static void main(String[] args){
		BackTreeNode btn = new BackTreeNode("abc", null);
		System.out.println(btn.toString());
	}
}
