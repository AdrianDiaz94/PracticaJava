package paquete;

public class MainTest{


	int cruceMinimo(int v[]) {
		int i=0,J=5,k,K,j,n,m=2147483647;
		while (i<7){						
			j=i==6? 4:1;			
			while(j<J) {
				K=j==1? 6:9;
				k=j==7? 5:2;
				while(k<K){		
					n=v[i]+v[j]+v[k];
					m=m<n? m:n;
					k+=3;
				}
				j+=3;
			}
			J=8;
			i+=3;
		}
		return m;	
}

		
	
	
}
