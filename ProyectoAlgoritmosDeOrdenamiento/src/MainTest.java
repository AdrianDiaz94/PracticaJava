
public class MainTest {

	public static void main(String[] args) {
	int vec[]= {7,11,2,10,5,4,1,14,0,3,6,1};
	QuickSort.ordenar(0,vec.length-1,vec);
	for(int i=0;i<vec.length;i++) {
		System.out.println(vec[i]);
	}
	

	}
}
