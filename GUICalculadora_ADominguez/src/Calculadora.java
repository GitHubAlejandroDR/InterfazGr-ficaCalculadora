
public class Calculadora  {
	
	/**
	 * 
	 */

	
	public double suma(double a, double b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	/**
	 * 
	 */
	
	public double resta(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}
	
	/**
	 * 
	 */

	public double mult(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	/**
	 * @throws Exception 
	 * @throws AritmeticException (if b==0) // precondition
	 * @post result*b=a
	 */
	
	
	public double divide(double a, double b){
		// TODO Auto-generated method stub
		if(b==0) {
			throw new ArithmeticException("No se puede dividir entre cero");
		}
		double result = a/b;
		assert result*b==a;
		return result;
	}

	
	public int fact(int n) {
		// TODO Auto-generated method stub
		if(n<0) {
			throw new IllegalArgumentException("Operación factorial no permitida a números negativos");
		}
		int Factorial = 1;
		for (int x = 2; x <= n; x++)
			Factorial = Factorial * x;
		return Factorial;
	}

	
	public boolean esPrimo(int n) {
		// TODO Auto-generated method stub
		if(n<0) {
			throw new IllegalStateException("Los números negativos no pueden ser primos");
		}
		if(n==0|n==1) {
			return false;
		}
		int contador = 2;
		while (contador!=n) {
			if (n % contador == 0) {
				return false;
			}
			contador++;
		}

		return true;

	}

}
