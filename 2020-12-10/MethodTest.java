public class MethodTest
{
	public static void main(String []args){
		MethodTest test=new MethodTest();
		boolean l=test.login("zs","zs123");
		if(l==true)
			System.out.println("login home page!");
		else System.out.println("username or password errors!");
	}

	public boolean login(String username,String password){
		if(username=="zs"&&password=="zs123")
			return true;
		else return false;
	}
}