class Human {

	private String name;
	private int age;
	private int[] marks;
	private float averageMark;

	public Human(String name, int age, int[] marks){
		this.name = name;
		this.age = age;
		if (marks!=null) {
			this.marks = marks;
			calcAverageMarks();
		}
	}

	public int getAge(){
		return this.age;
	}

	public String getName(){
		return this.name;
	}

	public int[] getMarks(){
		return this.marks;
	}

	public float getAverageMark(){
		return this.averageMark;
	}

	public void setAge(int age){
		this.age = age;
	}

	public void setName(String name){
		this.age = age;
	}

	public void setMarks(int[] marks){
		this.marks = marks;
		calcAverageMarks();
	}

	private void calcAverageMarks(){
		
		float result = 0;
		int count = 0;

		for (Integer mark : getMarks()) {
			if(mark > 0){
				result += mark;
				count++;
			}
		}

		this.averageMark = result/count;
	}

	public String toString() {
	    		 return "Human{" + name +
                ", " + averageMark + '}';
    }

}