import java.io.IOException;
import java.util.logging.Level;

public class Calculadora {
    public float calcular(float a, float b, char operacao) throws IOException {
        float resultado = 0;
        switch (operacao) {
            case '+': {
            	Log meuLogger = new Log("Log.txt");
    			
    			try {
    			meuLogger.logger.setLevel(Level.FINE);
    			meuLogger.logger.info("Selecionado opção de adição");
    			meuLogger.logger.info("calculando resultado...");
                resultado = a + b;
    		} 
    		catch (Exception e) {
    			meuLogger.logger.info("Exception:" + e.getMessage());
    			e.printStackTrace();
            }
            break;
            }
            case '-': {
            	  Log meuLogger = new Log("Log1.txt");
            		try {
                    		meuLogger.logger.setLevel(Level.FINE);
    			meuLogger.logger.info("Selecionado opção de subtração");
    			meuLogger.logger.info("calculando resultado...");
    		    
            		}
            		catch (Exception e) {
            			meuLogger.logger.info("Exception:" + e.getMessage());
            			e.printStackTrace();
            }
                if (a < b) {
                    resultado = b - a;
                } else {
                    resultado = a - b;
      
                }
            break;
                }
            case '/': {
            	 Log meuLogger = new Log("Log1.txt");
         		try {
                meuLogger.logger.setLevel(Level.FINE);
 			meuLogger.logger.info("Selecionado opção de divisão");
 			meuLogger.logger.info("calculando resultado...");
            resultado = a / b;
 		    
         		}
         		catch (Exception e1) {
         			meuLogger.logger.info("Exception:" + e1.getMessage());
         			e1.printStackTrace();
            }
            break;
            }
            case '*': {
              	 Log meuLogger = new Log("Log1.txt");
          		try {
                 meuLogger.logger.setLevel(Level.FINE);
  			meuLogger.logger.info("Selecionado opção de multiplicação");
  			meuLogger.logger.info("calculando resultado...");
             resultado = a / b;
  		    
          		}
          		catch (Exception e2) {
          			meuLogger.logger.info("Exception:" + e2.getMessage());
          			e2.printStackTrace();
             }
                resultado = a * b;
            }
            break;
        }
        return resultado;
    }
}