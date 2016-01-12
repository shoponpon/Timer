import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ATimer{
	private ArrayList<Long> list;
	private String workname;
	private long time;
	private long stopstart;
	private boolean stop;
	
	public ATimer(){
		time = 0;
		stop = false;
		workname = null;
	}
		
	public void start(String workname){
		this.workname = workname;
		list = new ArrayList<Long>();
		this.time = System.currentTimeMillis();
		System.out.println("start...");
	}
	
	public void end(){
		long end = System.currentTimeMillis();
		this.time = end - this.time;
		if(list.size()!=0){
			for(int i = 0;i<list.size();i++){
				this.time -= list.get(i);
			}
		}
		write();
		System.out.println("end....");
	}
	
	public void stop(){
		if(stop){
			long end = System.currentTimeMillis();
			list.add(end-this.stopstart);
			stop = false;
			System.out.println("restart...");
		}else{
			this.stopstart = System.currentTimeMillis();
			stop = true;
			System.out.println("stop...");
		}
	};
	
	public void log(){
		try{
			File file = new File("./logfile");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str=br.readLine())!=null){
				System.out.println(str);				
			}
		}catch(IOException e){
			System.out.println("log was not accessed");
		}
	}
	
	void write(){
		try{
			long hour = 0;
			long min = 0;
			long sec = 0;
			
			sec = time / 1000;
			min = sec / 60;
			sec %= 60;
			hour = min / 60;
			min %= 60;
			
			File file = new File("./logfile");
			FileWriter fw = new FileWriter(file,true);
			fw.write("###"+workname+"###\n");
			fw.write(hour+"時間"+min+"分"+sec+"秒");
			fw.write("\n");
			fw.close();
		}catch(IOException e){
			System.out.println("log was not saved.");
		}
	}
}