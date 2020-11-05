import java.io.*;

public class program {
	public static void main(String args[]) {
		File file = new File(args[0]);
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
	        String s = null;
	        char[] a=new char[1010];
	        int i;
	        char topc='#';
	        int top=-1;
	        int topb=0;
	        a[++top]='#';
	        while ((s =bReader.readLine()) != null) {
	        	String in=s;
	        	in+="\r\n";
	        	for(i=0;i<in.length();i++) {
	        		topc=a[top];
	        		if(in.charAt(i)=='+') {
	        			if(topc=='#'||topc=='(') {
	        				System.out.println("I+");
	        				a[++top]='+';
	        				if(in.charAt(i+1)=='+'||in.charAt(i+1)=='*'||in.charAt(i+1)==')'||in.charAt(i+1)=='\r') {
	        					System.out.println("RE");
	        					return;
	        				}
	        			}
	        			else if(topc=='+') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					topb--;
	        					top--;
	        					i--;
	        				}
	        			}
	        			else if(topc=='*') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					topb--;
	        					top--;
	        					i--;
	        				}
	        			}
	        			else if(topc=='i') {
	        				System.out.println("R");
	        				topb++;
	        				top--;
	        				i--;
	        			}
	        			else if(topc==')') {
	        				if(topb<1) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					top-=2;
	        					i--;
	        				}
	        			}
	        		}
	        		else if(in.charAt(i)=='*') {
	        			if(topc=='#'||topc=='('||topc=='+') {
	        				System.out.println("I*");
	        				a[++top]='*';
	        				if(in.charAt(i+1)=='+'||in.charAt(i+1)=='*'||in.charAt(i+1)==')'||in.charAt(i+1)=='\r') {
	        					System.out.println("RE");
	        					return;
	        				}
	        			}
	        			else if(topc=='*') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					topb--;
	        					top--;
	        					i--;
	        				}
	        			}
	        			else if(topc=='i') {
	        				System.out.println("R");
	        				topb++;
	        				top--;
	        				i--;
	        			}
	        			else if(topc==')') {
	        				if(topb<1) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					top-=2;
	        					i--;
	        				}
	        			}
	        		}
	        		else if(in.charAt(i)=='i') {
	        			if(topc=='#'||topc=='('||topc=='+'||topc=='*') {
	        				System.out.println("Ii");
	        				a[++top]='i';
	        			}
	        			else {
	        				System.out.println("E");
	        				return;
	        			}
	        		}
	        		else if(in.charAt(i)=='(') {
	        			if(topc=='#'||topc=='('||topc=='+'||topc=='*') {
	        				System.out.println("I(");
	        				a[++top]='(';
	        			}
	        			else {
	        				System.out.println("E");
	        				return;
	        			}
	        		}
	        		else if(in.charAt(i)==')') {
	        			if(topc=='(') {
	        				System.out.println("I)");
	        				a[++top]=')';
	        			}
	        			else if(topc=='*') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					topb--;
	        					top--;
	        					i--;
	        				}
	        			}
	        			else if(topc=='i') {
	        				System.out.println("R");
	        				topb++;
	        				top--;
	        				i--;
	        			}
	        			else if(topc==')') {
	        				if(topb<1) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					top-=2;
	        					i--;
	        				}
	        			}
	        			else if(topc=='+') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					topb--;
	        					top--;
	        					i--;
	        				}
	        			}
	        			else {
	        				System.out.println("E");
	        				return;
	        			}
	        		}
	        		else if(in.charAt(i)=='\r') {
	        			if(topc=='+') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					i--;
	        					topb--;
	        					top--;
	        				}
	        			}
	        			else if(topc=='*') {
	        				if(topb<2) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					i--;
	        					topb--;
	        					top--;
	        				}
	        			}
	        			else if(topc=='i') {
	        				System.out.println("R");
	        				i--;
	        				topb++;
	        				top--;
	        			}
	        			else if(topc==')') {
	        				if(topb<1) {
	        					System.out.println("RE");
	        					return;
	        				}
	        				else {
	        					System.out.println("R");
	        					i--;
	        					top-=2;
	        				}
	        			}
	        			else if(topc=='#') {
	        				return;
	        			}
	        			else{
	        				System.out.println("E");
	        				return;
	        			}
	        		}
	        		else {
	        			System.out.println("E");
        				return;
	        		}
	        	}
	        }
	        bReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
