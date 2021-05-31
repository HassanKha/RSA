import java.math.BigInteger;

public class RSA {
	
	private BigInteger m;
	private BigInteger c;
	private BigInteger p=new BigInteger("3");
	private BigInteger q=new BigInteger("11");
	private BigInteger e;
	private BigInteger d;
	private BigInteger AlphaN;
	private BigInteger n;
	private BigInteger zero=new BigInteger("0");
	private BigInteger one=new BigInteger("1");
	
	public RSA(BigInteger m,BigInteger c) {
		this.m=m;
		this.c=c;
		this.n=p.multiply(q);
	}
	
	public void DoRSA() {
		Derived_NumberE();
		Derived_NumberD();
		System.out.println("Encryption Formula Value : "+EncryptionFormulaValue());
		System.out.println("Decryption Formula Value : "+DecryptionFormulaValue());
		System.out.println("e : "+this.e);
		System.out.println("D : "+this.d);
		
	}
	
	BigInteger gcd(BigInteger a, BigInteger b)
    {
    
        if (a.equals(zero))
          return b;
        if (b.equals(zero))
          return a;
      
      
        if (a.equals(b))
            return a;
      
     
        if (a.compareTo(b)==1)
            return gcd(a.subtract(b), b);
        return gcd(a, b.subtract(a));
    }
	
	public BigInteger GetCoPrime(BigInteger AlphaN,BigInteger e) {
		
		while(e.compareTo(AlphaN)!=0 && e.compareTo(AlphaN)!=1 ) {
			
		if(gcd(e,AlphaN).equals(one)) {
		

			return e;
		}
		else {
			
			e=e.add(one);
			
		}
		
		}
		
		return e;
	}
	
	public void Derived_NumberE() {
		BigInteger P=(p.subtract(one));
		BigInteger Q=(q.subtract(one));
		
		
		BigInteger AlphaN = P.multiply(Q);
		
		this.AlphaN=AlphaN;
		BigInteger e=new BigInteger("2");
		e=GetCoPrime(AlphaN,e);
		this.e=e;
	
	}
	
	
	
	public void Derived_NumberD() {
		BigInteger d=zero;
		while(d.compareTo(this.AlphaN)!=0 && d.compareTo(this.AlphaN)!=1 ) {
			BigInteger Mul=d.multiply(e);
			BigInteger relation = Mul.mod(this.AlphaN);
			if(relation.equals(one)) {
				break;
			}
			else {
				d=d.add(one);
				
			}
		}
		this.d=d;
	}
	
	public BigInteger EncryptionFormulaValue() {
		BigInteger Encryption=this.m.modPow(this.e, this.n);
		return Encryption;
	}
	
	public BigInteger DecryptionFormulaValue() {
		BigInteger Decryption= this.c.modPow(this.d, this.n);
		return Decryption;
	}
	
}
