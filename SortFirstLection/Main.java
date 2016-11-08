import java.util.Arrays;

class Main{
	public static void main(String[] args) {
		Human[] students = new Human[5];
		int[] petroMarks = {5,4,3,1,5};
		int[] kolyaMarks = {3,3,3,3,5};
		int[] valyaMarks = {5,4,5,5,5};
		int[] zinaMarks = {3,3,2,5,5};
		int[] zorroMarks = {5,4,5,4,3};

		students[0] = new Human("Petro", 22, petroMarks);
		students[1] = new Human("Kolya", 20, kolyaMarks);
		students[2] = new Human("Valya", 25, valyaMarks);
		students[3] = new Human("Zina", 30, zinaMarks);
		students[4] = new Human("Zorro", 15, zorroMarks);

		HeapSort.sort(students);
		System.out.println(Arrays.toString(students));
		
	}
}