import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	
	public static void main(String[] args) throws IOException{
		ATimer at = new ATimer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String cmd;	
		
		while(true){
			cmd = null;
			System.out.print(">");
			cmd = br.readLine();
			if(cmd == null){
				System.out.println("['']'' is not command.");
			}else switch(cmd){
				case "start":
					System.out.print("name>");
					cmd = br.readLine();
					at.start(cmd);
				break;
				case "end":
					at.end();
					at = new ATimer();
				break;
				case "stop":
					at.stop();
				break;
				case "log":
					at.log();
				break;
				case "exit":
					System.exit(0);
				break;
				default:
					System.out.println("["+cmd+"]"+cmd+" is not command.");
				break;
			}
		}
		
	}
}