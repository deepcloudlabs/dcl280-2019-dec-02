public class StudyTextBlock {
   private static final String jack = """
           {
               "identity" : "12345678910",
               "fullname" : "Jack Bauer",
               "iban" : "TR80123123123123",  
               "salary" : 100000,
               "birthYear" : 1956   
           }  
   """ ;
   public static void main(String[] args){
	System.out.println(jack);
   }	
}