package set;

public class UniqueElements {
	
	public static void main (String[] args) {
		int[] ints = {1, 2, 3, 3, 7, 8, 8};
		ints = uniqueElements(ints);
		
		for(int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		
	}
	
	public static int[] uniqueElements(int[] ints) {
		
		MaxSet<Integer> s = new MaxSet<Integer>();
		
		for(int i : ints) {
			s.add(i);
		}
		
		int[] sort = new int[s.size()];
		
		for(int i = s.size() - 1; i >= 0; i--) {
			int max = s.getMax();
			if(sort[i] == max) {
				s.remove(max);
			}
			sort[i] = max;
			s.remove(max);
			
			
		}
		return sort;
		
		
	}
}
