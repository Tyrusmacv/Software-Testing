package new1;

public class money {
	public money(){}
	
	public boolean check(int a){
		if(a<0||a>83)
		{
			return false;
		}
		else
		{
			if(a>33&&a<50)
					return false;
				else
				{
					if(a%5 <= 3)
					{
						return true;
					}
					else
					{
						return false;
					}
			}
		}
	}

}
