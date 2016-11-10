package algorithm.datastructure;

public class Manager extends Employee {
	private String managerLevel;

    public Manager(String managerName, String managerLevel) {
        super(managerName);
        this.managerLevel = managerLevel;
    }

	public String getManagerLevel() {
		return managerLevel;
	}

	public void setManagerLevel(String managerLevel) {
		this.managerLevel = managerLevel;
	}
}
