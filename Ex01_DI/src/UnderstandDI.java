import java.util.Date;

public class UnderstandDI
{

	public static void main(String[] args)
	{
		Date date = new Date(); // 강한 결합
		System.out.println(date); // 출력됨

	}
	
	private static void getDate(Date d)
	{
		Date  date = d; // 약한 결합
		System.out.println(date); // 출력 안됨
	}
	
	public static void memberUse1()
	{
		Member member1 = new Member(); // 강한 결합
	}
	
	public static void memberUse2(Member m)
	{
		Member member2 = m; // 약한 결합 - 의존 주입 
	}	

}

class Member
{
	String name;
	String nickname;
	public  Member() { }
	//private  Member() { }  강한 결합은 오류가 난다.
}
