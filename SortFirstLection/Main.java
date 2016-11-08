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
		
		sort(students);
		System.out.println(Arrays.toString(students));
		
	}

	private static int heapSize;
	

	public static void sort(Human[] a) {
		buildHeap(a);
		while (heapSize > 1) {
			swap(a, 0, heapSize - 1);
			heapSize--;
			heapify(a, 0);
		}
	}
	
	private static void buildHeap(Human[] a) {
		heapSize = a.length;
		for (int i = a.length / 2; i >= 0; i--) {
			heapify(a, i);
		}
	}
	
	private static void heapify(Human[] a, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < heapSize && a[i].getAverageMark() < a[l].getAverageMark()) {
			largest = l;
		} 
		if (r < heapSize && a[largest].getAverageMark() < a[r].getAverageMark()) {
			largest = r;
		}
		if (i != largest) {
			swap(a, i, largest);
			heapify(a, largest);
		}
	}
	
	private static int right(int i) {
		return 2 * i + 1;
	}
	
	
	private static int left(int i) {
		return 2 * i + 2;
	}
	
	private static void swap(Human[] a, int i, int j) {
		Human temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}