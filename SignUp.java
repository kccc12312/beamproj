package application;

public class SignUp {
	
	private static String name=" ";
	private static String idNum=" ";
	private static char gender=' ';
	private static int phoneNum=0;
	private static String nationality;
	private static String dLicense;
	private static String username;
	private static String password;
	
	SignUp(){
		
	}
	SignUp(String name,String idNum,char gender,int phoneNum,String nationality,String dLicense,String username,String password){
		this.name=name;
		this.idNum=idNum;
		this.gender=gender;
		this.phoneNum=phoneNum;
		this.nationality=nationality;
		this.dLicense=dLicense;
		this.username=username;
		this.password=password;
	}

	public static String getName() {
	    return name;
	  }
	public static String getIdNum() {
	    return idNum;
	  }
	public static char getGender() {
	    return gender;
	  }
	public static int getPhoneNum() {
	    return phoneNum;
	  }
	public static String getNationality() {
	    return nationality;
	  }
	public static String getDLicense() {
	    return dLicense;
	  }
	public static String getUsername() {
	    return username;
	  }
	public static String password() {
		return password;
	}
	
	public static void setName(String name1){
		name=name1;
	   }

	public static void setIdNum(String idNum1){
	      idNum=idNum1;
	   }
	public static void setGender(char gender1) {
		gender=gender1;
	}
	public static void setPhoneNum(int phoneNum1) {
		phoneNum=phoneNum1;
		}
	public static void setNationality(String nationality1) {
	    nationality=nationality1;
	  }
	public static void setDLicense(String dLicense1) {
	    dLicense=dLicense1;
	  }
	public static void setUsername(String username1) {
	    username=username1;
	  }
	public static void setPassword(String password1) {
		password=password1;
	}
	
}

