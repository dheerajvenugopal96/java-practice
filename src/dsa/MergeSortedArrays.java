package dsa;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		Integer a[] = new Integer[] {4,6,9};
		Integer b[] = new Integer[] {5,6,7,8};
		
		Integer[] c = mergeSorted(a,b);
		for(Integer x : c) {
			System.out.print(x);
		}
	}

	private static Integer[] mergeSorted(Integer[] a, Integer[] b) {
		int n = a.length;
		int m = b.length;
		int j = 0;
		int k =0;
		int l = 0;
		Integer c[] = new Integer[n+m];
		while(j<n && k<m) {
			if(a[j]<b[k]) {
				c[l++]=a[j++];
			}else {
				c[l++]=b[k++];
			}
		}
		
		while(j < n) {
			c[l++] = a[j++];
		}
		
		while(k < m) {
			c[l++] = b[k++];
		}
		
		return c;
		
	}
}
