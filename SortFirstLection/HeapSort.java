class HeapSort{
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