import java.util.ArrayList;

import org.w3c.dom.Element;


public class Program {
	private String name;
	private String code;
	private int women;
	private int men;
	
	public Program(String name, String code, int women, int men){
		this.name = name;
		this.code = code;
		this.women = women;
		this.men = men;
	}
	
	public String getName(){
		return name;
	}
	
	public String getCode(){
		return code;
	}
	
	public int getWomen(){
		return women;
	}
	
	public int getMen(){
		return men;
	}
	
	public String toString(){
		return name;
	}
}
